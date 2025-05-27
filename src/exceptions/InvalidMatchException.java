package exceptions;

public class InvalidMatchException extends RuntimeException {
    public InvalidMatchException(String msg) {
        super(msg);
    }
}