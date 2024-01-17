package com.ruswanda.OTP.controller;

import com.ruswanda.OTP.dto.RegisterDto;
import com.ruswanda.OTP.dto.ResponseRegisterDto;
import com.ruswanda.OTP.service.UserService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * Project : OTP
 * User: Ruswanda
 * Email: wandasukabumi2020@gmail.com
 * Telegram : @Ruswanda
 * Date: 17/01/24
 * Time: 08.47
 */

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<ResponseRegisterDto> registerUser(@RequestBody RegisterDto registerDto) throws MessagingException {
        log.info("Received registration request for email: {}", registerDto.getEmail());
        ResponseRegisterDto response = userService.registerUser(registerDto);
        log.info("Registration response for email {}: {}", registerDto.getEmail(), response.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/user-verify")
    public ResponseEntity<?> verifyUser(@RequestParam String email,
                                        @RequestParam String otp){
        log.info("Received user verification request for email: {}", email);
        String response = userService.verifyUser(email, otp);
        log.info("User verification response for email {}: {}", email, response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
