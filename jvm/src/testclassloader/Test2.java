package testclassloader;

public class Test2 {

	static ThreadLocal<Integer> arg = new ThreadLocal<>();

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				// 初始化参数
				arg.set(0);
				// 参数无需再次传递
				task1();
			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				// 初始化参数
				arg.set(1);
				// 参数无需再次传递
				task1();
			}
		});
		t2.start();

	}

	public static void task1() {
		task2();
	}

	public static void task2() {
		System.out.println(arg.get());
	}
}
