package com.thread;
public class ThreadWaitBetter {

	public static void main(String[] args) {
		Source s = new Source();
		new Thread(new Write(s)).start();
		new Thread(new Out(s)).start();
	}
}


class Source {
	private String name;
	private String sex;
	public boolean flag ;

	public synchronized void write(String name, String sex){
		if (flag) {
			try {
				this.wait();				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		this.sex = sex;
		flag = true;
		notify();
	}

	public synchronized void out() {
		if( !flag ) {
			try{
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(name + "------" + sex);
		flag = false;
		notify();
	}
}

// 
class Write implements Runnable{
	Source s;
	public Write(Source s) {
		this.s = s;
	}

	public void run() {
		boolean status = true;
		while(true) {
			if(status) {
				s.write("guopanjie", "NANANANANANANANANANAN");
			}else {
				s.write("lhy", "spiderman---------------");
			}
			status = !status;
		}
	}

}
// 
// 
class Out implements Runnable {
	Source s;

	public Out (Source s) {
		this.s = s;
	}

	public void run() {
		s.out();
	}
}
