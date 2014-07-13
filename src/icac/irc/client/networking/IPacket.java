package icac.irc.client.networking;

import icac.irc.client.datatypes.UInt8;

import java.io.DataInputStream;

public interface IPacket {
	UInt8 getID();
	public void write(StarboundOutputStream sos) throws Exception;
	public void read(DataInputStream dis) throws Exception;
}