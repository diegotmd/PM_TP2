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
    /*public void distribuirCartas(Jogador jogador, Baralho baralho, int quantidade, boolean cartaAberta) {
        int i;
        for (i = 0; i < quantidade; i++) {
            if (baralho.colecaoDeCartas().size() > 0) {
                jogador.adicionarCartaAMao(baralho.retirarProximaCarta());
            } else {
                // lanca excecao
            }            
        }
    }*/
    
    /* Acho que não precisa de quantidade porque o jogador pode pedir quantas cartas quiser, mas pede uma
     * por vez, avalia e decide se pedirá mais
     */
    public void distribuirCartas(Jogador jogador, Baralho baralho, boolean cartaAberta) {
        if (baralho.colecaoDeCartas().size() > 0) {
            jogador.adicionarCartaAMao(baralho.retirarProximaCarta());
        } else {
            // lanca excecao
        }
    }
    
    public void bonificaJogador(Jogador jogador, int fator) {
    	if (this.getSaldoDisponivel() >= jogador.getValorApostaAtual() * fator) {
    		this.setSaldoDisponivel(this.getSaldoDisponivel() - (jogador.getValorApostaAtual() * fator));
    		jogador.recebeAposta(jogador.getValorApostaAtual() * fator);
    	} else {
    		// lanca excecao
    	}
    }
}
