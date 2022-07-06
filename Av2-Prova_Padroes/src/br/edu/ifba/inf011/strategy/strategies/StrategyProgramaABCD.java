package br.edu.ifba.inf011.strategy.strategies;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.builder.Exercicio;
import br.edu.ifba.inf011.modelo.GrupoMuscular;
import br.edu.ifba.inf011.singleton.CatalogoExercicios;
import br.edu.ifba.inf011.strategy.Serie;

public class StrategyProgramaABCD implements StrategyPrograma {

	private CatalogoExercicios catExe;	
	private Serie serie;
	private List<Serie> series = new ArrayList<Serie>();
	private static int diaSemanaAtual;

	public StrategyProgramaABCD(CatalogoExercicios catExe) {
		this.catExe = catExe;
	}

	@Override
	public boolean temProximo() {
		switch (diaSemanaAtual) {
		case 0: {
			diaSemanaAtual++;
			System.out.printf("\nSegunda : ");
			segunda();			
			return true;
		}
		case 1: {
			System.out.printf("\nTerca : ");
			diaSemanaAtual++;
			series.clear();
			terca();				
			return true;
		}
		case 2: {
			System.out.printf("\nQuarta : ");
			diaSemanaAtual++;
			series.clear();
			quarta();			
			return true;
		}
		case 3: {
			System.out.printf("\nQuinta : ");
			diaSemanaAtual++;
			series.clear();
			quinta();
			return true;
		}
		case 4: {
			System.out.printf("\nSexta : ");
			diaSemanaAtual++;
			serie = null;		
			return true;
		}
		case 5: {
			System.out.printf("\nSabado : ");
			diaSemanaAtual++;			
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

	public void segunda() {
		for (Exercicio e : catExe.getExerciciosCriados()) {
			GrupoMuscular grupo;
			boolean entrou = true;
			for (int i = 0; i < e.getGruposMusculares().size(); i++) {
				grupo = e.getGruposMusculares().get(i);
				if ((GrupoMuscular.Ombros.equals(grupo) || GrupoMuscular.Addominal.equals(grupo)) && entrou) {
					this.serie = new Serie(e.getDescricao());
					series.add(serie);
					entrou = false;
				}
			}
		}
	}

	public void terca() {
		serie = null;
		for (Exercicio e : catExe.getExerciciosCriados()) {
			GrupoMuscular grupo;
			boolean entrou = true;
			for (int i = 0; i < e.getGruposMusculares().size(); i++) {
				grupo = e.getGruposMusculares().get(i);
				if ((GrupoMuscular.Inferiores.equals(grupo) && entrou)) {
					this.serie = new Serie(e.getDescricao());					
					series.add(serie);
					entrou = false;				
				}
			}
		}
	}

	public void quarta() {
		serie = null;
		for (Exercicio e : catExe.getExerciciosCriados()) {
			GrupoMuscular grupo;
			boolean entrou = true;
			for (int i = 0; i < e.getGruposMusculares().size(); i++) {
				grupo = e.getGruposMusculares().get(i);
				if ((GrupoMuscular.Peito.equals(grupo) || (GrupoMuscular.Triceps.equals(grupo) && entrou))) {
					this.serie = new Serie(e.getDescricao());
					series.add(serie);
					entrou = false;
				}
			}
		}
	}

	public void quinta() {
		serie = null;
		for (Exercicio e : catExe.getExerciciosCriados()) {
			GrupoMuscular grupo;
			boolean entrou = true;
			for (int i = 0; i < e.getGruposMusculares().size(); i++) {
				grupo = e.getGruposMusculares().get(i);
				if ((GrupoMuscular.Costa.equals(grupo) || (GrupoMuscular.Biceps.equals(grupo) && entrou))) {
					this.serie = new Serie(e.getDescricao());
					series.add(serie);
					entrou = false;
				}
			}
		}
	}

}
