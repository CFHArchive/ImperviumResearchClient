package icac.irc.client.networking.server;

import icac.irc.client.datatypes.UInt8;
import icac.irc.client.datatypes.sVLQ;
import icac.irc.client.networking.IPacket;
import icac.irc.client.networking.PacketPayload;
import icac.irc.client.networking.StarboundInputStream;
import icac.irc.client.networking.StarboundOutputStream;

public class PacketUniverseTimeUpdate implements IPacket {

	PacketPayload payload = new PacketPayload();
	private sVLQ time;
	
	public PacketUniverseTimeUpdate() {
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)5);
	}

	@Override
	public void write(StarboundOutputStream sos) throws Exception {
		//Server->Client Packet.
	}

	@Override
	public void read(StarboundInputStream sis) throws Exception {
		//TODO: Read packet.
	}

}
