package Ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient2 {
	public static void main(String[] args) {
		try {
			// localhost 50001포트로 연결요청
			Socket socket = new Socket("localhost", 50001);
			System.out.println("[클라이언트] 연결 성공");
			// ------------------------------------------

			// 데이터 보내기
			String sendMessage = "나는 자바가 싫어";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(sendMessage);
			dos.flush();
			System.out.println("[클라이언트] 데이터 보냄: " + sendMessage);

			// 데이터 받기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMessage = dis.readUTF();
			System.out.println("[클라이언트] 데이터 받음: " + receiveMessage);
			// ------------------------------------------
			// Socket 닫기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");

		} catch (UnknownHostException e) {
			// IP 표기방법이 잘못되엇을 경우
		} catch (IOException e) {
			// 해당 포트의 서버에 연결할수 없는 경우
		}
	}
}
