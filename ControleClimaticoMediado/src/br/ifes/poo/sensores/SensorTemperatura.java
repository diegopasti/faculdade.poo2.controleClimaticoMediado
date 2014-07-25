package br.ifes.poo.sensores;

import br.ifes.poo.componentes.ComponenteAbstrato;
import br.ifes.poo.mediador.Mediador;

public class SensorTemperatura extends ComponenteAbstrato implements Sensor{

	private Double valor;
	
	public SensorTemperatura(Mediador m) {
		super(m);
		getControleComponente().registrarSensores(this);
		
	}
	
	public void ativar(){
		super.ativar();
	}
	
	public void desativar(){
		super.desativar();
	}
		
	@Override
	public Double getValor() {
		return valor;
	}

	@Override
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
