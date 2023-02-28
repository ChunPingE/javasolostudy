package Ch17.sec11;

import java.util.ArrayList;
import java.util.List;

import Ch17.sec07.exam01.Student;

public class ReductionExample {
	public static void main(String[] args) {
		// List 컬렉션생성
		List<Student> stList = new ArrayList<>();
		stList.add(new Student("홍길동", 92));
		stList.add(new Student("신용권", 95));
		stList.add(new Student("유미선", 88));

		// 방법1
		int sum1 = stList.stream()
				.mapToInt(student -> student.getScore())
				.sum();
		
		//방법2
		int sum2 =  stList.stream()
				.mapToInt(student -> student.getScore())
				.reduce(0, (a,b) -> a+b);
		
		System.out.println("sum1: " + sum1);
		System.out.println("sum2: " + sum2);
	}
}
