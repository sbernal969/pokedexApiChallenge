package com.modyo.pokedex.exceptions;

import com.modyo.pokedex.utils.Constant;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorHandler extends Throwable {
    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class.getSimpleName());

    @ExceptionHandler({FeignException.class, ConectionBussinessException.class})
    public ResponseEntity<ErrorInfo> handleFeignException(HttpServletRequest request, FeignException e) {
        log.info("Se detecta exception por parte de servicio externo");
        log.error(e.getLocalizedMessage());
        HttpStatus httpStatus = HttpStatus.resolve(e.status());
        if (httpStatus != null) {
            log.info("http status: {}", httpStatus);
        } else {
            httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
        }

        ErrorInfo errorInfo;

        switch (httpStatus.value()) {
            case 401:
                errorInfo = new ErrorInfo(e.status(), Constant.Errors.MESSAGE_ERROR_401, request.getRequestURI());
                break;
            case 403:
                errorInfo = new ErrorInfo(e.status(), Constant.Errors.MESSAGE_ERROR_403, request.getRequestURI());
                break;
            case 404:
                errorInfo = new ErrorInfo(e.status(), Constant.Errors.MENSAJE_ERROR_404, request.getRequestURI());
                break;
            default:
                errorInfo = new ErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constant.Errors.ERROR_500, request.getRequestURI());
                break;
        }

        return new ResponseEntity<>(errorInfo, httpStatus);
    }
}
