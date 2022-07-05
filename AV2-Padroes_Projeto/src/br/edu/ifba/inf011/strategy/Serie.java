package br.edu.ifba.inf011.strategy;

import java.util.List;

import br.edu.ifba.inf011.builder.Exercicio;
import br.edu.ifba.inf011.observer.Observer;

public class Serie{
	
	private int numRepeticoes;
	private int qtd;
	private String descricaoExercicio;
	private List<Serie> series;
	
	public Serie(String descricaoExercicio) {
		this.descricaoExercicio = descricaoExercicio;
	}
	
	public void executar() {		
		for(Serie s : this.getSeries()) {
			System.out.printf("- Serie [numRepeticoes=" + s.numRepeticoes + ", qtd=" + s.qtd + ", descricaoExercicio=" 
					+ s.descricaoExercicio + "]");
		}
	}		

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}	
}
