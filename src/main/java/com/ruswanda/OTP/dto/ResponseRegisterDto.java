package com.ruswanda.OTP.dto;

import lombok.Data;
/**
 * Created by IntelliJ IDEA.
 * Project : OTP
 * User: Ruswanda
 * Email: wandasukabumi2020@gmail.com
 * Telegram : @Ruswanda
 * Date: 17/01/24
 * Time: 08.47
 */

@Data
public class ResponseRegisterDto {

    private Long id;
    private String username;
    private String email;
    private boolean verified;
    private String message;
}
