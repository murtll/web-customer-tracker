package com.murtll.springdemo.service;

import com.murtll.springdemo.utils.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Objects;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMessage(SimpleMailMessage message) {
        mailSender.send(message);
    }

    @Override
    public void sendMimeMessage(MimeMessage message) {
        mailSender.send(message);
    }

    @Override
    public boolean sendMimeMessage(EmailModel model) {
        try {

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

            helper.setFrom(model.getFrom());
            helper.setTo(model.getTo());
            helper.setSubject(model.getSubject());
            helper.setText(model.getText(), true);

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean sendMimeMessage(EmailModel model, File file) {
        try {

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

            FileSystemResource fileSystemResource = new FileSystemResource(file);

            helper.setFrom(model.getFrom());
            helper.setTo(model.getTo());
            helper.setSubject(model.getSubject());
            helper.setText(model.getText(), true);

            if (file.exists()) helper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()), fileSystemResource);

            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }


        return true;
    }

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
//        TODO NOT IMPLEMENTED YET
    }
}
