package Ch19.sec07;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {
	// 필드
	ServerSocket serverSocket;
	ExecutorService threadPool = Executors.newFixedThreadPool(100);
	Map<String, SocketClient> chatRoom = new Hashtable<>();

	public void start() throws IOException {
		serverSocket = new ServerSocket(50001);
		System.out.println("[서버] 시작됨");

		Thread thread = new Thread(() -> {
			try {
				while (true) {
					Socket socket = serverSocket.accept();
					SocketClient sc = new SocketClient(ChatServer.this, socket);
					// ==SocketClient sc = new SocketClient(new ChatServer(), socket);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		thread.start();
	}

	public void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.put(key, socketClient);
		System.out.println("입장: " + key);
		System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n");
	}

	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.remove(key);
		System.out.println("나감: " + key);
		System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n");
	}

	public void sendToAll(SocketClient sender, String message) {
		JSONObject root = new JSONObject();
		root.put("clientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json = root.toString();

		// 저장된 모든 값을 담는 map의 value()메소드 사용
		// 리턴타입은 Collection<T>인데
		// Map<String, SocketClient> 애초의 맵값이 SocketClient엿음.
		Collection<SocketClient> socketClients = chatRoom.values();
		for (SocketClient sc : socketClients) {
			if (sc == sender) {
				continue;
			}
			sc.send(json);
		}
	}

	public void stop() {
		try {
			serverSocket.close();
			threadPool.shutdownNow();
			chatRoom.values().stream().forEach(sc -> sc.close());
			System.out.println("[서버] 종료됨");
		} catch (IOException e) {
			System.out.println("[서버]" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		try {
			ChatServer chatServer = new ChatServer();
			// TCP서버시작
			chatServer.start();
			System.out.println("---------------------------------------");
			System.out.println("서버 종료하려면 q또는 Q를 입력하고 엔터");
			System.out.println("---------------------------------------");

			// 키보드 입력
			Scanner sc = new Scanner(System.in);
			while (true) {
				String key = sc.nextLine();
				if (key.toLowerCase().equals("q")) {
					break;
				}
			}
			sc.close();
			// TCP서버종료
			chatServer.stop();
		} catch (IOException e) {
			System.out.println("[서버]" + e.getMessage());
		}

	}
}
