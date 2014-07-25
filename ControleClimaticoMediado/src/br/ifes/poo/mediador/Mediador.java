package br.ifes.poo.mediador;

import java.util.ArrayList;

import br.ifes.poo.componentes.Interruptor;
import br.ifes.poo.sensores.Sensor;

public class Mediador {
	
	private ArrayList<Sensor> sensores;
	private Interruptor interruptor;
	
	public Mediador(){
		sensores = new ArrayList<Sensor>();
	}
	
	public void interruptorLigado(){
		sensoresAtivado();
		System.out.println("Equipamento ligado!");
	}
	
	public void interruptorDesligado(){
		sensoresDesativado();
		System.out.println("Equipamento desligado!");
	}
	
	public void sensoresAtivado(){
		for(Sensor sensor:sensores){
			sensor.ativar();
		}
		System.out.println("Sensores ativados!");
	}
	
	public void sensoresDesativado(){
		for(Sensor sensor:sensores){
			sensor.desativar();
		}
		System.out.println("Sensores desativados!");
	}
	
	public Boolean sensoresIsOn(){
		Boolean isOn=true;
		for(Sensor s : sensores){
			if(s.isOn() == false){
				isOn = false;	
			}			 
		}
		return isOn;
	}
	
	public Boolean interruptorIsOn(){
		return interruptor.isOn();
	}
	
	public void registrarInterruptor(Interruptor i){
		interruptor = i;
	}
	
	public void registrarSensores(Sensor s){
		sensores.add(s);
	}

}
