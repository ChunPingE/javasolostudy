package newlecch05Collection.app.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program {
	public static void main(String[] args) {
		//GList<Integer> list = new GList<>();\
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(5);
		System.out.println(list.get(0)); //3
		System.out.println(list.size()); //5
		
		Set<Integer> set = new HashSet<>();
		set.add(3);
		set.add(6);
		set.add(7);
		set.add(7);
		set.add(7);
		System.out.println(set.size()); //3
		
		Map<String, Integer> map = new HashMap<>();
		map.put("id", 3);
		map.get("id");
		
		
//		list.clear();
//		int size = list.size();
//		System.out.println("size: " + size);
//		list.add(7);
//		int num = list.get(0); //Object -> Integer
//		System.out.println("num: " + num);
	}
}