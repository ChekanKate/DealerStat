package com.chekan.leverX.service.impl;

import com.chekan.leverX.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private MailSender mailSender;

    @Override
    public String sendMail(String toEmail) {

        Integer x = 1000 + (int) (Math.random() * ((9999 - 1000) + 1));
        String code = x.toString();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toEmail);
        message.setFrom("chekankate@gmail.com");
        message.setSubject("DealerStat activation");
        message.setText("Hello! Your account activation code: " + code);

        mailSender.send(message);

        return code;
    }

}
