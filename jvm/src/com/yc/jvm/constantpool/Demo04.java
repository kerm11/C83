package com.yc.jvm.constantpool;

/**
 * @company 源辰
 * @author navy
 *
 */
public class Demo04 {
	/**
	 * JVM对于字符串引用info，它的值在编译期无法确定，只有在程序运行期调用方法后，
	 * 将方法的返回值和"yc" 来动态连接并分配地址为str2，故上面程序的结果为false。
	 */
	public static void main(String[] args) {
		String str1 = "ycinfo";
		final String info= getInfo();
		String str2 = "yc" + info;
		
		System.out.println( str1==str2 ); // false
	}

	private static String getInfo() {
		return "info";
	} 
}
