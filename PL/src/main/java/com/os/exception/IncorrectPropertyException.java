package com.os.exception;

public class IncorrectPropertyException extends Exception {
        public IncorrectPropertyException() {
            super("Unable to read property");
        }
        public IncorrectPropertyException(String message) {
            super(message);
        }
}
