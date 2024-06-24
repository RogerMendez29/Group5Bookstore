package edu.fiu.Group5Bookstore.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GeneralBadRequestException extends RuntimeException {
    private final HttpStatus status;

    public GeneralBadRequestException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
