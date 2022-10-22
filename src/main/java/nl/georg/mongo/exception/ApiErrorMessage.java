package nl.georg.mongo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
public class ApiErrorMessage {

    private final Instant timestamp = Instant.now();
    private final HttpStatus httpStatus;
    private final String description;

    public ApiErrorMessage(HttpStatus httpStatus,
                           String description) {
        this.httpStatus = httpStatus;
        this.description = description;
    }
}