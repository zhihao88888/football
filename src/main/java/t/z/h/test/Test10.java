package t.z.h.test;

public class Test10 {
	public static void main(String[] args) {
		String str = "日职3.003.551.98";
		System.out.println(str.substring(0, str.length()-12));
		System.out.println(str.substring(str.length()-12, str.length()-8));
		System.out.println(str.substring(str.length()-8, str.length()-4));
		System.out.println(str.substring(str.length()-4, str.length()));
	}
}
