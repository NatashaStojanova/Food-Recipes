package com.projectrecipes.natashastojanova.foodrecipes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Natasha Stojanova
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PasswordsNotTheSameException extends RuntimeException {
}