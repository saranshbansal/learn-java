package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Collections {
	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		map.put(5, "a");
		map.put(2, "b");
		map.put(3, "c");
		
		java.util.List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(10);
		list.add(7);
		
		System.out.println(new TreeMap<>(map));
		
		System.out.println(list);
		
		String foo = new String("bar");
		String bar = "bar";
		System.out.println(foo == bar);
		System.out.println(foo.compareTo(bar));
		System.out.println(foo.equals(bar));
	}
}
