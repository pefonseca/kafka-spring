package com.pefonseca.payment.service.config.exception;

public record ExceptionDetails(
        int status,
        String message
) {
}
