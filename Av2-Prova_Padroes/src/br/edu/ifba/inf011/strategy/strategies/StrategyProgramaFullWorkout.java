package br.edu.ifba.inf011.strategy.strategies;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.builder.Exercicio;
import br.edu.ifba.inf011.modelo.TipoExercicio;
import br.edu.ifba.inf011.singleton.CatalogoExercicios;
import br.edu.ifba.inf011.strategy.Serie;

public class StrategyProgramaFullWorkout implements StrategyPrograma {

	private CatalogoExercicios catExe;
	private Serie serie;
	private List<Serie> series = new ArrayList<Serie>();
	private static int diaSemanaAtual;

	public StrategyProgramaFullWorkout(CatalogoExercicios catExe) {
		this.catExe = catExe;
	}

	@Override
	public boolean temProximo() {
		switch (diaSemanaAtual) {
		case 0: {
			diaSemanaAtual++;
			System.out.printf("\nSegunda : ");
			proxSerie();
			return true;
		}
		case 1: {
			System.out.printf("\nTerca : ");
			diaSemanaAtual++;
			serie = null;
			series.clear();
			return true;
		}
		case 2: {
			System.out.printf("\nQuarta : ");
			diaSemanaAtual++;
			proxSerie();
			return true;
		}
		case 3: {
			System.out.printf("\nQuinta : ");
			diaSemanaAtual++;
			serie = null;	
			series.clear();
			return true;
		}
		case 4: {
			System.out.printf("\nSexta : ");
			diaSemanaAtual++;
			proxSerie();
			return true;
		}
		case 5: {
			System.out.printf("\nSabado : ");
			diaSemanaAtual++;
			serie = null;
			return true;
		}
		case 6: {
			System.out.printf("\nDomingo : ");
			diaSemanaAtual++;
			return true;
		}
		default:
			diaSemanaAtual = 0;
			series.clear();
			return false;
		}
	}

	@Override
	public Serie proximo() {
		try {
			serie.setSeries(series);
			return serie;
		} catch (Exception e) {			
			return serie = null;
		}
	}

	public void proxSerie() {		
		serie = null;
		for (Exercicio e : catExe.getExerciciosCriados()) {
			this.serie = new Serie(e.getDescricao());
			series.add(serie);
		}
	}

}
