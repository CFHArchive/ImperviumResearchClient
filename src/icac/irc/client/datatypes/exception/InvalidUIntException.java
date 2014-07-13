package icac.irc.client.datatypes.exception;

public class InvalidUIntException extends DataTypeException {
	private static final long serialVersionUID = 4214147226544582084L;
	
	public InvalidUIntException(String message) {
		super(message);
	}
	public InvalidUIntException()
	{
		super("UInts must be either 8, 16, 32, or 64 bits (1, 2, 4, 8 bytes).");
	}

}
