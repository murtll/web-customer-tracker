package com.murtll.springdemo.aspect;

import com.murtll.springdemo.utils.Utils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

//    get logger
    private final Logger logger = Logger.getLogger(getClass().getName());

//    setup pointcut declarations
    @Pointcut("execution(* com.murtll.springdemo.controller.*.*(..))")
    private void inControllerPackage() {}

    @Pointcut("execution(* com.murtll.springdemo.repository.*.*(..))")
    private void inRepositoryPackage() {}

    @Pointcut("execution(* com.murtll.springdemo.service.*.*(..))")
    private void inServicePackage() {}

    @Pointcut("inControllerPackage() || inRepositoryPackage() || inServicePackage()")
    private void inNeededPackages() {}

//    add @Before
    @Before("inNeededPackages()")
    public void logStart(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();

        if (args.length > 0) {
            String methodName = joinPoint.getSignature().toString();

            logger.info(Utils.addArgsToMethod("Execution of the method '" + methodName + "' started", args));
        } else {
            String methodName = joinPoint.getSignature().toShortString();

            logger.info("Execution of the method '" + methodName + "' started");
        }

    }

//    add @AfterReturning
    @AfterReturning(value = "inNeededPackages()", returning = "result")
    public void logReturning(JoinPoint joinPoint, Object result) {

        Object[] args = joinPoint.getArgs();

        if (args.length > 0) {
            String methodName = joinPoint.getSignature().toString();

            if (result != null) {
                logger.info(Utils.addArgsToMethod("Method '" + methodName + "' ", args) + "' returned " + result);
            } else {
                logger.info(Utils.addArgsToMethod("Method '" + methodName + "' ", args) + "' executed successfully");
            }
        } else {
            String methodName = joinPoint.getSignature().toShortString();

            if (result != null) {
                logger.info("Method '" + methodName + "' returned " + result);
            } else {
                logger.info("Method '" + methodName + "' executed successfully");
            }
        }

    }

//    add @AfterThrowing
    @AfterThrowing(value = "inNeededPackages()", throwing = "e")
    public void logThrowing(JoinPoint joinPoint, Exception e) {

        Object[] args = joinPoint.getArgs();

        if (args.length > 0) {
            String methodName = joinPoint.getSignature().toString();

            logger.info(Utils.addArgsToMethod("Execution of the method '" + methodName + "' failed", args) +
                    "\nCause: " + e);
        } else {
            String methodName = joinPoint.getSignature().toShortString();

            logger.info("Execution of the method '" + methodName + "' failed" +
                    "\nCause: " + e);
        }


    }

}
