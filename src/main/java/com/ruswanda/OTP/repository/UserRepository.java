package com.ruswanda.OTP.repository;

import com.ruswanda.OTP.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : OTP
 * User: Ruswanda
 * Email: wandasukabumi2020@gmail.com
 * Telegram : @Ruswanda
 * Date: 17/01/24
 * Time: 08.47
 */

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    User findByEmail(String email);
}
