package Ch17.sec07.exam02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingExample {
	public static void main(String[] args) {
		// List 컬렉션생성
		List<Student> stList = new ArrayList<>();
		stList.add(new Student("홍길동", 30));
		stList.add(new Student("신용권", 10));
		stList.add(new Student("유미선", 20));

		// 점수를 기준으로 오른차순으로 정렬한 새스트림 얻기
		stList.stream()
				.sorted((s1, s2) -> Integer.compare(s1.getScore(), s2.getScore()))
				.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));

		stList.stream()
				// s1과 s2의 순서를 바꿔 내림차순으로 정렬
				.sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
				.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
	}
}
