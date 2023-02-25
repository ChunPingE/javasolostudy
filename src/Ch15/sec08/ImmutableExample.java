package Ch15.sec08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableExample {
	public static void main(String[] args) {
		// of() 메소드 사용
		// List
		List<String> immutabeList1 = List.of("A", "B", "C");
		// immutabeList1.add("D") 불가능

		// Set
		Set<String> immutabeSet1 = Set.of("A", "B", "C");
		// immutabeSet1.remove("A") 불가능

		// Map
		Map<Integer, String> immutabeMap1 = Map.of(
				1, "A",
				2, "B",
				3, "C");
		// immutabeMap1.put(4, "D") 불가능

		// 불변컬렉션으로 복사
		// List
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		List<String> immutabeList2 = List.copyOf(list);

		// Set
		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("B");
		set.add("C");
		Set<String> immutabeSet2 = Set.copyOf(set);

		// Map
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		Map<Integer, String> immutabeMap2 = Map.copyOf(map);

		// 배열로브터 List불변컬렉션생성
		String[] arr = { "A", "B", "C" };
		List<String> immutabeList3 = Arrays.asList(arr);
	}
}
