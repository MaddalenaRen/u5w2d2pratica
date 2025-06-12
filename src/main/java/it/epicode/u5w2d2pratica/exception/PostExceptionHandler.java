package it.epicode.u5w2d2pratica.exception;

import it.epicode.u5w2d2pratica.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)//ogni cvolta che ci sarà un errore Spring chiamerà questo metodo
public class PostExceptionHandler {
    public ApiError nonTrovatoExceptionHandler(AutoreNotFoundException e) {
        ApiError error = new ApiError();
        error.setMessage(e.getMessage());
        error.setDataErrore(LocalDateTime.now());
        return error;
    }

    public ApiError nonTrovatoExceptionHandler(BlogNotFoundException e) {
        ApiError error = new ApiError();
        error.setMessage(e.getMessage());
        error.setDataErrore(LocalDateTime.now());
        return error;
    }
}
