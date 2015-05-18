package br.ufmg.dcc.pm.seteemeio;

import java.util.ArrayList;
import java.util.Collection;

import br.ufmg.dcc.pm.seteemeio.CartaBaralho;
import br.ufmg.dcc.pm.seteemeio.Naipe;

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
    
    public void abrirCartasFechadas() {
    	for (CartaBaralho carta : this.cartasMao) {
    		carta.abrirCarta();
    	}
    }
    
    public double calcularValorDaMao(){
    	double valorMao = 0.0;
    	boolean possuiCoringa = false;
    	
        // calcula valor da mao sem levar em consideracao o coringa
    	for (CartaBaralho carta : cartasMao) {
    		if (carta.ehCartaCoringa()) {
           		possuiCoringa = true;
           	} else {
           		valorMao += carta.getValor();
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
    
    public double calcularValorDaMaoAberta(){
    	double valorMaoAberta = 0.0;
    	boolean possuiCoringa = false;
    	
        // calcula valor da mao sem levar em consideracao o coringa
    	for (CartaBaralho carta : cartasMao) {
           	if (carta.valorEhAberto()) {
	    		if (carta.ehCartaCoringa()) {
	           		possuiCoringa = true;
	           	} else {
	           		valorMaoAberta += carta.getValor();
	           	}
           	}
        }
        
        if (possuiCoringa) {
        	// identificar valor ideal para coringa
        	if (valorMaoAberta < 7.5) {
        		valorMaoAberta = 7.5;
        	} else {
        		// se o valor da mao ja tiver estourado sem contar com o coringa, apenas soma seu valor real
        		valorMaoAberta += 7;
        	}
        }
        
    	return valorMaoAberta;
    }

    @Override
    public ArrayList<CartaBaralho> colecaoDeCartas() {
        return cartasMao;
    }

    @Override
    public CartaBaralho retirarProximaCarta() {
        return cartasMao.remove(0);
    }
      
}
