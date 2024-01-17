package com.ruswanda.OTP.service;

import com.ruswanda.OTP.dto.RegisterDto;
import com.ruswanda.OTP.dto.ResponseRegisterDto;
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
public interface UserService {

    ResponseRegisterDto registerUser(RegisterDto responseDto) throws MessagingException;
    String verifyUser(String email, String otp);
}
