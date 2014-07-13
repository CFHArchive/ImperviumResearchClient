package icac.irc.client.networking.client;

import icac.irc.client.Client;
import icac.irc.client.datatypes.Bool;
import icac.irc.client.datatypes.UInt8;
import icac.irc.client.datatypes.VLQString;
import icac.irc.client.datatypes.Variant;
import icac.irc.client.datatypes.exception.VLQNegativeException;
import icac.irc.client.logger.LogType;
import icac.irc.client.networking.IPacket;
import icac.irc.client.networking.PacketPayload;
import icac.irc.client.networking.StarboundOutputStream;

import java.io.DataInputStream;
import java.io.UnsupportedEncodingException;

public class PacketClientConnect implements IPacket {

	PacketPayload payload = new PacketPayload();
	private UInt8[] digest;
	private Variant claim;
	private Bool uuidFlag;
	private UInt8[] uuid;
	private String username;
	private String species;
	private UInt8[] shipworld;
	private String accountName;
	
	public PacketClientConnect() {
		this.digest = new UInt8[0];
		try {
			this.claim = new Variant(new VLQString("claim"));
		} catch (VLQNegativeException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		uuidFlag = new Bool(false);
		uuid = new UInt8[16];
		this.username = "creatorfromhell";
		this.species = "human";
		this.shipworld = new UInt8[0];
		this.accountName = "creatorfromhell";
		payload.add(this.digest);
		payload.add(this.claim);
		payload.add(this.uuidFlag);
		payload.add(this.username);
		payload.add(this.species);
		payload.add(this.shipworld);
		payload.add(this.accountName);
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)7);
	}

	@Override
	public void write(StarboundOutputStream sos) throws Exception {
		Client.logger.Log("Sending Client Connect Packet. ID is 7.", LogType.Debug);
		sos.writeUInt8(this.getID());
		sos.writePayload(this.payload);
		sos.writeUInt8Array(this.digest);
		sos.writeVariant(this.claim);
		sos.writeBool(this.uuidFlag);
		sos.writeVLQString(this.username);
		sos.writeVLQString(this.species);
		sos.writeUInt8Array(this.shipworld);
		sos.writeVLQString(this.accountName);
		sos.flush();
	}

	@Override
	public void read(DataInputStream dis) throws Exception {
		//Client->Server Packet
	}

}
