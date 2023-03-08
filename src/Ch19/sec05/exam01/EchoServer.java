package Ch19.sec05.exam01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
	private static ServerSocket serverSocket = null;
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		System.out.println("---------------------------------------");
		System.out.println("서버 종료하려면 q또는 Q를 입력하고 엔터");
		System.out.println("---------------------------------------");

		// TCP서버시작
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
		// TCP서버종료
		stopServer();
	}

	public static void startServer() {
		// 작업스레드 정의
		Thread thread = new Thread(() -> {
			try {
				// ServerSocket생성 및 Port바인딩
				serverSocket = new ServerSocket(50001);
				System.out.println("[서버] 시작됨");

				// 서버는 요청을 계속 기다려야함.
				while (true) {
					System.out.println("\n[서버] 연결 요청을 기다림\n");

					// 연결 수락
					Socket socket = serverSocket.accept();

					executorService.execute(() -> {
						try {
							// 연결된 클라이언트 정보얻기
							InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
							System.out.println("[서버]" + isa.getHostName() + "의 연결 요청을 수락함");

							// -------------------------------------------------------
							// 데이터 받기
							InputStream is = socket.getInputStream();
							byte[] receivebytes = new byte[1024]; // 1kbyte
							int readByteCount = is.read(receivebytes);
							String message = new String(receivebytes, 0, readByteCount, "UTF-8");

							// 데이터 보내기
							OutputStream os = socket.getOutputStream();
							byte[] sendbyte = message.getBytes("UTF-8");
							os.write(sendbyte);
							os.flush();
							System.out.println("[서버] 받은데이터를 다시 보냄: " + message);

							// 연결끊기

							socket.close();
							System.out.println("[서버]" + isa.getHostName() + "의 연결을 끊음");
						} catch (IOException e) {
							System.out.println("[서버]" + e.getMessage());
						}
					});
					// --------------------------------------------------------
				}
			} catch (IOException e) {
				System.out.println("[서버]" + e.getMessage());
			}
		});
		// 스레드 시작
		thread.start();
	}

	public static void stopServer() {
		try {
			// serverSocket을 닫고 포트 언바인딩
			serverSocket.close();
			executorService.shutdownNow();
			System.out.println("[서버] 종료됨");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
