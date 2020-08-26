package com.yc.jvm.constantpool;

/**
 * JVM对String的优化
 * @company 源辰
 * @author navy
 */
public class Demo02 {
	/**
	 * Java语言并不要求常量一定只能在编译期产生，运行时也可能将新的常量放入常量池中，这种特性用的最多的就是String.intern()方法。
	 * String的intern()方法就是扩充常量池的一个方法；当一个String实例str调用intern()方法时，Java查找常量池中是否有相同Unicode的字符串常量，
	 * 如果有则返回其的引用，如果没有，则在常量池中增加一个Unicode等于str的字符串并返回它的引用。
	 */
	public static void main(String[] args) {
		String str1 = "源辰"; // 没有用new会将其存到常量池
		String str2 = "源辰"; // 先到常量池中找，如果有直接返回在常量池中地址
		System.out.println(str1 == str2); // true
		
		String str3 = "源辰信息";
		String str4 = "源辰" + "信息"; // 编译时优化，编译的时候可以确实str4的值为"源辰信息"，此时常量池中有这个常量
		System.out.println(str3 == str4); // true
		
		String str5 = str2 + "信息"; // 编译的时候无法确定str2的值，无法优化
		System.out.println(str3 == str5); // false
		
		String str6 = new String("源辰信息"); // 使用了new关键字，必会在堆中申请空间，返回的是堆中的地址，而不是常量池中的地址
		System.out.println(str3 == str6); // false
		
		String str7 = str6.intern(); // 动态将str6加入到常量池，返回常量池中的地址
		System.out.println(str3 == str7); // true
	}
}
