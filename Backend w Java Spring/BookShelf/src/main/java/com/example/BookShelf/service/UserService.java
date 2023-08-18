package com.example.BookShelf.service;

import com.example.BookShelf.dto.UserDto;
import com.example.BookShelf.exception.GenericException;
import com.example.BookShelf.model.User;
import com.example.BookShelf.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var savedUser = userRepository.save(user);
        return UserDto.builder()
                .username(savedUser.getUsername())
                .role(savedUser.getRole())
                .build();
    }

    public UserDto getUser(String username){
        var savedUser = findUserByUsername(username);
        return UserDto.builder()
                .username(savedUser.getUsername())
                .role(savedUser.getRole())
                .build();
    }

    public User findUserByUsername(String username){
        return userRepository.findByUsername(username)
                .orElseThrow(() -> GenericException.builder()
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .errorMessage("User not found by given id")
                        .build());
    }
}
