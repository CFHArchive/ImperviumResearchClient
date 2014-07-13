package icac.irc.client.datatypes;

import icac.irc.client.datatypes.exception.VLQNegativeException;

import java.io.UnsupportedEncodingException;

public class VLQString implements DataType {
	private byte[] bytes;
	private byte[] textBytes;
	private String value;
	private long length;
	private VLQ vlqLength;
	private int offset;
	
	public VLQString(byte[] bytes) throws UnsupportedEncodingException, VLQNegativeException
	{
		this.bytes = bytes;
		decode(bytes);
	}
	public VLQString(String value) throws VLQNegativeException, UnsupportedEncodingException
	{
		this.value = value;
		encode(value);
	}
	private void decode(byte[] bytes) throws VLQNegativeException, UnsupportedEncodingException
	{
		VLQ vlqLength = new VLQ(bytes);
		this.length = vlqLength.getLong();
		this.vlqLength = vlqLength;
		this.offset = vlqLength.getNumBytes();
		System.out.println("Offset: " + offset);
		System.out.println("Long: " + vlqLength.getLong());
		byte[] textBytes = new byte[bytes.length - offset];
		for (int i = offset; i < bytes.length; i++) {                
			textBytes[i-offset] = bytes[i];
		}
		this.textBytes = textBytes;
		this.value = new String(textBytes, "UTF-8");
	}
	private void encode(String value) throws VLQNegativeException, UnsupportedEncodingException
	{
		vlqLength = new VLQ(value.length());
		length = vlqLength.getLong();
		offset = vlqLength.getNumBytes();
		byte[] bytes = new byte[(int) (offset + vlqLength.getLong())];
		for (int i = 0; i < offset; i++)
		{
			bytes[i] = vlqLength.getBytes()[i];
		}
		this.textBytes = value.getBytes("UTF-8");
		for (int i = offset; i < bytes.length; i++)
		{
			bytes[i] = textBytes[i-offset];
		}
		this.bytes = bytes;
	}

	public byte[] getBytes()
	{
		return bytes;
	}
	public byte[] getTextBytes()
	{
		return textBytes;
	}
	public String getValue()
	{
		return value;
	}
	public long getLength()
	{
		return length;
	}
	public VLQ getVLQLength()
	{
		return vlqLength;
	}
	public int getOffset()
	{
		return offset;
	}
	
	public byte[] getUnusedBytes() {
	     //TODO: Return unused bytes.
	     return new byte[1];
	}
}