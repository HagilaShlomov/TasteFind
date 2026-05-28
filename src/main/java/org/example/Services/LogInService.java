package org.example.Services;

import lombok.AllArgsConstructor;
import org.example.Entity.User;
import org.example.Repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("Invalid credentials");
        }

        if (!passwordEncoder.matches(password, user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        return user; // בשלב מתקדם מחזירים Token
    }
}
