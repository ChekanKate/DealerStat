package com.chekan.leverX.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendMail(String toEmail){

        String uuid = UUID.randomUUID().toString();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toEmail);
        message.setFrom("chekankate@gmail.com");
        message.setSubject("HI");
        message.setText(uuid);

        mailSender.send(message);

    }

}
