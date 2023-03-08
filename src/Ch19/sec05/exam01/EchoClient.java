package Ch19.sec05.exam01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	public static void main(String[] args) {
		try {
			// localhost 50001포트로 연결요청
			Socket socket = new Socket("localhost", 50001);
			System.out.println("[클라이언트] 연결 성공");
			// ------------------------------------------

			// 데이터 보내기
			String sendMessage = "나는 자바가 싫어";
			OutputStream os = socket.getOutputStream();
			byte[] sendBytes = sendMessage.getBytes("UTF-8");
			os.write(sendBytes);
			os.flush();
			System.out.println("[클라이언트] 데이터 보냄: " + sendMessage);

			// 데이터 받기
			InputStream is = socket.getInputStream();
			byte[] receivebytes = new byte[1024];
			int readByteCount = is.read(receivebytes);
			String receiveMessage = new String(receivebytes, 0, readByteCount, "UTF-8");
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
