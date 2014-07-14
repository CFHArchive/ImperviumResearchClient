package icac.irc.client.networking.server;

import icac.irc.client.datatypes.UInt8;
import icac.irc.client.networking.IPacket;
import icac.irc.client.networking.PacketPayload;
import icac.irc.client.networking.StarboundInputStream;
import icac.irc.client.networking.StarboundOutputStream;

public class PacketHandshakeChallenge implements IPacket {

	PacketPayload payload = new PacketPayload();
	private String claim;
	private String salt;
	private int rounds;
	
	public PacketHandshakeChallenge() {
		
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)3);
	}

	@Override
	public void write(StarboundOutputStream sos) throws Exception {
		//Server->Client Packet
	}

	@Override
	public void read(StarboundInputStream sis) throws Exception {
		//TODO: Read packet.
	}
}