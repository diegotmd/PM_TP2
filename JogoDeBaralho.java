package br.ufmg.dcc.pm.seteemeio;

import java.util.Collection;
import java.util.Scanner;

public interface JogoDeBaralho {
	public String getNomeJogo();
	public Baralho getBaralho(int numeroBaralho);
	public Collection<Jogador> getJogadores();
	public void inicializarJogo(Scanner in);
	public String descricaoRegraJogo();
	
}
