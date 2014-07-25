package br.ifes.poo;

import br.ifes.poo.extras.Observador;
import br.ifes.poo.extras.Observavel;
import br.ifes.poo.mediador.Mediador;

public class ArCondicionado implements Observador{
	
	private Sala sala;
	private Mediador controleComponentes;
	
	public ArCondicionado(Sala s){
		setControleComponentes(new Mediador());
		sala = s;
	}
	
	public void ligar(){
		controleComponentes.interruptorLigado();
	}
	
	public void desligar(){
		controleComponentes.interruptorDesligado();
	}

	
	@Override
	public void update(Observavel obs) {
		sala = (Sala) obs;
		if(sala.getTemperaturaInterna() > 25) {
			System.out.println("Temos que diminuir a temperatura");
			sala.setTemperaturaInterna(sala.getTemperaturaInterna()-1.0);
		}
		else if(sala.getTemperaturaInterna() < 25){
			System.out.println("Temos que diminuir a temperatura");
			sala.setTemperaturaInterna(sala.getTemperaturaInterna()+1.0);
		}
		else{
			System.out.println("Ta na temperatura adequada");
		}
	}

	public Mediador getControleComponentes() {
		return controleComponentes;
	}

	public void setControleComponentes(Mediador controleComponentes) {
		this.controleComponentes = controleComponentes;
	}
}
