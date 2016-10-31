package br.edu.leao.inicio;


public class MyThread 
			implements Runnable {	
	Thread thrd;

	//construtor
	public MyThread(String name) {
		thrd = new Thread(this, name);
		//inicia thread
		thrd.start();
	}
	//come�a a execu��o da nova thread
	public void run() {
		System.out.println(thrd.getName() 
				+ " starting.");
		try {
			for (int count = 0; 
						count < 10; count++) {
				/*
				 * M�todo Sleep faz a thread em que �
				 * chamada suspender a execu��o pelo 
				 * per�odo de milissegundos especificado 
				 */
				Thread.sleep(400);
				System.out.println("In " 
						+ thrd.getName() 
						+ ", count is " + count);
			}
		} catch (InterruptedException exc) {
			System.out.println(thrd.getName()
					+" interrupted.");
		}
		System.out.println(thrd.getName()
				+" terminating.");
	}
}
