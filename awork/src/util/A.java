package util;

public class A {
	public static void main(String[] args) {
		Integer f1 = 100,f2=100,f3=150,f4=150;
		System.out.println(f1==f2);
		System.out.println(f3==f4);

		 B a = new B();
	}
	static {
		System.out.print("static A");
	}

	public A() {
		System.out.print("construtor A ");
	}
}

class B extends A {
	static {
		System.out.print("static B  ");
	}

	public B() {
		System.out.print("construtor B  ");
	}
}
