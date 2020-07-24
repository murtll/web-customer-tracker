package com.murtll.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMessage(SimpleMailMessage message) {
        mailSender.send(message);
    }

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
//        TODO NOT IMPLEMENTED YET
    }
}
