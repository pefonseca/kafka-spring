package com.pefonseca.order.service.config.exception;

public record ExceptionDetails(
        int status,
        String message
) {
}
