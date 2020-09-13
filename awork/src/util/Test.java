package util;

public class Test {
	
	static boolean foo(char c) {
		System.out.println(c);
		return true;
	}
	
	public static void main(String[] args) {
		int i=0;
		
		for (foo('啊'); foo('哦')&&(i<3); foo('e')) {
			i++;
			foo('w');
		}
	}

}
