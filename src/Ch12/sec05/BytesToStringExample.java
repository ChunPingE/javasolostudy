package Ch12.sec05;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BytesToStringExample {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String data = "자바";

		// String -> byte배열(기본 utf-8 인코딩)
		byte[] arr1 = data.getBytes(); // byte[] arr1 = data.getBytes("UTF-8");
		System.out.println("ar1: " + Arrays.toString(arr1));

		// byte배열 -> String
		String str1 = new String(arr1);
		System.out.println("str1: " + str1);
		
		//EUC-KR인코딩
		byte[] arr2 = data.getBytes("EUC-KR");
		System.out.println("ar1: " + Arrays.toString(arr2));
	
		// byte배열 -> String
		String str2 = new String(arr2, "EUC-KR");
		System.out.println("str2: " + str2);
	}
}
