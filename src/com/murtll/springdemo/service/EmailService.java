package com.murtll.springdemo.service;

import com.murtll.springdemo.utils.EmailModel;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.io.File;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

    void sendSimpleMessage(SimpleMailMessage message);

    void sendMimeMessage(MimeMessage message);

    boolean sendMimeMessage(EmailModel model);

    boolean sendMimeMessage(EmailModel model, File file);

}
