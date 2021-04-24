package t.z.h.test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Test11 {
	static List<String> repository = new ArrayList<>();
	static List<Integer> sum = new ArrayList<>();
	static ArrayList<Integer> temporary = new ArrayList<>();
	static List<String> collect = new ArrayList<>();

	public static void main(String[] args) {
		boolean flag = false;
		int num = 0;
		for (;;) {
			int total = getTotal();
			if (total < 60 || total > 75) {
				continue;
			} else {
				if (repository.contains(temporary.toString())) {
//					flag = true;
					if(!collect.contains(temporary.toString())) {
						collect.add(temporary.toString());
					}
				} else {
					++ num;
					if (num > 600)
						break;
					repository.add(temporary.toString());
					for (Integer element : temporary) {
						sum.add(element);
					}
				}
			}
			if (flag) {
				break;
			}
		}
		for (int i = 0; i < repository.size(); i++) {
			System.out.println(i + 1 + " " + repository.get(i));
		}
		System.out.println("---------------------------------");
		for (int i = 0; i < collect.size(); i++) {
			System.out.println("SPECIAL:"+(i + 1) + " " + collect.get(i));
		}
		System.out.println("---------------------------------");
		Object[] array = sum.toArray();
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(String.valueOf(array[i]))) {
				map.put(String.valueOf(array[i]), map.getOrDefault(String.valueOf(array[i]), 0) + 1);
			} else {
				map.put(String.valueOf(array[i]), 1);
			}
		}
		Map<String, Integer> descending = sortByValueDescending(map);
		for (Entry<String, Integer> entry : descending.entrySet()) {
			System.out.println(entry);
		}
	}

	private static int getTotal() {
		temporary.removeAll(temporary);
		int nextInt = 0;
		Random random = new Random();
		for (;;) {
//			int nextInt2 = generateRandom(2);
			int nextInt2 = random.nextInt(36);
//			int nextInt2 = getRandomOfBound(35);
			if (!temporary.contains(nextInt2) && nextInt2 != 0) {
				temporary.add(nextInt2);
				nextInt += nextInt2;
				if (temporary.size() == 5) {
					return nextInt;
				}
			}
		}

	}

	private static int getRandomOfBound(int bound) {
		long nanoTime = System.nanoTime();
		String valueOf = String.valueOf(nanoTime);
		int parseInt = Integer.parseInt(valueOf.substring(11, 13));
		if (parseInt > bound) {
			if (parseInt > (parseInt / 2))
				parseInt = getRandomOfBound(bound);
		}
		return parseInt;
	}

	public static int generateRandom(int length) {
		SecureRandom random = new SecureRandom();
		byte[] randomBytes = new byte[length];
		random.nextBytes(randomBytes);
		StringBuilder sb = new StringBuilder(length);
		for (byte b : randomBytes) {
			sb.append(Math.abs(Byte.valueOf(b).intValue()) % 10);
		}
		return Integer.parseInt(sb.toString());
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDescending(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				int compare = (o1.getValue()).compareTo(o2.getValue());
				return -compare;
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueAscending(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				int compare = (o1.getValue()).compareTo(o2.getValue());
				return compare;
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

}
