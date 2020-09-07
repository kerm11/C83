package com.yc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Aqs {
	
	public static void main(String[] args) {
	    
	    
	    for(int i=0;i<10;i++) {
	      new Thread(new Runnable() {
	        @Override
	        public void run() {
	          Aqs.inc();
	          System.out.println(  Thread.currentThread().getName()+"  "+ Aqs.count);
	        }
	      }).start();
	    }
	  }
	  
	  
	  private static int count=0;
	    static Lock lock=new ReentrantLock();
	    
	    public static void inc(){
	       // lock.lock();   //可以去掉  此句 测试一下没有加锁的区别
	        try {
	            Thread.sleep(1);
	            count++;
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }finally{
	          //  lock.unlock();
	        }
	    }

}
