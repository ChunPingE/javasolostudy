package Ch17.sec06.exam01;

import java.util.ArrayList;
import java.util.List;

public class MapExample {
	public static void main(String[] args) {
		// list컬렉션 생성
		List<Student> stList = new ArrayList<>();
		stList.add(new Student("홍길동", 85));
		stList.add(new Student("홍길동", 92));
		stList.add(new Student("홍길동", 87));

		// score스트림으로 변환
		stList.stream()
				.mapToInt(s -> s.getScore())
				.forEach(score -> System.out.println(score));
	}
}
