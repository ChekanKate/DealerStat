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
    public String sendMail(String toEmail){

        String uuid = UUID.randomUUID().toString();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toEmail);
        message.setFrom("chekankate@gmail.com");
        message.setSubject("DealerStat activation");
        message.setText("Hello! Your account activation code: " + uuid);

        mailSender.send(message);

        return uuid;
    }

}
