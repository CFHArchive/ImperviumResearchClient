package icac.irc.client.networking.server;

import icac.irc.client.datatypes.Bool;
import icac.irc.client.datatypes.UInt64;
import icac.irc.client.datatypes.UInt8;
import icac.irc.client.datatypes.VLQ;
import icac.irc.client.networking.IPacket;
import icac.irc.client.networking.PacketPayload;
import icac.irc.client.networking.StarboundOutputStream;

import java.io.DataInputStream;

public class PacketConnectionResponse implements IPacket {

	PacketPayload payload = new PacketPayload();
	private Bool success;
	private VLQ clientID;
	private String rejectionReason;
	private Bool celestialInfo;
	private int orbitalLevels;
	private int chunkSize;
	private int xyMin;
	private int xyMax;
	private int zMin;
	private int zMax;
	private VLQ sectorsNumber;
	private String sectorID;
	private String sectorName;
	private UInt64 sectorSeed;
	private String sectorPrefix;
	//TODO: Variant DataType
	
	public PacketConnectionResponse() {
	}
	
	@Override
	public UInt8 getID() {
		return new UInt8((byte)1);
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