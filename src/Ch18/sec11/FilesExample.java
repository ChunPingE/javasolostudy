package Ch18.sec11;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {
	public static void main(String[] args) {
		try {
			String data = "" +
					"id: winter\n" +
					"email: winter@mycompany.com\n" +
					"tel: 010-123-1234";
						
			//Path 객체 생성
			Path path = Paths.get("C:/Temp/user.txt");
			
			//파일 생성 및 데이터 저장 입출력 스트링을 사용해도되는데 이걸 사용한 것임.
			//path, data, 파일 저장 유형
			Files.writeString(path, data, Charset.forName("UTF-8"));
					
			//파일 정보 얻기
			System.out.println("파일 유형: " + Files.probeContentType(path));
			//MimeType 대분류/중분류 text/plain 
			//웹에서 매우 중요함.
			//브라우저가 파일을 받고나서 어케처리할지를 이것을 보고 결정함.
			System.out.println("파일 크기: " + Files.size(path) + " bytes");
			System.out.println();
			
			//파일 읽기
			String content = Files.readString(path, Charset.forName("UTF-8"));
			System.out.println(content);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}