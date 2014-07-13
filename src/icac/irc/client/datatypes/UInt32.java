package icac.irc.client.datatypes;

import icac.irc.client.datatypes.exception.InvalidUIntException;

public class UInt32 extends UIntXX {
	public UInt32(byte[] bytes) throws InvalidUIntException
	{
		super(bytes, 4);
	}
	public UInt32(int value)
	{
		super(value, 4);
	}
}