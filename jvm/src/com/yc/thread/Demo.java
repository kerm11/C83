package com.yc.thread;

public class Demo {
		String string="zz mmm";
	
	public void method2(){
		try{
		int a=1;
		char c='a';
		a=c+a;
		System.out.println("begin a="+a);
		return ;
		}catch(Exception e){
		System.out.println("exception....");
		}finally{
		System.out.println("end....");
		}
		}


	public void mehtod() {
		float a = 2.0f;
		double c = 2.0;
		long d = 2;
		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
		System.out.println(f1 == f2);// true

		System.out.println(f3 == f4);// false
	}

	static boolean foo(char c) {
		System.out.print(c);
		return true;
	}

	static int arr[] = new int[5];
	public static void main(String args[]) {
		System.out.println(arr[0]);
		Demo demo=new Demo();
		demo.method2();
		int i = 0;
		for (foo('A'); foo('B') && (i < 2); foo('c')) {
			i++;
			foo('D');
		}
	}

}
