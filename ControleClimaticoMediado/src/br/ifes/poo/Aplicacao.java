package br.ifes.poo;

public class Aplicacao {

	public static void main(String[] args){
		Sala sala = new Sala();
		
		while(true){
			sala.exibirStatus();
			try {
				Thread.currentThread();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sala.atualizarSensores();			
		}
	}

}
