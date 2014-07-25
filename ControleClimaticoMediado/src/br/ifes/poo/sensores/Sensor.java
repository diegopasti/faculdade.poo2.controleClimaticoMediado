package br.ifes.poo.sensores;

import br.ifes.poo.componentes.Componente;

public interface Sensor extends Componente{
	
	public Double getValor();
	public void setValor(Double valor);

}
