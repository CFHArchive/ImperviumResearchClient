package icac.irc.client.datatypes;

import icac.irc.client.datatypes.exception.InvalidUIntException;

public class UInt16 extends UIntXX {
	public UInt16(byte[] bytes) throws InvalidUIntException
	{
		super(bytes, 2);
	}
	public UInt16(short value)
	{
		super(value, 2);
	}
}