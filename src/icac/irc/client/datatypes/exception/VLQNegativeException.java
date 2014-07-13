package icac.irc.client.datatypes.exception;

public class VLQNegativeException extends DataTypeException {
	private static final long serialVersionUID = 5180990121386109254L;
	
	public VLQNegativeException(String message) {
		super(message);
	}
	public VLQNegativeException()
	{
		super("VLQs can not hold negative values, instead use an sVLQ.");
	}

}
