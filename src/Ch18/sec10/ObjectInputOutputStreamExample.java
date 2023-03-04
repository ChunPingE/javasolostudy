package Ch18.sec10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class ObjectInputOutputStreamExample {

	public static void main(String[] args) {
		
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
