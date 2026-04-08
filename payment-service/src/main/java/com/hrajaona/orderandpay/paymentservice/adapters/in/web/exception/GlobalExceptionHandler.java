package com.hrajaona.orderandpay.paymentservice.adapters.in.web.exception;


import com.hrajaona.orderandpay.paymentservice.adapters.in.web.enums.ApiCodeError;
import com.hrajaona.orderandpay.paymentservice.adapters.in.web.error.ApiError;
import com.hrajaona.orderandpay.paymentservice.domain.exception.PaymentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<ApiError> handlePaymentNotFoundException(PaymentNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiError(ApiCodeError.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiError> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        if (exception.getRequiredType() == UUID.class) {
            return ResponseEntity.badRequest()
                    .body(new ApiError(ApiCodeError.INVALID_ID, ApiCodeError.INVALID_ID.getValue()));
        }

        return ResponseEntity.badRequest()
                .body(new ApiError(ApiCodeError.BAD_REQUEST, ApiCodeError.BAD_REQUEST.getValue()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiError(ApiCodeError.INTERNAL_ERROR, ApiCodeError.INTERNAL_ERROR.getValue()));
    }

}
