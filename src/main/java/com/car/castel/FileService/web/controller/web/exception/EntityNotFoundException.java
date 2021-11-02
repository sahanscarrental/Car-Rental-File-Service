package com.car.castel.FileService.web.controller.web.exception;



public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class clazz, String... searchParamsMap) {
        super(
                ErrorMessage.generateMessage(
                        clazz.getSimpleName(),
                        ErrorMessage.toMap(String.class, String.class, (Object[]) searchParamsMap),
                        " was not found for parameters "
                )
        );
    }



}
