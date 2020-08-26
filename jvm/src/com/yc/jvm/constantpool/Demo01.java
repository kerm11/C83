package com.yc.jvm.constantpool;

/**
 * @company 源辰
 * @author navy
 *
 */
public class Demo01 {
	/**
	 * Java中八种基本类型的包装类的大部分都实现了常量池技术，
	 * 它们是Byte、Short、Integer、Long、Character、Boolean，
	 * 另外两种浮点数类型的包装类(Float、Double)则没有实现。
	 * 另外Byte,Short,Integer,Long,Character这5种整型的包装类也只是在对应值在-128到127时才可使用对象池。
	 */
	public static void main(String[] args) {
		// 对Integer一个字节访问范围的数据（~128-127），提前生成存到常量池
		// 当访问的数在这个范围是，会直接从常量池中获取，所以得到的地址会一样
		Integer num1 = 10;
		Integer num2 = 10;
		
		Integer num3 = 127;
		Integer num4 = 127;
		
		Integer num5 = 128;
		Integer num6 = 128;
		
		Integer num7 = -128;
		Integer num8 = -128;
		
		Integer num9 = -129;
		Integer num10 = -129;
		
		System.out.println(num1 == num2); // true
		System.out.println(num3 == num4); // true
		System.out.println(num5 == num6); // false
		System.out.println(num7 == num8); // true
		System.out.println(num9 == num10); // false
	}
}
