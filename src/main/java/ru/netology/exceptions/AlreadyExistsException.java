package ru.netology.exceptions;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(int s) {
        super("Element with id: " + s + " already exists");
    }
}