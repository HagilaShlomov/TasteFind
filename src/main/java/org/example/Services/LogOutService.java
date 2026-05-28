package org.example.Services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.example.Entity.User;
import org.example.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LogOutService {

    public void logout(HttpServletRequest request) {
        request.getSession().invalidate();
    }
}
