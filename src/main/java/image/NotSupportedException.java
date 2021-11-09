package image;

public class NotSupportedException extends RuntimeException {
    private final String string;
    public NotSupportedException(String string) {
        this.string = string;
    }
}
