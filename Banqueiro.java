package br.ufmg.dcc.pm.seteemeio;

import br.ufmg.dcc.pm.seteemeio.Jogador;

/**
 *
 * @author ddayrell
 */
public class Banqueiro extends Jogador implements DistribuidorDeCartas {

    public Banqueiro(String nome, double saldoInicial, JogoSeteEMeio jogo) {
        super(nome, saldoInicial, jogo);
    }

    @Override
    public void distribuirCartas(Jogador jogador, Baralho baralho, boolean cartaAberta) throws Exception {
        if (baralho.colecaoDeCartas().size() > 0) {
            jogador.adicionarCartaAMao(baralho.retirarProximaCarta(), cartaAberta);
        } else {
            throw new Exception("Nao ha mais cartas para distribuicao. Fim de jogo!");
        }
    }
    
    public void bonificarJogador(Jogador jogador, int fator) {
   		this.setSaldoDisponivel(this.getSaldoDisponivel() - (jogador.getValorApostaAtual() * fator));
   		jogador.receberAposta(jogador.getValorApostaAtual() * fator);
    }
}
