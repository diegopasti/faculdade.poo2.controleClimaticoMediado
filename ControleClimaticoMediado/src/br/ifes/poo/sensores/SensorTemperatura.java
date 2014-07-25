package br.ifes.poo.sensores;

public class SensorTemperatura implements Sensor{

	private Double valor;
	
	public SensorTemperatura(Double v){
		valor = v;
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
