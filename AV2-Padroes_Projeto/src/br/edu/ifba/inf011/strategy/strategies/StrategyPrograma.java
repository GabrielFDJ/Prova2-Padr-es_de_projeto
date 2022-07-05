package br.edu.ifba.inf011.strategy.strategies;

import br.edu.ifba.inf011.strategy.Serie;

public interface StrategyPrograma {
	public boolean temProximo();
	public Serie proximo();
}
