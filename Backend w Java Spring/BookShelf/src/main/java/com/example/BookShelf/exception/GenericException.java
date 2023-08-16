package com.example.BookShelf.exception;

import com.example.BookShelf.dto.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class GenericException extends RuntimeException {
    private HttpStatus httpStatus;
    private ErrorCode errorCode;
    private String errorMessage;
}
