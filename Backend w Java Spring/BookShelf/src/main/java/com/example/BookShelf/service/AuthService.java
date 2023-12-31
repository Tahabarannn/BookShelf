package com.example.BookShelf.service;

import com.example.BookShelf.dto.ErrorCode;
import com.example.BookShelf.dto.TokenResponseDto;
import com.example.BookShelf.dto.UserDto;
import com.example.BookShelf.dto.request.LoginRequest;
import com.example.BookShelf.dto.request.SignUpRequest;
import com.example.BookShelf.exception.GenericException;
import com.example.BookShelf.model.Role;
import com.example.BookShelf.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService{

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenService tokenService;

    private final PasswordEncoder encoder;

    public TokenResponseDto login(LoginRequest loginRequest) {
        try {
            Authentication auth = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            return TokenResponseDto
                    .builder()
                    .accessToken(tokenService.generateToken(auth))
                    .userDto(userService.findUser(loginRequest.getUsername()))
                    .build();
        } catch (final BadCredentialsException badCredentialsException) {
            throw GenericException.builder().httpStatus(HttpStatus.NOT_FOUND).errorCode(ErrorCode.USER_NOT_FOUND).errorMessage("Invalid Username or Password").build();
        }
    }


    @Transactional
    public UserDto signup(SignUpRequest signUpRequest){
        var isAllReadyRegistered = userService.existsByUsername(signUpRequest.getUsername());

        if(isAllReadyRegistered) {
            throw GenericException.builder().httpStatus(HttpStatus.FOUND)
                    .errorMessage("Username" + signUpRequest.getUsername() + "is already used").build();
        }

        var user = User.builder()
                .username(signUpRequest.getUsername())
                .password(encoder.encode(signUpRequest.getPassword()))
                .role(Role.USER)
                .build();

        User fromDb = userService.create(user);

        return UserDto.builder()
                .id(fromDb.getId())
                .username(fromDb.getUsername())
                .role(fromDb.getRole())
                .build();

    }
}