package testclassloader;

public class Test1_original {
	public static void main(String[] args) {
		final int arg = 0;
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				task1(arg);
			}
		});
		t1.start();
	}

	public static void task1(int arg) {
		task2(arg); // 如果之后的方法里有使用到参数，那么需要继续传递,如不传递，则 arg丢失，如有多个参数，则每个参数都要传递，代码冗余.
	}

	public static void task2(int arg) {

	}
}
