package com.ruswanda.OTP.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class RegisterDto {
    @NotNull @NotEmpty
    private Long id;
    @NotNull @NotEmpty
    private String username;
    @NotNull @NotEmpty
    private String email;

}
