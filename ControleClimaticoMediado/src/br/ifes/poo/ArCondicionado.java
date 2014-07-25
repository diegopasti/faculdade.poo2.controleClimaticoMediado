package br.ifes.poo;

import br.ifes.poo.extras.Observador;
import br.ifes.poo.extras.Observavel;

public class ArCondicionado implements Observador{
	private Sala sala;
	
	public ArCondicionado(Sala s){
		sala = s;
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
}
