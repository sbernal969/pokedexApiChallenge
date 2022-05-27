package com.modyo.pokedex.exceptions;

import feign.FeignException;

public class ConectionBussinessException extends FeignException {


    public ConectionBussinessException(int status, String message) {
        super(status, message);

    }
}
