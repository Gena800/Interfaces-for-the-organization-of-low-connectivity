package ru.netology.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(int s) {
        super("Element with id: " + s + " not found");
    }
}
