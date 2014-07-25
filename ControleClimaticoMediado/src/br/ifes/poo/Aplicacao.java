package br.ifes.poo;

public class Aplicacao {

	public static void main(String[] args){
		int cont =0;
		Sala sala = new Sala();
		System.out.println("O Climatizador realizara teste por 15 segundos e desligara automaticamente.");
		sala.ligarClimatizador();
		while(true){
			sala.exibirStatus();
			try {
				Thread.currentThread();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sala.atualizarSensores();
			cont +=3;
			if(cont >= 15){
				break;
			}
			
		}
		System.out.println("O Climatizador concluiu os testes e desligara automaticamente.");
		sala.desligarClimatizador();
	}
}
