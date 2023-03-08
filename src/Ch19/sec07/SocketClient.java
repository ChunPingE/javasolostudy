package Ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClient {
	//필드
	ChatServer chatServer;
	Socket socket;
	
	DataInputStream dis;
	DataOutputStream dos;
	
	String chatName;
	String clientIp;

	public SocketClient(ChatServer chatServer, Socket socket) {
		try {
			this.chatServer = chatServer;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			this.clientIp = isa.getHostName();
			receive();
		} catch (IOException e) {
			System.out.println("[서버]" + e.getMessage());
		}
	}

	public void receive() {
	}

	public void send(String json) {
	}

	public Object close() {
		return null;
	}

}
