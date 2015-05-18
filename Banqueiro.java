package br.ufmg.dcc.pm.seteemeio;

/**
 *
 * @author ddayrell
 */
public class Banqueiro extends Jogador implements DistribuidorDeCartas {

    public Banqueiro(String nome, double saldoInicial, JogoSeteEMeio jogo) {
        super(nome, saldoInicial, jogo);
    }

    @Override
    public void distribuirCartas(Jogador jogador, Baralho baralho, boolean cartaAberta) {
        if (baralho.colecaoDeCartas().size() > 0) {
            jogador.adicionarCartaAMao(baralho.retirarProximaCarta(), cartaAberta);
        } else {
            // lanca excecao
        }
    }
    
    public void bonificarJogador(Jogador jogador, int fator) {
    	if (this.getSaldoDisponivel() >= jogador.getValorApostaAtual() * fator) {
    		this.setSaldoDisponivel(this.getSaldoDisponivel() - (jogador.getValorApostaAtual() * fator));
    		jogador.receberAposta(jogador.getValorApostaAtual() * fator);
    	} else {
    		// lanca excecao
    	}
    }
}
