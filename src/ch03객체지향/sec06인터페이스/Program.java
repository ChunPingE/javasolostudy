package ch03객체지향.sec06인터페이스;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("src/ch03객체지향/sec06인터페이스/setting.txt");
		Scanner sc = new Scanner(fis);
		String className = sc.nextLine();
		sc.close();
		fis.close();
		
		Class clazz = Class.forName(className);
		
		A a = new A();
		X x = (X) clazz.newInstance();
		a.setX(x);
		
		a.print();
	}

}
