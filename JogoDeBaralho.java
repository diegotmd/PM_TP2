package br.ufmg.dcc.pm.seteemeio;

import java.util.ArrayList;
import java.util.Collection;

public interface JogoDeBaralho {
	public String getNomeJogo();
	public Baralho getBaralho(int numeroBaralho);
	public Collection<Jogador> getJogadores();
	public void inicializarJogo();
	public String descricaoRegraJogo();
	
}
