package com.example.test.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail,
                            String body,
                            String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("wasselaguech@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);

        System.out.println ("Email successfully send!!!!!");
    }


}
