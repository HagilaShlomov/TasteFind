package org.example.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.example.DTO.LoginRequest;
import org.example.DTO.LogoutRequest;
import org.example.Entity.User;
import org.example.Services.LogInService;
import org.example.Services.LogOutService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authService")
public class LogInController {

    private final LogInService logInService;

    public LogInController(LogInService logInService) {
        this.logInService = logInService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = logInService.login(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );
        return ResponseEntity.ok(user);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseEntity.ok("Logged out");
    }


}
