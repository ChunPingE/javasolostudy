package Ch19.sec05.exam02;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsServer {
	private static DatagramSocket datagramSocket = null;
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		System.out.println("---------------------------------------");
		System.out.println("서버 종료하려면 q또는 Q를 입력하고 엔터");
		System.out.println("---------------------------------------");

		// UDP서버시작
		startServer();

		// 키보드 입력
		Scanner sc = new Scanner(System.in);
		while (true) {
			String key = sc.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}

		sc.close();
		// UDP서버종료
		stopServer();
	}

	public static void startServer() {
		// 작업 스레드 정의
		Thread thread = new Thread(() -> {
			try {
				// datagramSocket 생성 및 포트바인딩
				datagramSocket = new DatagramSocket(50001);
				System.out.println("[서버] 시작됨");

				// 계속 받고있어야함
				while (true) {
					// 클라이언트가 구독하고 싶은 뉴스 주제 얻기
					DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
					datagramSocket.receive(receivePacket);

					executorService.execute(() -> {
						String newsKind;
						try {
							newsKind = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
							// 클라이언트의 IP와 PORT얻기
							SocketAddress socketAddress = receivePacket.getSocketAddress();

							// 10개의 뉴스를 클라이언트로 전송
							for (int i = 1; i <= 10; i++) {
								String data = newsKind + ": 뉴스" + i;
								byte[] bytes = data.getBytes("UTF-8");
								DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length, socketAddress);
								datagramSocket.send(sendPacket);
							}
						} catch (Exception e) {
							System.out.println("[서버]" + e.getMessage());
						}
					});
				}
			} catch (Exception e) {
				System.out.println("[서버]" + e.getMessage());
			}
		});
		thread.start();
	}

	public static void stopServer() {
		// datagramSocket 닫고 포트 언바인딩
		datagramSocket.close();
		executorService.shutdownNow();
		System.out.println("[서버] 종료됨");
	}
}
