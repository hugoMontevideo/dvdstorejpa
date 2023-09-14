package com.simplon.dvdstore.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@Getter
public class NotFoundException extends Exception {


    public NotFoundException(Long id) {
        //super(HttpStatus.NOT_FOUND, "dvd not found with id = " +id);
    }
}
