package Ch19.sec04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class NewsClient {
	public static void main(String[] args) {
		// Datagram Socket생성
		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			System.out.println("[클라이언트] 연결 성공");
			// 구독하고 싶은 뉴스 주제 보내기
			String data = "정치";
			byte[] bytes = data.getBytes("UTF-8");
			InetSocketAddress isa = new InetSocketAddress("localhost", 50001);
			DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length, isa);
			datagramSocket.send(sendPacket);

			System.out.println("[클라이언트] 뉴스받기 대기");
			while (true) {
				// 뉴스받기
				DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
				datagramSocket.receive(receivePacket);

				// 문자열로 변환
				String news = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
				System.out.println(news);

				if (news.contains("뉴스10")) {
					break;
				}
			}

			// 닫기
			datagramSocket.close();
			System.out.println("[클라이언트] 연결종료");

		} catch (Exception e) {
			System.out.println("[클라이언트]" + e.getMessage());
		}
	}
}
