package org.example.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.example.DTO.LoginRequest;
import org.example.Entity.User;
import org.example.Services.LogInService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/authService")
public class LogInController {

    private final LogInService logInService;

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
