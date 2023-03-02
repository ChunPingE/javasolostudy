package Ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExmaple {
	public static void main(String[] args) throws Exception {
		String orginalFileName = "C:/Temp/test.jpg";
		String targetFileName = "C:/Temp/test2.jpg";

		InputStream is = new FileInputStream(orginalFileName);
		OutputStream os = new FileOutputStream(targetFileName);
		
		byte[] data = new byte[1024]; //1024바이트 == 1키로바이튼
		
		while (true) {
			int num = is.read(data);
			if(num ==  -1) {
				break;
			}
			//마지막에 만약 2개만들어오면 2까지만읽기
			os.write(data, 0 , num); 
		}
		os.flush();
		is.close();
		os.close();
		
		System.out.println("복사 완료");
	}
}
