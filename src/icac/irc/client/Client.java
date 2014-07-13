package icac.irc.client;

import icac.irc.client.datatypes.UInt32;
import icac.irc.client.datatypes.sVLQ;
import icac.irc.client.datatypes.exception.InvalidUIntException;
import icac.irc.client.logger.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	public final static int version = 643;
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	static Logger logger;
	
	private String host;
	private int port;
	
	public Client(String host, int port) {
		this.host = host;
		this.port = port;
	}
	
	public void start() {
		logger = new Logger();
		System.out.println("Attempting to connect to server at: " + host + ":" + port + " .....");
		try {
			this.socket = new Socket(this.host, this.port);
			this.dos = new DataOutputStream(socket.getOutputStream());
			this.dis = new DataInputStream(socket.getInputStream());
			new Thread() {
				public void run() {
					try {
						listen();
					} catch (InvalidUIntException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();
		} catch(Exception e) {
			logger.Log(e);
		}
	}
	
	public Socket getSocket() {
		return this.socket;
	}
	
	public void listen() throws InvalidUIntException {
		System.out.println("listening");
		int available;
		try {
			Thread.sleep(2500);
			while(true) {
				while ((available = dis.available()) == 0)
				{
					Thread.sleep(100);
				}
				byte id = dis.readByte();
				sVLQ payloadLength = new sVLQ(dis.readByte());
				available = available - 1 - payloadLength.getBytes().length;
				byte[] bytes = new byte[available];
				for (int i = 0; i < available; i++)
				{
					bytes[i] = dis.readByte();
				}
				if (id == 0)
				{
					logger.Log("ID 0 = Protocol Version (" + available + " bytes available)");
					logger.Log("Protocol Version is " + new UInt32(bytes).getInt());
				}
				else
				{
					logger.Log("Packet id " + id + " rcvd");
					logger.Log("available says " + available);
					logger.Log("sVLQ length = " + payloadLength.getLong());
					logger.Log("Created bytes["+available+"], but i dont know what to do with it");
				}
				Thread.sleep(100);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}