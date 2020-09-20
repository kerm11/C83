package util;

public class Demo {
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.method();
		System.out.println(Demo.getValue(6));
	}

	public static int getValue(int i) {
		int result = 0;
		switch (i) {
		case 1:
			result = result + i;
		case 2:
			result = result + i * 2;
		case 3:
			result = result + i * 3;
		}
		return result;
	}

	public void method() {
		try {
			Integer a = 1;
			char c = 'a';
			a = c + a;
			System.out.println("begin a=" + a);
			return;
		} catch (Exception e) {
			System.out.println("exception....");
		} finally {
			System.out.println("end....");
		}
	}

}
