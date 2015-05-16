package br.ufmg.dcc.pm.seteemeio;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author ddayrell
 */
public class Mao implements ColecaoCartasBaralho {
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

    @Override
    public Collection<CartaBaralho> colecaoDeCartas() {
        return cartasMao;
    }

    @Override
    public CartaBaralho retirarProximaCarta() {
        return cartasMao.remove(0);
    }
    
    
}
