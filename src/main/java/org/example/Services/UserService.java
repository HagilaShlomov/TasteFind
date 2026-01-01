package org.example.Services;

import org.example.Entity.User;
import org.example.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) throw new IllegalArgumentException("Email already exists");
        if (userRepository.existsByUsername(user.getUsername())) throw new IllegalArgumentException("Username already exists");

        userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

