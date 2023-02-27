package Ch17.sec03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동", 10),
				new Student("신용권", 20),
				new Student("유미선", 30));

		// 방법1
		Stream<Student> stStream = list.stream();
		IntStream scoreStream = stStream.mapToInt(student -> student.getScore());
		double avg = scoreStream.average().getAsDouble();

		System.out.println("기본:" + avg); // 기본:20.0

		// 방법2
		double avg2 = list.stream()
				.mapToInt(st -> st.getScore())
				.average()
				.getAsDouble();

		System.out.println("메소드체이닝:" + avg2); // 메소드체이닝:20.0
	}
}
