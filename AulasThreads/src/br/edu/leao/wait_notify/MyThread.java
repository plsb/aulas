package br.edu.leao.wait_notify;

public class MyThread implements Runnable{
	
	Thread thrd;
	TickTock ttOb;
	
	//constrói uma nova thread
	public MyThread(String name, TickTock tt) {
		thrd = new Thread(this, name);
		ttOb = tt;
		thrd.start();//inicia a thread
	}
	//começa a execução da nova thread
	public void run(){
		if(thrd.getName().compareTo("Tick")==0){
			for (int i = 0; i < 5; i++) {
				ttOb.tick(true);
				ttOb.tick(false);
			}
		} else {
			for (int i = 0; i < 5; i++) {
				ttOb.tock(true);
				ttOb.tock(false);
			}
		}		
	}
}
