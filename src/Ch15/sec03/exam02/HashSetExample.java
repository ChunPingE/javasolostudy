package Ch15.sec03.exam02;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		// HashSet컬렉션 생성
		Set<Member> set = new HashSet<>();

		// Member객체 저장
		// 인스턴스는 다르지만 동등객체이므로 객체1개만 저장
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));

		// 저장된 객체 수 출력
		System.out.println("총 객체 수: " + set.size()); // 1
	}
}
