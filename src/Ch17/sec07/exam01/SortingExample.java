package Ch17.sec07.exam01;

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

		// 점수를 기준으로 오른차수능로 정렬한 새스트림 얻기
		stList.stream()
				.sorted()
				.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
		System.out.println();

		// 내림차순으로 정렬한 새스트림얻기
		stList.stream()
				.sorted(Comparator.reverseOrder())
				.forEach(s -> System.out.println(s.getName() + ": " + s.getScore()));
	}
}
