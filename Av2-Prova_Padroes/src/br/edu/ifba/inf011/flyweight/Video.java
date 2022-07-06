package br.edu.ifba.inf011.flyweight;

import br.edu.ifba.inf011.builder.Exercicio;

public class Video {
	
    private Exercicio exercicio;

    public Video(Exercicio exercicio){        
        this.exercicio = exercicio;
    }    
    
    public Exercicio getExercicio() {
        return exercicio;
    }
    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    @Override
    public String toString() {    	
        return "[FLY - VIDEO DO EXERCICIO " +exercicio.getDescricao() + "]/ ";
    }

	
	
	
}
