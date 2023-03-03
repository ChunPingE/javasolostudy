package Ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class ReadLineExample {
	public static void main(String[] args) throws Exception {
		Reader reader = new FileReader("src/Ch18/sec07/exam02/ReadLineExample.java");
		BufferedReader br = new BufferedReader(reader);	
		
		int lineNo = 1;
		/*
		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}
			System.out.println(lineNo + "\t" + str);
			lineNo++;
		}
		*/
		
		char[] data = new char[1000];
		while (true) {
			int num = reader.read(data);
			if (num == -1) {
				break;
			}
			String str = new String(data, 0, num);
			System.out.println(lineNo + "\t" + str);
			lineNo++;
		}
		
		br.close();
	}
}
