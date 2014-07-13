package icac.irc.client.networking.server;

import icac.irc.client.datatypes.UInt8;
import icac.irc.client.networking.IPacket;
import icac.irc.client.networking.PacketPayload;
import icac.irc.client.networking.StarboundOutputStream;

import java.io.DataInputStream;

public class PacketDisconnectResponse implements IPacket {

	PacketPayload payload = new PacketPayload();
	private UInt8 unknown;
	
	public PacketDisconnectResponse() {
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)2);
	}

	@Override
	public void write(StarboundOutputStream sos) throws Exception {
		//Server->Client Packet.
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//TODO: Read packet.
	}

}
