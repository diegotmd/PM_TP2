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
    public void distribuirCartas(Jogador jogador, Baralho baralho, int quantidade, boolean cartaAberta) {
        int i;
        for (i=0; i<quantidade; i++) {
            if (baralho.colecaoDeCartas().size() > 0){
                jogador.adicionarCartaAMao(baralho.retirarProximaCarta());
            } else {
                // lanca excecao
            }            
        }
    }
    
}
