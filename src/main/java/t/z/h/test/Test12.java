package t.z.h.test;

import java.util.Random;

public class Test12 {

	public static void main(String[] args) {
//		Random random = new Random();
//		System.out.println(random.nextInt(36));
//		System.out.println(random.nextInt(36));
		System.out.println(getRandom());
		System.out.println(System.nanoTime());
	}
	
	private static int getRandom() {
		long nanoTime = System.nanoTime();
		String valueOf = String.valueOf(nanoTime);
		System.out.println(valueOf.length());
		System.out.println(valueOf);
		String substring = valueOf.substring(11,13);
		return Integer.parseInt(substring);
	}
}
