package com.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//生产者线程生产数据，消费者消费数据

class Data {
	String name;
	int count = 0;
	boolean flag;
	Lock lock = new ReentrantLock();
//	获取condition对象
	Condition con = lock.newCondition();
	public void write(String name) {
		lock.lock();

		try{
			while(flag) {
				try {
					con.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			count++;
			this.name = name + count;
			System.out.println(Thread.currentThread().getName() + "product" + this.name);

			flag = true;
			con.signalAll();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void out() {
		lock.lock();
		try{
			while(!flag) {
				try {
					con.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + "consumer--------" + this.name);
			flag = false;
			con.signalAll();
		}
		finally {
			lock.unlock();
		}
	}
}

class Producer implements Runnable{

	Data d;
	public Producer(Data d) {
		this.d = d;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			d.write("数据");
		}
		
	}
	
}

class Consumer implements Runnable{
	
	Data d;
	public Consumer (Data d) {
		this.d = d;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			d.out();
		}
	}
	
}
public class LockDemo {
	public static void main(String[] args) {
		Data d = new Data();
		Producer p1 = new Producer(d);
		Producer p2 = new Producer(d);
		Consumer c1 = new Consumer(d);
		Consumer c2 = new Consumer(d);
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(c1).start();
		new Thread(c2).start();
		
	}
}
