package Ch12.sec04;

import java.util.Properties; //getProperties는 모든 시스템이 가지고있는 객체
import java.util.Set;

public class GetPropertyExample {
	public static void main(String[] args) {
		//운영체제와 사용자 정보 출력
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		System.out.println(osName);
		System.out.println(userName);
		System.out.println(userHome);
		
		//전체키와 값을 출력
		System.out.println("--------------------");
		System.out.println("key: value");
		System.out.println("--------------------");
		Properties props = System.getProperties();
		Set keys = props.keySet(); //컬렉션 set에 담음
		
		for (Object objkey : keys) {
			String key = (String) objkey;
			String value = System.getProperty(key);
			System.out.printf("%-40s: %s\n", key, value);
		}
	}
}
