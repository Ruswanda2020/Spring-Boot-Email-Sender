package com.ruswanda.OTP.service.impl;

import com.ruswanda.OTP.dto.RegisterDto;
import com.ruswanda.OTP.dto.ResponseRegisterDto;
import com.ruswanda.OTP.entity.User;
import com.ruswanda.OTP.exception.ApiException;
import com.ruswanda.OTP.repository.UserRepository;
import com.ruswanda.OTP.service.EmailService;
import com.ruswanda.OTP.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * Project : OTP
 * User: Ruswanda
 * Email: wandasukabumi2020@gmail.com
 * Telegram : @Ruswanda
 * Date: 17/01/24
 * Time: 08.47
 */
@Service @Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  EmailService emailService;


    @Override
    public ResponseRegisterDto registerUser(RegisterDto registerDto) throws MessagingException {

        ResponseRegisterDto response = new ResponseRegisterDto();

        if (userRepository.existsByEmail(registerDto.getEmail())){
            throw new ApiException(HttpStatus.BAD_REQUEST, "Email is Already Exists!");
        }
        if (userRepository.existsByUsername(registerDto.getUsername())){
            throw new ApiException(HttpStatus.BAD_REQUEST, "username is Already Exists!");
        }

        Random random = new Random();
        String otpFormat = String.format("%06d", random.nextInt(100000));
        User newUser = new User();
        newUser.setUsername(registerDto.getUsername());
        newUser.setEmail(registerDto.getEmail());
        newUser.setOtp(otpFormat);
        newUser.setVerified(false);

       User savedUser =  userRepository.save(newUser);
       String subject = "Email Verification";
       String body = "Your Verification OTP is "+ savedUser.getOtp();
       //Email send
        emailService.sendEmail(savedUser.getEmail(), subject, body);
        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());
        response.setEmail(savedUser.getEmail());
        response.setMessage("OTP sent successfully!");


        return response;
    }

    public String verifyUser(String email, String otp){

        String response = "";
        User user = userRepository.findByEmail(email);

        if (user != null && user.isVerified()){
            response = "User is Already Verified.";
        } else if (otp.equals(user.getOtp())) {
            user.setVerified(true);
            userRepository.save(user);
            response = "User Verified Successfully";
        }else {
            response = "User Not Verified.";
        }

        return response;
    }
}
