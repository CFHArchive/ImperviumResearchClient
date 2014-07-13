package icac.irc.client.datatypes;

import icac.irc.client.datatypes.exception.InvalidUIntException;

public class UInt64 extends UIntXX {
	public UInt64(byte[] bytes) throws InvalidUIntException
	{
		super(bytes, 8);
	}
	public UInt64(long value)
	{
		super(value, 8);
	}
}