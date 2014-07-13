package icac.irc.client.networking.client;

import icac.irc.client.datatypes.UInt8;
import icac.irc.client.networking.IPacket;
import icac.irc.client.networking.PacketPayload;
import icac.irc.client.networking.StarboundOutputStream;

import java.io.DataInputStream;

public class PacketHandshakeResponse implements IPacket {

	PacketPayload payload = new PacketPayload();
	private String claimResponse;
	private String passwordHash;
	
	public PacketHandshakeResponse(String response, String hash) {
		this.claimResponse = response;
		this.passwordHash = hash;
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)9);
	}

	@Override
	public void write(StarboundOutputStream sos) throws Exception {
		//TODO: Write this packet
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Client->Server Packet
	}

}