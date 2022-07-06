package br.edu.ifba.inf011;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Calendar;

import br.edu.ifba.inf011.builder.Exercicio;
import br.edu.ifba.inf011.builder.ExercicioBuilder;
import br.edu.ifba.inf011.exception.TipoIncompativelException;
import br.edu.ifba.inf011.modelo.Equipamento;
import br.edu.ifba.inf011.modelo.GrupoMuscular;
import br.edu.ifba.inf011.modelo.TipoExercicio;
import br.edu.ifba.inf011.observer.ConcrectSubject;
import br.edu.ifba.inf011.observer.Subject;
import br.edu.ifba.inf011.singleton.CatalogoEquipamentos;
import br.edu.ifba.inf011.singleton.CatalogoExercicios;
import br.edu.ifba.inf011.strategy.Programa;
import br.edu.ifba.inf011.strategy.Serie;
import br.edu.ifba.inf011.strategy.TipoPrograma;

public class Aval1 {	
	
	private void questao01(String fileName) throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, IOException {
		CatalogoEquipamentos ce = CatalogoEquipamentos.getCatalogo(fileName);
		try {
			Equipamento barra = ce.newInstance("Acessorio", "BARRA", 1);
			Equipamento peso = ce.newInstance("Halteres", "20Kg", 2);
			Exercicio exercicio = ExercicioBuilder.getFactory()
					  .clear().descricao("Supino")
					  .withEquipamento(barra)
					  .withEquipamento(peso)					  
					  .withGrupoMuscular(GrupoMuscular.Costa)
					  .withTipo(TipoExercicio.Cardiovascular).build("SUP01");
			System.out.println(exercicio);			
			
			Exercicio exercicio01 = ExercicioBuilder.getFactory()
					  .clear().descricao("Agachamento")
					  .withEquipamento(barra)
					  .withEquipamento(peso)
					  .withGrupoMuscular(GrupoMuscular.Inferiores)					  
					  .withTipo(TipoExercicio.Cardiovascular).build("INF02");
			System.out.println(exercicio01);			
			
			Exercicio exercicio02 = ExercicioBuilder.getFactory()
					  .clear().descricao("Apoio")
					  .withGrupoMuscular(GrupoMuscular.Peito)
					  .withGrupoMuscular(GrupoMuscular.Addominal)					  	
					  .withTipo(TipoExercicio.Funcional)
					  .build("APO01");
			System.out.println(exercicio02);			
					
			CatalogoExercicios cexe = new CatalogoExercicios();			
			
			ConcrectSubject csubject = new ConcrectSubject();			
			Programa programa = new Programa(csubject);				
			csubject.add(programa);			
			
			programa.setTipo(TipoPrograma.ABCD);
			programa.init(cexe);			
			while(programa.temProximo()) {
				Serie serie = programa.proximo();
				try {
					serie.executarVideo();
				} catch (Exception e) {
					System.out.printf("Repouso");
				}				
			}				
			
			
			
		} catch (TipoIncompativelException e) {
			e.printStackTrace();
		}
	}
	
	private void run(String fileName) throws FileNotFoundException, InstantiationException, 
							  IllegalAccessException, IllegalArgumentException, 
							  InvocationTargetException, NoSuchMethodException, 
							  SecurityException, ClassNotFoundException, IOException{
		
		this.questao01(fileName);		
		
	}
	
	public static void main(String[] args) throws Exception {
		(new Aval1()).run(args[0]);
	}

}
