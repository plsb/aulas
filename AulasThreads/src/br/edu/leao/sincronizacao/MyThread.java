package br.edu.leao.sincronizacao;

public class MyThread implements Runnable{
	Thread thrd;
	static SumArray sa = new SumArray();
	int[] a;
	int answer;
	
	//Constrói uma nova Thread
	public MyThread(String name, int[] nums) {
		thrd = new Thread(this, name);
		a = nums;
		thrd.start();//inicia a thread
	}
	//começa a execução da nova thread
	public void run(){
		int sum;
		
		System.out.println(thrd.getName()+" starting.");
		//sincroniza as chamadas a sumArray()
//		synchronized (sa) {
			answer = sa.sumArray(a);
//		}		
		
		System.out.println("Sum for "+thrd.getName()+" is "+
					answer);
		
		System.out.println(thrd.getName()+" terminating.");
	}
}
