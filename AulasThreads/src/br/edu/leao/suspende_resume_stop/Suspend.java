package br.edu.leao.suspende_resume_stop;

public class Suspend {
	public static void main(String[] args) {
		MyThread ob1 = new MyThread("My Thread");
		try {
			Thread.sleep(1000);
			
			ob1.mySuspend();
			System.out.println("Suspeding thread.");
			Thread.sleep(1000);
			
			ob1.myResume();
			System.out.println("Resuming thread.");
			Thread.sleep(1000);
			
			ob1.mySuspend();
			System.out.println("Suspeding thread.");
			Thread.sleep(1000);
			
			ob1.myResume();
			System.out.println("Resuming thread.");
			Thread.sleep(1000);
			
			ob1.mySuspend();
			System.out.println("Suspeding thread.");
			ob1.myStop();
			
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		
		try {
			ob1.thrd.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		
		System.out.println("main thread exiting.");
	}
}
