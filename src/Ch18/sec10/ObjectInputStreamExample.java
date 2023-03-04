package Ch18.sec10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectInputStreamExample {

	public static void main(String[] args) {
	
		try {
			//FileInputStream에 ObjectInputStream에 연결
			FileInputStream fis = new FileInputStream("C:/Temp/object.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			//파일을 읽고 역직렬화해서 객체로 복원
			Member m2 = (Member) ois.readObject();
			Product p2 = (Product) ois.readObject();
			int[] arr2 = (int[]) ois.readObject();
			
			ois.close();
			
			//toString재정의 되어있기때문에 읽기 가능
			System.out.println(m2);
			System.out.println(p2);
			System.out.println(Arrays.toString(arr2));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
