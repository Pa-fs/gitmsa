package com.kty.ex07.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;

@ControllerAdvice
public class ErrorController {

    // email 중복
    // username 안넣을때
    // email 안넣었을때

    @ExceptionHandler(BizException.class)
    public ResponseEntity<ErrorResponse> mException(BizException e) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getErrorCode().getMessage())
                .httpStatus(e.getErrorCode().getHttpStatus())
                .localDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity
                .status(errorResponse.getHttpStatus())
                .body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validityException(MethodArgumentNotValidException e) {

//        System.out.println(e.getBody());
//        System.out.println(Arrays.toString(e.getDetailMessageArguments()));
//        System.out.println(e.getFieldErrors());
//        e.getFieldErrors()
//                .stream()
//                .forEach(fieldError -> {
//                    System.out.println(fieldError.getField());
//                    System.out.println(fieldError.getDefaultMessage());
//                });

        String msg = (String) Arrays.stream(e.getDetailMessageArguments())
                .reduce("", (o, o2) -> o.toString() + o2.toString());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(msg)
                .localDateTime(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(errorResponse.getHttpStatus())
                .body(errorResponse);
    }
}
