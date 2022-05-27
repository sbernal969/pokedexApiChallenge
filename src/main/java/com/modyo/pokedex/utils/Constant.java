package com.modyo.pokedex.utils;

public class Constant {
    private Constant(){}

    public static class Errors {

        public static final String MESSAGE_ERROR_401 = "Unauthorized";
        public static final String MESSAGE_ERROR_403 = "Access Denied";

        public static final String MENSAJE_ERROR_404 = "Pokemon not found";
        public static final String ERROR_500 = "Error 500";

        private Errors(){}

    }
    public static class httpHeaders{

        public static final String HTTP_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";
    }
}
