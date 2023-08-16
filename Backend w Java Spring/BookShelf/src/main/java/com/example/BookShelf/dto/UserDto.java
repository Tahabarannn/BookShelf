package com.example.BookShelf.dto;


import com.example.BookShelf.model.Role;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String username;
    private Role role;
    private Long id;
}
