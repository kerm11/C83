package com.yc.jvm.constantpool;

/**
 * @company 源辰
 * @author navy
 *
 */
public class Demo03 {
	/**
	 * 此时"yc"字符串加了final修饰，对于final修饰的变量，它在编译时被解析为常量值的一个本地拷贝存储到自己的常量池中
	 * 或嵌入到它的字节码流中。所以此时的str2 + "info" 和 "yc" + "info"效果是一样的。故上面程序的结果为true。
	 */
	public static void main(String[] args) {
		String str1 = "ycinfo";
		final String str2 = "yc";
		String str3 = str2 + "info";
				
		System.out.println( str1==str3 ); // true
	}
}
