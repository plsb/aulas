package br.edu.leao.threadprincipal;

public class UseMain {	
	public static void main(String[] args) {
		Thread thrd;
		//acessa a thread principal
		thrd = Thread.currentThread();
		//exibe o nome da thread principal
		System.out.println("Main thread is called: "+
					thrd.getName());
		//exibe a prioridade da thread principal
		System.out.println("Priority: "+
					thrd.getPriority());
		
		System.out.println();
		//define o nome
		System.out.println("Setting name. \n");
		thrd.setName("Thread #1");
		
		System.out.println("Main thread is now called: "+
					thrd.getName());
	}
}
