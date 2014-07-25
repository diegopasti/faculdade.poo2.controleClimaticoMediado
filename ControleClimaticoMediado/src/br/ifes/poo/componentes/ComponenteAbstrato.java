package br.ifes.poo.componentes;

import br.ifes.poo.mediador.Mediador;

public class ComponenteAbstrato implements Componente {

	private Mediador controleComponente;
	private Boolean ativo=false;
	
	public ComponenteAbstrato(Mediador m){
		setControleComponente(m);
	}
	
	@Override
	public void ativar() {
		ativo = true;
	}

	@Override
	public void desativar() {
		ativo = false;		
	}

	public Mediador getControleComponente() {
		return controleComponente;
	}

	public void setControleComponente(Mediador controleComponente) {
		this.controleComponente = controleComponente;
	}

	@Override
	public Boolean isOn() {
		return ativo;
	}
}
