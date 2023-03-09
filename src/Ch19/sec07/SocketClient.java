package Ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {
	// 필드
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
			this.clientIp = isa.getHostString();
			receive();
		} catch (IOException e) {
			System.out.println("[서버]" + e.getMessage());
		}
	}

	// 데이터받기
	public void receive() {
		// 필드에 챗서버 객체를 만들엇으니 가능
		chatServer.threadPool.execute(() -> {
			try {
				while (true) {
					String receiveJson = dis.readUTF();

					// JSON파싱
					JSONObject jsonObject = new JSONObject(receiveJson);
					String command = jsonObject.getString("command");

					switch (command) {
					case "incoming":
						this.chatName = jsonObject.getString("data");
						chatServer.sendToAll(this, "들어오셨습니다.");
						chatServer.addSocketClient(this);
						break;
					case "message":
						String message = jsonObject.getString("data");
						chatServer.sendToAll(this, message);
						break;
					}
				}
			} catch (Exception e) {
				chatServer.sendToAll(this, "나가셨습니다.");
				chatServer.removeSocketClient(this);
			}
		});
	}

	// 메시지보내기
	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
		}
	}

	// 연결 종료
	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
