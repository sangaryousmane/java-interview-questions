package advance.stacksqueues;

public class StackIsEmptyException extends RuntimeException{

    public StackIsEmptyException() {
    }

    public StackIsEmptyException(String message) {
        super(message);
    }
}
