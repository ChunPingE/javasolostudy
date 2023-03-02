package Ch18.sec03.exam04;

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

		is.transferTo(os);

		is.close();
		os.close();

		System.out.println("복사 완료");
	}
}
