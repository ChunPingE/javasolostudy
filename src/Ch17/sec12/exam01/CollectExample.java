package Ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		// List 컬렉션생성
		List<Student> totalList = new ArrayList<>();
		totalList.add(new Student("홍길동", "남", 92));
		totalList.add(new Student("김수영", "여", 57));
		totalList.add(new Student("김자바", "남", 95));
		totalList.add(new Student("오해영", "여", 93));

		/*
		 * //원래 List<Student> maleList = totalList.stream() .filter(s ->
		 * s.getSex().equals("남")) .collect(Collectors.toList());
		 */

		// 남학생만 묶어 list생성
		List<Student> maleList = totalList.stream()
				.filter(s -> s.getSex().equals("남"))
				.toList();

		maleList.stream()
				.forEach(s -> System.out.println(s.getName()));
		//홍길동 김자바
		System.out.println();

		// 학생 이름을 키 학생 점수를 값으로 갖는 Map
		Map<String, Integer> map = totalList.stream()
				.collect(Collectors.toMap(
						s -> s.getName(),
						s -> s.getScore()));

		System.out.println(map); // {김자바=95, 오해영=93, 홍길동=92, 김수영=57}
	}
}
