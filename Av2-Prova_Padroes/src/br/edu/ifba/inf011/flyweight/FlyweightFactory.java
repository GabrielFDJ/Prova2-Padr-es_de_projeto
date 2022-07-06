package br.edu.ifba.inf011.flyweight;

import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.inf011.builder.Exercicio;
import br.edu.ifba.inf011.builder.ExercicioBuilder;
import br.edu.ifba.inf011.singleton.CatalogoEquipamentos;
import br.edu.ifba.inf011.singleton.CatalogoExercicios;

public class FlyweightFactory {
	private static FlyweightFactory intance = new FlyweightFactory();    
    
    private CatalogoExercicios catexe;   

    public Exercicio getExercicio(String desc){		
    	Exercicio exe = null;
    	for (Exercicio e : catexe.getExerciciosCriados()) {    		
    		if(desc.equals(e.getDescricao())) {
    			exe = e;    			
    		}	
    	}
    	
		if(exe == null) {			
			exe = getExerciciobyDesc(desc);
		}
		return exe;
	}

    private Exercicio getExerciciobyDesc(String desc) {	    	
		return ExercicioBuilder.getFactory().clear().descricao(desc).build("exercicioFlyweight");				
	}
   
    public static FlyweightFactory getIntance() {
        return intance;
    }

}
