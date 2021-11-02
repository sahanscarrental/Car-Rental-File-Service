package com.car.castel.FileService.web.controller.web.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(Class clazz, String... paramsMap) {
        super(
                ErrorMessage.generateMessage(
                        clazz.getSimpleName(),
                        ErrorMessage.toMap(String.class, String.class, (Object[]) paramsMap),
                        " Wos not valid for parameters"
                )
        );
    }
}
