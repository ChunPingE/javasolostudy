package Ch18.sec10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectOutputStreamExample {

	public static void main(String[] args) {
		// FileOutputStream에 ObjectOutputStream 보조 스트림 연결
		try {
			//FileOutputStream에 ObjectOutputStream 보조스트림연결
			FileOutputStream fos = new FileOutputStream("C:/Temp/object.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//객체생성
			Member m1 = new Member("fall", "단풍이");
			Product p1 = new Product("노트북", 1500000);
			int[] arr = {1, 2, 3};
			
			oos.writeObject(m1);
			oos.writeObject(p1);
			oos.writeObject(arr);
			
			oos.flush();
			oos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
