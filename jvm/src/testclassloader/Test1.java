package testclassloader;

public class Test1 {

	public static void main(String[] args) {
		// String的类加载器是根加载器，它是C++编写的，获取不当，所以为null
	    //     jdk  
	    System.out.println(    "bootstrap:"+ String.class.getClassLoader() );
	    //根加载器加载的目录可以通过以下获取到
	    // /Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home/jre/lib/sunrsasign.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home/jre/classes
	    System.out.println(System.getProperty("sun.boot.class.path"));
	    
	    //扩展类加载器
	    ///Users/yingzhang/Library/Java/Extensions:/Library/Java/JavaVirtualMachines/jdk1.8.0_51.jdk/Contents/Home/jre/lib/ext:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java
	    System.out.println(System.getProperty("java.ext.dirs"));
	    
	    //系统类加载器
	    ///Users/yingzhang/Documents/workspace/deadlock/bin
	    System.out.println(  System.getProperty("java.class.path"));
	    
	    // sun.misc.Launcher$AppClassLoader@73d16e93
	    System.out.println(  "当前类的加载器:"+ Test1.class.getClassLoader() );
	    
	    // sun.misc.Launcher$ExtClassLoader@15db9742
	    System.out.println( "当前类的父类加载器是扩展类加载器，它是:" + Test1.class.getClassLoader().getParent()  );
	    
	    System.out.println( "根加载器"+ Test1.class.getClassLoader().getParent().getParent() );   // null

	}

}
