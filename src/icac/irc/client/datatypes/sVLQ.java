package icac.irc.client.datatypes;

public class sVLQ implements DataType {
	private long value;
	private byte[] bytes;
	
	public sVLQ(byte[] bytes)
	{	
		this.bytes = bytes;
		decode(bytes);
	    // To get the byte length of the real number we have to re-encode,
	    // because sometimes we do not know when the VLQ ends.
		encode(value);
	}
	public sVLQ(long value)
	{
		this.value = value;
		encode(value);
	}
	private void decode(byte[] bytes)
	{
		long value = 0;
	    for (int i = 0; i < bytes.length; i++)
	    {
	      int curByte = bytes[i] & 0xFF;
	      value = (value << 7) | (curByte & 0x7F);
	      if ((curByte & 0x80) == 0)
	        break;
	    }
	    value = (value + 1)/2;
	    this.value = value;
	}
	private void encode(long value)
	{
		value = value * 2 - 1;
		int numRelevantBits = 64 - Long.numberOfLeadingZeros(value);
	    int numBytes = (numRelevantBits + 6) / 7;
	    if (numBytes == 0)
	      numBytes = 1;
	    byte[] bytes = new byte[numBytes];
	    for (int i = numBytes - 1; i >= 0; i--)
	    {
	      int curByte = (int)(value & 0x7F);
	      if (i != (numBytes - 1))
	        curByte |= 0x80;
	      bytes[i] = (byte)curByte;
	      value >>>= 7;
	    }    
	    this.bytes = bytes;
	}
	
	public long getLong()
	{
		return value;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void printBinary()
	{
		String s = "";
		for (byte b : bytes)
		{
			s+=Integer.toBinaryString(b & 0xFF);
		}
		System.out.println("Bytes: " + s);
		System.out.println("Long: " + getLong());
	}
}