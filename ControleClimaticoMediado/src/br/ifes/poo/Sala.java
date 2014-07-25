package br.ifes.poo;

import java.util.ArrayList;
import java.util.Random;

import br.ifes.poo.extras.Observavel;
import br.ifes.poo.sensores.Sensor;
import br.ifes.poo.sensores.SensorTemperatura;

public class Sala extends Observavel{
	private Double temperaturaInterna;
	private Double temperaturaExterna;
	
	private ArrayList<Sensor> sensoresExternos; 
	private ArrayList<Sensor> sensoresInternos;
	private ArCondicionado arCondicionado;
	
	public Sala(){
		configurarTemperaturas();
		configurarClimatizador();
		configurarSensores();		
	}
	
	public void ligarClimatizador(){
		arCondicionado.ligar();
	}
	
	public void desligarClimatizador(){
		arCondicionado.desligar();
	}
	
	public void exibirStatus(){
		System.out.println("Temperatura Interna: "+getTemperaturaInterna());
		System.out.println("Temperatura Externa: "+getTemperaturaExterna());	
	}
	
	public void atualizarSensores(){
		if(arCondicionado.getControleComponentes().sensoresIsOn()){
			atualizarAmbienteExterno();
			atualizarSala();
			notificarObservador();	
		}
		else{
			System.out.println("Sensores não estão ativos");
		}
	}
	
	private void atualizarSala(){
		int valor = new Random().nextInt(5);
		int fator = 0;
		int numPessoas = new Random().nextInt(5);
		
		if(valor==0){
			System.out.println("Entrou "+numPessoas+" pessoa(s) na sala");
			fator = 1;
		}
		else if(valor==4){
			System.out.println("Saiu "+numPessoas+" pessoa(s) na sala");
			fator = -1;
		}
		
		for(int k=0; k < sensoresInternos.size(); k++) sensoresInternos.get(k).setValor((double) (temperaturaInterna+((numPessoas+new Random().nextInt(11)/10)*fator)));
	}
	
	private void atualizarAmbienteExterno(){
		int valor = new Random().nextInt(10); 
		int fator = 0;
		int valortemp = new Random().nextInt(3);
		
		if(valor==0){
			System.out.println("A temperatura do ambiente externo aumentou");
			fator = 1;
		}
		else if(valor==9){
			System.out.println("A temperatura do ambiente externo diminuiu");
			fator = -1;
		}
		
		for(int k=0; k < sensoresExternos.size(); k++) sensoresExternos.get(k).setValor((double) (temperaturaExterna+((valortemp+new Random().nextInt(11)/10)*fator)));
	}
	
	private void configurarTemperaturas(){
		temperaturaExterna = 28.0;
		temperaturaInterna = 26.0;
	}
	
	private void configurarClimatizador(){
		arCondicionado = new ArCondicionado(this);
		addObservador(arCondicionado);
	}
	
	private void configurarSensores(){
		sensoresExternos = new ArrayList<Sensor>();
		sensoresInternos = new ArrayList<Sensor>();
		for(int k=0;k<3;k++){
			SensorTemperatura se = new SensorTemperatura(arCondicionado.getControleComponentes());
			se.setValor((double) temperaturaExterna);
			sensoresExternos.add(se);
		}
		for(int k=0;k<3;k++) {
			SensorTemperatura si = new SensorTemperatura(arCondicionado.getControleComponentes());
			si.setValor((double) temperaturaInterna);
			sensoresInternos.add(si);
		}
	}
	
	public void setTemperaturaInterna(Double v){
		temperaturaInterna = v;
	}
	
	public void setTemperaturaExterna(Double v){
		temperaturaExterna = v;
	}
	
	public Double getTemperaturaExterna(){
		Double tempExterna = 0.0;
		for(int k=0; k < sensoresExternos.size(); k++) tempExterna = tempExterna + sensoresExternos.get(k).getValor();
		return tempExterna/sensoresExternos.size();
	}
	
	public Double getTemperaturaInterna(){
		Double tempExterna = 0.0;
		for(int k=0; k < sensoresInternos.size(); k++) tempExterna = tempExterna + sensoresInternos.get(k).getValor();
		return tempExterna/sensoresInternos.size();
	}
}
