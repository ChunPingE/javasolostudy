package Ch18.sec07.exam01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedExample {
	public static void main(String[] args) throws Exception {
		// 입출력 스트림생성
		String originalFilePath1 = BufferedExample.class.getResource("originalFile1.jpg").getPath();
		String targetFilePath1 = "C:/Temp/targetFile1.jpg";

		FileInputStream fis = new FileInputStream(originalFilePath1);
		FileOutputStream fos = new FileOutputStream(targetFilePath1);

		// 입출력 스트림 + 버퍼 스트림생성
		String originalFilePath2 = BufferedExample.class.getResource("originalFile2.jpg").getPath();
		String targetFilePath2 = "C:/Temp/targetFile2.jpg";

		FileInputStream fis2 = new FileInputStream(originalFilePath2);
		FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);

		// 버퍼를 사용하지 않고복사
		long nunBufferTime = copy(fis, fos);
		System.out.println("버퍼 미사용: " + nunBufferTime + " ns");
		//버퍼 미사용: 7560354800 ns
			
		// 버퍼사용
		long BufferedTime = copy(bis, bos);
		System.out.println("버퍼 사용: " + BufferedTime + " ns");
		//버퍼 사용: 94382700 ns
		
		fis.close();
		fos.close();
		bis.close();
		bos.close();
	}

	public static long copy(InputStream is, OutputStream os) throws Exception {
		// 시작시간저장
		/*
		long start = System.nanoTime();
		// 1바이트 읽고 1바이트 출력
		while (true) {
			int num = is.read();
			if (num == -1) {
				break;
			}
			os.write(num);
		}
		os.flush();
		long end = System.nanoTime();
		*/
		
		long start = System.nanoTime();
		// 배열
		byte[] data = new byte[1024];
		while (true) {
			int num = is.read(data);
			if (num == -1) {
				break;
			}
			os.write(data, 0, num);
		}
		os.flush();
		long end = System.nanoTime();
		
		return end - start;
	}
}
