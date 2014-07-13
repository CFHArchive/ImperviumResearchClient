package icac.irc.client.datatypes.exception;

public class DataTypeException extends Exception {
	private static final long serialVersionUID = 12323823821L;

	public DataTypeException(String message) {
        super(message);
    }

    public DataTypeException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
