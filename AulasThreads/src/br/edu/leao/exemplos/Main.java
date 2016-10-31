package br.edu.leao.exemplos;

public class Main {
	
	public static void main(String[] args) {
		Thread thrd = new Thread(new MyThread(), "Teste");
		thrd.start();
	}

}
