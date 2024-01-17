package com.ruswanda.OTP.service.impl;

import com.ruswanda.OTP.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : OTP
 * User: Ruswanda
 * Email: wandasukabumi2020@gmail.com
 * Telegram : @Ruswanda
 * Date: 17/01/24
 * Time: 08.47
 */
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

   private final JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String subject, String body){

        try {
            MimeMessage massage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(massage, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);
            javaMailSender.send(massage);
        }catch (MessagingException e){
            e.printStackTrace();
        }

    }
}
