package icac.irc.client.datatypes;

public class Bool implements DataType {
	private byte bite;
	private boolean value;
	
	public Bool(byte[] bytes)
	{
		this(bytes[0]);
	}
	public Bool(byte bite)
	{
		int i = bite & 0xFF;
		
		this.value = i == 1;
		this.bite = bite;
	}
	public Bool(boolean value)
	{
		this.value = value;
		this.bite = value ? (byte)1 : (byte)0;
	}
	public byte[] getBytes()
	{
		return new byte[]{bite};
	}
	public boolean getValue()
	{
		return value;
	}
}