package br.ufmg.dcc.pm.seteemeio;

import java.util.ArrayList;

/**
 *
 * @author ddayrell
 */
public class Mao {
    private ArrayList <CartaBaralho> cartasMao;
    private Jogador jogador;
    
    public Mao(Jogador jogador){
        this.jogador = jogador;
    }
    
    public void adicionarCarta(CartaBaralho carta){
        // adicionar carta a mao
    }
    
    public double calcularValorDaMao(){
        // calcula valor da mao, levar em consideracao o coringa
        return 0.0;
    }
}
