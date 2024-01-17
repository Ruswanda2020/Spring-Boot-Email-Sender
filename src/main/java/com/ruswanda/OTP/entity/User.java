package com.ruswanda.OTP.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

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
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(nullable = false, unique = true)
    private String username;
    @NotEmpty @Column(nullable = false, unique = true)
    private String email;
    private String otp;
    private boolean verified;
}
