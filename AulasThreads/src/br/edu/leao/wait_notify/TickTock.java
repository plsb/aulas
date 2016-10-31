package br.edu.leao.wait_notify;

public class TickTock {

	String state;//contém o estado do relógio
	
	synchronized void tick(boolean runnig){
		if(!runnig){//interrompe o relógio
			state = "ticked";
			notify();//notifica qualquer thread que
					//estiver esperando
			return ;
		}		
		System.out.println("Tick ");		
		state = "ticked";//define o estado atual com um ticked 		
		notify();		
		try {
			while(!state.equals("tocked"))
				wait();//espera tock terminar				
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted.");
		}
	}
	
	synchronized void tock(boolean runnig){
		if(!runnig){
			state = "tocked";
			notify();
			return ;
		}		
		System.out.println("Tock ");		
		state = "tocked";		
		notify();		
		try {
			while(!state.equals("ticked"))
				wait();				
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted.");
		}
	}
}
