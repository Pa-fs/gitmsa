package com.pmh.ex08.error;

import jakarta.transaction.UserTransaction;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

@ControllerAdvice
public class ErrorController {

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

        String msg = (String) Arrays.stream(e.getDetailMessageArguments())
                .reduce("", (s, s2) -> s.toString() + s2.toString());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(msg)
                .localDateTime(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> constraintException(ConstraintViolationException e) {

        // stream
        String msg = e.getConstraintViolations()
                .stream()
                .map(constraintViolation -> constraintViolation.getMessage())
                .reduce("", (s, s2) -> s + s2);

        // 향상된 포문
//        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
//        String test = "";
//        for (ConstraintViolation<?> item : constraintViolations) {
//            System.out.println(item);
//            System.out.println(item.getMessage());
//            test = item.getMessage();
//        }
//        System.out.println("test" + test);

        ErrorResponse errorResponse = ErrorResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message( msg )
                .localDateTime(LocalDateTime.now())
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
}











