package br.edu.leao.suspende_resume_stop;

import java.lang.InterruptedException;

public class MyThread implements Runnable{
	Thread thrd;
	//suspende a thread quando for true
	boolean suspended;
	//encerra a thread qaundo for true
	boolean stopped;
	
	public MyThread(String name) {
		thrd = new Thread(this, name);
		suspended = false;
		stopped = false;
		thrd.start();
	}
	
	public void run(){
		System.out.println(thrd.getName()+" starting.");
		try {
			for (int i = 0; i < 1000; i++) {
				System.out.print(i+" ");
				if((i%10)==0){
					System.out.println();
					Thread.sleep(250);
				}
				/*
				 * um bloco sincronizado para
				 * verificar suspended e stopped
				 */
				synchronized (this) {
					while (suspended) {
						wait();						
					}
					if(stopped) break;
				}
			}		
		} catch (InterruptedException e) {
			System.out.println(thrd.getName()+" interrupted.");
		}
		System.out.println(thrd.getName()+" exiting.");
	}
	//encerra a thread
	synchronized void myStop(){
		stopped = true;
		/*
		 * o código a seguir a ssegura que
		 * uma thread suspensa possa ser 
		 * encerrada.
		 */
		suspended=false;
		notify();
	}
	//suspende a thread
	synchronized void mySuspend(){
		suspended = true;
	}
	//retoma a thread
	synchronized void myResume(){
		suspended = false;
		notify();
	}
	
}




