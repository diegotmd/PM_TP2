package br.ufmg.dcc.pm.seteemeio;

import java.util.ArrayList;
import java.util.Collection;

import seteemeio.CartaBaralho;
import seteemeio.Naipe;

/**
 *
 * @author ddayrell
 */
public class Mao implements ColecaoCartasBaralho {
    private ArrayList <CartaBaralho> cartasMao;
    private Jogador jogador;
    
    public Mao(Jogador jogador){
        this.jogador = jogador;
        cartasMao = new ArrayList<CartaBaralho>();
    }
    
    public void adicionarCarta(CartaBaralho carta){
        // adicionar carta a mao
    	cartasMao.add(carta);
    }
    
    public double calcularValorDaMao(){
    	double valorMao = 0.0;
    	boolean possuiCoringa = false;
    	
        // calcula valor da mao sem levar em consideracao o coringa
    	for (CartaBaralho carta : cartasMao) {
           	if (carta.getNaipe() != Naipe.Ouros && carta.getValor() != 7) {
           		valorMao += carta.getValor();
           	} else {
           		possuiCoringa = true;
           	}
        }
        
        if (possuiCoringa) {
        	// identificar valor ideal para coringa
        	if (valorMao < 7.5) {
        		valorMao = 7.5;
        	} else {
        		// se o valor da mao ja tiver estourado sem contar com o coringa, apenas soma seu valor real
        		valorMao += 7;
        	}
        }
        
    	return valorMao;
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
