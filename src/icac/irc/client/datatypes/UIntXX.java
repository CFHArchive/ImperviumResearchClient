package icac.irc.client.datatypes;

import icac.irc.client.datatypes.exception.InvalidUIntException;

import java.nio.ByteBuffer;

public class UIntXX implements DataType {
	private byte[] bytes;
	private Number value;
	private ByteBuffer byteBuffer;
	private int bits;
	
	public UIntXX(byte[] bytes, int bits) throws InvalidUIntException
	{
		this.bytes = bytes;
		this.bits = bits;
		decode(bytes);
	}
	public UIntXX(Number value, int bits)
	{
		this.value = value;
		this.bits = bits;
		encode(value);
	}
	private void decode(byte[] bytes) throws InvalidUIntException
	{
		if (bits != 1 && bits != 2 && bits != 4 && bits != 8)
			throw new InvalidUIntException();
		byteBuffer = ByteBuffer.wrap(bytes);
		switch (bits)
		{
			case 1:
				value = byteBuffer.get();
				break;
			case 2:
				value = byteBuffer.getShort();
				break;
			case 4:
				value = byteBuffer.getInt();
				break;
			case 8:
				value = byteBuffer.getLong();
				break;
		}
	}
	private void encode(Number value)
	{
		switch (bits)
		{
			case 1:
				bytes = ByteBuffer.allocate(bits).put(value.byteValue()).array();
				break;
			case 2:
				bytes = ByteBuffer.allocate(bits).putShort(value.shortValue()).array();
				break;
			case 4:
				bytes = ByteBuffer.allocate(bits).putInt(value.intValue()).array();
				break;
			case 8:
				bytes = ByteBuffer.allocate(bits).putLong(value.longValue()).array();
				break;
		}
	}
	
	public byte[] getBytes()
	{
		return bytes;
	}
	public Number getValue()
	{
		return value;
	}
	public long getLong()
	{
		return value.longValue();
	}
	public int getInt()
	{
		return value.intValue();
	}
	public short getShort()
	{
		return value.shortValue();
	}
	public byte getByte()
	{
		return value.byteValue();
	}
}