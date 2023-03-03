package Ch18.sec04.exam02;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReadExample {
	public static void main(String[] args) throws Exception {
		// 입력스트림 생성
		Reader reader = null;

		// 1문자씩 읽기
		reader = new FileReader("C:/Temp/test.txt");
		while (true) {
			int data = reader.read();
			if (data == -1) {
				break;
			}
			System.out.print((char) data);
		}
		reader.close();
		System.out.println();

		// 문자배열로 읽기
		reader = new FileReader("C:/Temp/test.txt");
		char[] data = new char[100];
		while (true) {
			int num = reader.read(data);
			if (num == -1) {
				break;
			}
			for (int i = 0; i < num; i++) {
				System.out.print(data[i]);
			}
		}
		reader.close();
	}
}
