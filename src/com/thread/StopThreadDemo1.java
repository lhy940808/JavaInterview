package com.thread;
//ֹͣ�̵߳ķ���һ�� ���̵߳�run�������н�����ͨ��ͨ��������߳����н���
class StopDemo implements Runnable {
	boolean flag = true;
	public void run() {
		while(flag) {
			System.out.println(Thread.currentThread().getName() + "------------");
		}
	}
	
	public void setFlag () {
		this.flag = false;
	}
}

public class StopThreadDemo1 {

	public static void main(String[] args) {
		StopDemo sd = new StopDemo();
		
		new Thread(sd).start();
		new Thread(sd).start();
		
		int num = 0;
		for(;;) {
			if(++num == 50) {
				sd.setFlag();
				break;
			}
			System.out.println(Thread.currentThread().getName() + num + "----");
		}
	}
}
