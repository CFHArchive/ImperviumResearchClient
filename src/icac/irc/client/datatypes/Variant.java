package icac.irc.client.datatypes;

import icac.irc.client.datatypes.exception.VLQNegativeException;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class Variant implements DataType {
	private Object value;
	private byte[] bytes;
	private byte[] dataBytes;
	private byte type;
	
	public Variant(byte[] bytes) throws VLQNegativeException, UnsupportedEncodingException
	{
	    this.bytes = bytes;
	    decode(bytes);
	}
	public Variant(Object value)
	{
		this.value = value;
		encode(value);
	}
	private void encode(Object value)
	{
		this.value = value;
		if (value==null)
		{
			type = 1;
			return;
		}
		if (value instanceof Dubble)       encodeDouble();
		if (value instanceof Bool)         encodeBool();
		if (value instanceof VLQ)          encodeVLQ();
		if (value instanceof VLQString)    encodeVLQString();
//		if (value instanceof VariantArray) encodeVariantArray();  TODO
//		if (value instanceof Dictionary)   encodeDictionary();    TODO
	}
	private void encodeDouble()
	{
		dataBytes = ByteBuffer.allocate(8).putDouble(((Dubble)value).getValue()).array();
		finishEncode();
	}
	private void encodeBool()
	{
		dataBytes = new byte[]{((Bool) value).getValue() ? (byte)1 : (byte)0};
		finishEncode();
	}
	private void encodeVLQ()
	{
		dataBytes = ((VLQ) value).getBytes();
		finishEncode();
	}
	private void encodeVLQString()
	{
		dataBytes = ((VLQString) value).getBytes();
		finishEncode();
	}
	private void encodeVariantArray()
	{
		// TODO
	}
	private void encodeDictionary()
	{
		// TODO
	}
	private void finishEncode()
	{
		bytes[0] = type;
		for (int i = 1; i < bytes.length; i++)
		{
			bytes[i] = dataBytes[i-1];
		}
	}
	
	private void decode(byte[] bytes) throws VLQNegativeException, UnsupportedEncodingException
	{
		this.type = bytes[0];
		if (getType()==VariantType.NULL) // no array copy, no more data to check
		{
			value = null;
			return;
		}
		dataBytes = new byte[bytes.length-1];
		for (int i = 0; i < dataBytes.length; i++)
		{
			dataBytes[i] = bytes[i+1];
		}
		switch (getType())
		{
			case DOUBLE:
				decodeDouble();
				break;
			case BOOL:
				decodeBool();
				break;
			case VLQ:
				decodeVLQ();
				break;
			case STRING:
				decodeString();
				break;
			case VARIANTARRAY:
				decodeVariantArray();
				break;
			case DICTIONARY:
				decodeDictionary();
				break;
			default:
				value = null;
				break;
		}
	}
	private void decodeDouble()
	{
		Double doub = ByteBuffer.wrap(dataBytes).getDouble();
		value = (Object) new Dubble(doub);
	}
	private void decodeBool()
	{
		Bool bool = new Bool(dataBytes);
		value = (Object) bool;
	}
	private void decodeVLQ() throws VLQNegativeException
	{
		VLQ vlq = new VLQ(dataBytes);
		value = (Object) vlq;
	}
	private void decodeString() throws UnsupportedEncodingException, VLQNegativeException
	{
		VLQString vlqS = new VLQString(dataBytes);
		value = (Object) vlqS;
	}
	private void decodeVariantArray()
	{
		// TODO decode array of variant
	}
	private void decodeDictionary()
	{
		// TODO decode dictionary
	}
	
	public byte[] getBytes()
	{
		return bytes;
	}
	public byte getTypeByte()
	{
		return type;
	}
	public VariantType getType()
	{
		return VariantType.findByType(type);
	}
	public Object getValue()
	{
		return value;
	}
}