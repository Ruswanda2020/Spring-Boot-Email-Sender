package com.ruswanda.OTP.service;

import jakarta.mail.MessagingException;
/**
 * Created by IntelliJ IDEA.
 * Project : OTP
 * User: Ruswanda
 * Email: wandasukabumi2020@gmail.com
 * Telegram : @Ruswanda
 * Date: 17/01/24
 * Time: 08.47
 */

public interface EmailService {

    void sendEmail(String to, String subject, String body) throws MessagingException;
}
