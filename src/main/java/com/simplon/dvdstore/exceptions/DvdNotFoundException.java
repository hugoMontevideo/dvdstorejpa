package com.simplon.dvdstore.exceptions;

import lombok.Getter;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dvd Not Found")
@Getter

public class DvdNotFoundException extends ResponseStatusException {


    public DvdNotFoundException(HttpStatus status){
        super(status);
    }

    public DvdNotFoundException(HttpStatus status, String reason){
        super(status,reason);
    }
    public DvdNotFoundException(HttpStatus status, String reason, Throwable cause){
        super(status, reason, cause);
    }

}
