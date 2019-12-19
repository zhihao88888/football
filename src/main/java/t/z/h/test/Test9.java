package t.z.h.test;

import java.util.HashMap;
import java.util.Map.Entry;

public class Test9 {
	public static void main(String[] args) {
		int[] array = {1,1,2,3,3,4};
		HashMap<String,Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if(map.containsKey(String.valueOf(array[i]))) {
				map.put(String.valueOf(array[i]), map.getOrDefault(String.valueOf(array[i]), 0)+1);
			}else {
				map.put(String.valueOf(array[i]),1);
			}
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue()>=2) {
				System.out.println(entry);
			}
		}
	}
	

}
