package icac.irc.client.networking;

import icac.irc.client.Client;
import icac.irc.client.datatypes.Bool;
import icac.irc.client.datatypes.Dubble;
import icac.irc.client.datatypes.UInt16;
import icac.irc.client.datatypes.UInt32;
import icac.irc.client.datatypes.UInt64;
import icac.irc.client.datatypes.UInt8;
import icac.irc.client.datatypes.VLQ;
import icac.irc.client.datatypes.VLQString;
import icac.irc.client.datatypes.Variant;
import icac.irc.client.datatypes.sVLQ;
import icac.irc.client.datatypes.exception.VLQNegativeException;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class PacketPayload {
	
	private List<Byte> payload = new ArrayList<Byte>();
	
	public PacketPayload() {
		
	}
	
	public void add(byte toAdd) {
		payload.add(toAdd);
	}
	
	public void add(byte[] toAdd) {
		for(byte value : toAdd) {
			payload.add(value);
		}
	}
	
	public void add(short toAdd) {
		byte[] bytes = new byte[] {(byte)((toAdd & 0xFF00) >> 8),(byte)(toAdd & 0x00FF)};
		add(bytes);
	}
	
	public void add(int toAdd) {
		byte[] bytes = new byte[] {(byte)(toAdd >>> 24),(byte)(toAdd >>> 16),(byte)(toAdd >>> 8),(byte)toAdd};
		add(bytes);
	}
	
	public void add(long toAdd) {
		byte[] bytes = new byte[] { };
		add(bytes);
	}
	
	public void add(String toAdd) {
		try {
			add(new VLQString(toAdd));
		} catch (VLQNegativeException e) {
			Client.logger.Log(e);
		} catch (UnsupportedEncodingException e) {
			Client.logger.Log(e);
		}
	}
	
	public void add(Bool toAdd) {
		add(toAdd.getBytes());
	}
	
	public void add(Dubble toAdd) {
		add(toAdd.getBytes());
	}
	
	public void add(sVLQ toAdd) {
		add(toAdd.getBytes());
	}
	
	public void add(UInt8 toAdd) {
		add(toAdd.getBytes());
	}
	
	public void add(UInt8[] toAdd) {
		for(UInt8 value : toAdd) {
			add(value.getBytes());
		}
	}
	
	public void add(UInt16 toAdd) {
		add(toAdd.getBytes());
	}
	
	public void add(UInt32 toAdd) {
		add(toAdd.getBytes());
	}
	
	public void add(UInt64 toAdd) {
		add(toAdd.getBytes());
	}
	
	public void add(Variant toAdd) {
		add(toAdd.getBytes());
	}
	
	public void add(VLQ toAdd) {
		add(toAdd.getBytes());
	}
	
	public void add(VLQString toAdd) {
		add(toAdd.getBytes());
	}
	
	public byte[] getBytes() {
		byte[] toReturn = new byte[this.payload.size()];
		for(int i = 0; i < this.payload.size(); i++) {
			toReturn[i] = this.payload.get(i);
		}
		return toReturn;
	}
	
	public void setBytes(byte[] bytes) {
		payload.clear();
		for(byte value : bytes) {
			payload.add(value);
		}
	}
}