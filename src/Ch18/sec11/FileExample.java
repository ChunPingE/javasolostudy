package Ch18.sec11;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
	
public class FileExample {
	public static void main(String[] args) throws Exception {
		//File 객체 생성
		File dir = new File("C:/Temp/images"); //디렉토리
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File file3 = new File("C:/Temp/file3.txt");

		//존재하지 않으면 디렉토리 또는 파일 생성
		if(dir.exists() == false) { dir.mkdirs(); } //없다면 모든 디렉토리 생성 
		if(file1.exists() == false) { file1.createNewFile(); } //없다면 파일 만들기 보통은 FileOutputStream으로 만듬
		if(file2.exists() == false) { file2.createNewFile(); }
		if(file3.exists() == false) { file3.createNewFile(); }
		/*
		FileOutputStream fos = new FileOutputStream("C:/Temp/file1.txt");
		fos.write(); fos.flush();...
		*/
		
		//Temp 폴더의 내용을 출력
		File temp = new File("C:/Temp");
		File[] contents = temp.listFiles();  //Temp파일에 있는거를 배열에 넣어서 보기

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");//날짜출력하기위한거
		for(File file : contents) {
			System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
			if(file.isDirectory()) { //CMD창에 dir쳤을때 나오는것
				System.out.printf("%-10s%-20s", "<DIR>", file.getName()); //디렉토리라면 DIR이라고
			} else {
				System.out.printf("%-10s%-20s", file.length(), file.getName()); //파일사이즈
			}
			System.out.println();
		}
	}
}