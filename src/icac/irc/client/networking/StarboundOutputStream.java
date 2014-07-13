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

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class StarboundOutputStream extends DataOutputStream {

	public StarboundOutputStream(OutputStream out) {
		super(out);
	}
	
	public void writePayload(PacketPayload write) {
		try {
			this.write(new sVLQ(write.getBytes().length).getBytes());
		} catch (IOException e) {
			Client.logger.Log(e);
		}
	}
	
	public void writeBool(Bool write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Client.logger.Log(e);
		}
	}
	
	public void writeDubble(Dubble write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Client.logger.Log(e);
		}
	}
	
	public void writeSVLQ(sVLQ write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Client.logger.Log(e);
		}
	}
	
	public void writeUInt8(UInt8 write) {
		try {
			this.out.write(write.getBytes());
		} catch (IOException e) {
			Client.logger.Log(e);
		}
	}
	
	public void writeUInt8Array(UInt8[] write) {
		for(UInt8 value : write) {
			this.writeUInt8(value);
		}
	}
	
	public void writeUInt16(UInt16 write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Client.logger.Log(e);
		}
	}
	
	public void writeUInt32(UInt32 write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Client.logger.Log(e);
		}
	}
	
	public void writeUInt64(UInt64 write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Client.logger.Log(e);
		}
	}
	
	public void writeVariant(Variant write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Client.logger.Log(e);
		}
	}
	
	public void writeVLQ(VLQ write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Client.logger.Log(e);
		}
	}
	
	public void writeVLQString(VLQString write) {
		try {
			this.write(write.getBytes());
		} catch (IOException e) {
			Client.logger.Log(e);
		}
	}
	
	public void writeVLQString(String write) {
		try {
			this.writeVLQString(new VLQString(write));
		} catch (VLQNegativeException e) {
			Client.logger.Log(e);
		} catch (UnsupportedEncodingException e) {
			Client.logger.Log(e);
		}
	}
}