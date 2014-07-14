package icac.irc.client.networking;

import icac.irc.client.datatypes.UInt8;

public interface IPacket {
	UInt8 getID();
	public void write(StarboundOutputStream sos) throws Exception;
	public void read(StarboundInputStream sis) throws Exception;
}