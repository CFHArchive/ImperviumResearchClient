/*
 * Misspelled because Java already has Double and we don't need to cause conflict.
 * Grammar Nazis pls stay away from this file.
 * kthxbye
 */

package icac.irc.client.datatypes;

import java.nio.ByteBuffer;

public class Dubble implements DataType {
	private byte[] bytes;
	private double value;
	
	public Dubble(byte[] bytes)
	{
		this.bytes = bytes;
		decode(bytes);
	}
	public Dubble(double value)
	{
		this.value = value;
		encode(value);
	}
	private void decode(byte[] bytes)
	{
		this.value = ByteBuffer.wrap(bytes).getDouble();
	}
	private void encode(double value)
	{
		this.bytes = ByteBuffer.allocate(8).array();
	}

	public byte[] getBytes()
	{
		return bytes;
	}
	public double getValue()
	{
		return value;
	}
}