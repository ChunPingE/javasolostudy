package Ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.InputStream;

public class ReadExample {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream("C:/Temp/test2.db");
		
		byte[] data = new byte[100];
		
		while (true) {
			int num = is.read(data); //최대 100바이트르 읽고 읽은바이트는 data저장 읽은 수는 리턴
			if ( num == -1) {
				break;
			}
			for (int i = 0; i < num; i++) {
				System.out.println(data[i]);
			}
		}
	}
}
