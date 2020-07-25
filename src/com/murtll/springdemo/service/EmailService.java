package com.murtll.springdemo.service;

import com.murtll.springdemo.utils.EmailModel;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

    void sendSimpleMessage(SimpleMailMessage message);

    void sendMimeMessage(MimeMessage message);

    boolean sendMimeMessage(EmailModel model);

}
