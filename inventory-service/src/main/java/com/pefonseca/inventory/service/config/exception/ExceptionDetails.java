package com.pefonseca.inventory.service.config.exception;

public record ExceptionDetails(
        int status,
        String message
) {
}
