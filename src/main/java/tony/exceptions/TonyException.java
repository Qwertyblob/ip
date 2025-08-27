package tony.exceptions;

public class TonyException extends Exception {
    private static final String border = "\t" + "+".repeat(80);

    public TonyException(String string) {
        super(border + "\n\t" + string + "\n" + border);
    }
}