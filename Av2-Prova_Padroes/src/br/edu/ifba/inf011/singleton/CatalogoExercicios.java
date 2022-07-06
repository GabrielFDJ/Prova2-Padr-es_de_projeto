package br.edu.ifba.inf011.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.edu.ifba.inf011.builder.Exercicio;
import br.edu.ifba.inf011.builder.ExercicioBuilder;
import br.edu.ifba.inf011.exception.TipoIncompativelException;
import br.edu.ifba.inf011.factory.EquipamentoFactory;
import br.edu.ifba.inf011.modelo.Equipamento;
import br.edu.ifba.inf011.modelo.GrupoMuscular;
import br.edu.ifba.inf011.modelo.TipoExercicio;

public class CatalogoExercicios {

	private static List<Exercicio> exerciciosCriados  = new ArrayList<Exercicio>(); 
	
	public Exercicio newInstanceExercicio(String id, String descricao, List<TipoExercicio> tipos, List<GrupoMuscular> gruposMusculares
			, List<Equipamento> equipamentos){
		
		Exercicio exercicio = new Exercicio(id, descricao, tipos, gruposMusculares, equipamentos);	
		exerciciosCriados.add(exercicio);
		return exercicio;
	}

	public static List<Exercicio> getExerciciosCriados() {
		return exerciciosCriados;
	}
		
}
