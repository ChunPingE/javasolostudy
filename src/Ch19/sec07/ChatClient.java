package Ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {
	//필드
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String chatName;
	
	public void connent() {
		try {
			socket = new Socket("localhost", 50001);
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			System.out.println("[클라이언트] 서버에 연결됨");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receive() {
		Thread thread = new Thread(()-> {
			try {
				while (true) {
					//문자읽어오기
					String json = dis.readUTF();
					//json파싱
					JSONObject root = new JSONObject(json);
					String clientIp = root.getString("clientIp");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("<" + chatName + "@" + clientIp +">" + message); 
				}
			} catch (Exception e){
				System.out.println("[클라이언트] 서버 연결 끊김");
				e.printStackTrace();
				System.exit(0);
			}
		});
		thread.start();
	}
	
	//json 보내기
	public void send(String json) throws IOException {
		dos.writeUTF(json);
		dos.flush();
	}
	
	//서버연결종료
	public void unconnect() throws IOException {
		socket.close();
	}
	
	public static void main(String[] args) {
		try {
			ChatClient chatClient = new ChatClient();
			//서버 연결
			chatClient.connent();
			
			Scanner sc= new Scanner(System.in);
			System.out.println("대화명 입력");
			chatClient.chatName = sc.nextLine();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("command", "incoming");
			jsonObject.put("data", chatClient.chatName);
			String firstJson = jsonObject.toString();
			chatClient.send(firstJson);
			
			chatClient.receive();
			
			System.out.println("-----------------------------------");
			System.out.println("보낼 메시지를 입력하고 엔터");
			System.out.println("채팅을 종료하려면 q를 입력하고 엔터");
			System.out.println("-----------------------------------");
			
			while (true) {
				String message = sc.nextLine();
				if(message.toLowerCase().equals("q")) {
					break;
				} else {
					jsonObject = new JSONObject();
					jsonObject.put("command", "message");
					jsonObject.put("data", message);
					String sendJson = jsonObject.toString();
					chatClient.send(sendJson);
				}
			}
			sc.close();
			chatClient.unconnect();
		}catch (Exception e){
			System.out.println("[클라이언트] 서버 연결 안됨");
		}
	}
}
