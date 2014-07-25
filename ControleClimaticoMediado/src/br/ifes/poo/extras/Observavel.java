package br.ifes.poo.extras;

public class Observavel {
	
	protected Observador observador;
	
	
	public void addObservador(Observador obs){
		observador = obs;
	}
	
	public void removeObservador(Observador obs){
		observador = null;
	}
	
	public void notificarObservador(){
		observador.update(this);
	}

}
