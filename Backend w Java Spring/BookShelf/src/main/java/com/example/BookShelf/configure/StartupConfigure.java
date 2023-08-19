package com.example.BookShelf.configure;

import com.example.BookShelf.model.Role;
import com.example.BookShelf.model.User;
import com.example.BookShelf.service.UserService;
import org.springframework.boot.CommandLineRunner;

public class StartupConfigure implements CommandLineRunner {

    private final UserService userService;

    public StartupConfigure(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        userService.createUser(User.builder().role(Role.ADMIN).username("taha").password("root").build());

    }
}
