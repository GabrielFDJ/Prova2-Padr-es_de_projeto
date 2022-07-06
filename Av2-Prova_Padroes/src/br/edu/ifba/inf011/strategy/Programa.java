package br.edu.ifba.inf011.strategy;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.swing.text.AbstractDocument.Content;

import br.edu.ifba.inf011.observer.ConcrectSubject;
import br.edu.ifba.inf011.observer.Observer;
import br.edu.ifba.inf011.singleton.CatalogoEquipamentos;
import br.edu.ifba.inf011.singleton.CatalogoExercicios;
import br.edu.ifba.inf011.strategy.strategies.StrategyPrograma;
import br.edu.ifba.inf011.strategy.strategies.StrategyProgramaABCD;
import br.edu.ifba.inf011.strategy.strategies.StrategyProgramaFullWorkout;
import br.edu.ifba.inf011.strategy.strategies.StrategyProgramaTreinoCardio;

public class Programa implements Observer{	
	
	private TipoPrograma tipoPrograma;
	
	private StrategyPrograma strategyPrograma;
	
	private ConcrectSubject concrectSubject;
	
	public Programa (ConcrectSubject concrectSubject) {
		this.concrectSubject = concrectSubject;		
	}
	
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
		Boolean status = strategyPrograma.temProximo();
		concrectSubject.setStatus(status);
		return status;	
	}
	
	public Serie proximo() {
		return strategyPrograma.proximo();
	}

	@Override
	public void update(boolean status) {		
		if(!status) {
			notificacao();
		} 	
	}
	
	@Override
	public String dateNow() {
		String timeNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		return timeNow;		
	}
	
	public void notificacao() {
		System.out.println("\nPrograma " + tipoPrograma.name() + " foi finalizado as : " + dateNow());
	}

	
}
