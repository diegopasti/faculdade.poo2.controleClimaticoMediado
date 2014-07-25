package br.ifes.poo.componentes;

import br.ifes.poo.mediador.Mediador;

public class Interruptor extends ComponenteAbstrato {

	public Interruptor(Mediador m) {
		super(m);
		getControleComponente().registrarInterruptor(this);
	}
	
	
	
}
