package br.edu.ifba.inf011.strategy;

import br.edu.ifba.inf011.singleton.CatalogoEquipamentos;
import br.edu.ifba.inf011.singleton.CatalogoExercicios;
import br.edu.ifba.inf011.strategy.strategies.StrategyPrograma;
import br.edu.ifba.inf011.strategy.strategies.StrategyProgramaABCD;
import br.edu.ifba.inf011.strategy.strategies.StrategyProgramaFullWorkout;
import br.edu.ifba.inf011.strategy.strategies.StrategyProgramaTreinoCardio;

public class Programa {
	
	private TipoPrograma tipoPrograma;
	
	private StrategyPrograma strategyPrograma;
	
	public Programa () {}
	
	public TipoPrograma setTipo(TipoPrograma tipoPrograma) {
		return this.tipoPrograma = tipoPrograma;
	}
	
	public void init(CatalogoExercicios cexe) {
		if(TipoPrograma.ABCD.equals(tipoPrograma)){			
			strategyPrograma = new StrategyProgramaABCD(cexe);			
		}
		else if(TipoPrograma.TREINAMENTOCARDIO.equals(tipoPrograma)){			
			strategyPrograma = new StrategyProgramaTreinoCardio(cexe);				
		}
		else if(TipoPrograma.FULLWORKOUT.equals(tipoPrograma)){			
			strategyPrograma = new StrategyProgramaFullWorkout(cexe);				
		}	
		System.out.println("\nTipo de programa selecionado : " + tipoPrograma);
	}
	
	public boolean temProximo() {
		return strategyPrograma.temProximo();		
	}
	
	public Serie proximo() {
		return strategyPrograma.proximo();
	}	
}
