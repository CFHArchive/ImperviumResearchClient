package icac.irc.client;

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
					listen();
				}
			}.start();
		} catch(Exception e) {
			logger.Log(e);
		}
	}
	
	public Socket getSocket() {
		return this.socket;
	}
	
	public void listen() {
		int available;
		try {
			while((available = dis.available()) != 0) {
				byte id = dis.readByte();
				logger.Log("Packet received. id: " + id);
				if(id == 0) {
					logger.Log("" + dis.readByte());
					logger.Log("Protocol Version: " + dis.readInt());
				}
				logger.Log("Data available: " + (available - 1));
				/*System.out.println("Data(Byte by Byte):");
				for(int i = 0; i < available; i++) {
					System.out.println(dis.read());
				}*/
			}
		} catch (IOException e) {
			logger.Log(e);
		}
	}
}