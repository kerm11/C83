package util;

public class Test {
	public int count(){
		try{
		       return 5/0;
		}catch(Exception e){
			return 2*3;
		}finally{
		    return 3;
		}
		}

	public static void main(String args[]) {
		Test test=new Test();
		System.out.println(test.count());
	}
}

