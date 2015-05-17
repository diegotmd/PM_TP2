package br.ufmg.dcc.pm.seteemeio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ddayrell
 */
public class BaralhoSeteEMeio implements Baralho {

    private ArrayList<CartaBaralho> cartasBaralho;
    
    public BaralhoSeteEMeio(){
        // carregar cartas do baralho de sete e meio
        this.resetarBaralho();
    }
    
    @Override
    public void embaralhar() {
        Collections.shuffle(this.cartasBaralho);
    }

    @Override
    public CartaBaralho retirarProximaCarta() {
        return this.cartasBaralho.remove(0);
    }

    @Override
    public void resetarBaralho() {
        // reinicia o baralho com todas as cartas do sete e meio
        this.cartasBaralho = new ArrayList<CartaBaralho>();
        this.cartasBaralho.add(new CartaSeteEMeio("As de Paus", Naipe.Paus, 1, true));
        this.cartasBaralho.add(new CartaSeteEMeio("2 de Paus", Naipe.Paus, 2, true));
        this.cartasBaralho.add(new CartaSeteEMeio("3 de Paus", Naipe.Paus, 3, true));
        this.cartasBaralho.add(new CartaSeteEMeio("4 de Paus", Naipe.Paus, 4, true));
        this.cartasBaralho.add(new CartaSeteEMeio("5 de Paus", Naipe.Paus, 5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("6 de Paus", Naipe.Paus, 6, true));
        this.cartasBaralho.add(new CartaSeteEMeio("7 de Paus", Naipe.Paus, 7, true));
        this.cartasBaralho.add(new CartaSeteEMeio("Valete de Paus", Naipe.Paus, 0.5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("Dama de Paus", Naipe.Paus, 0.5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("Rei de Paus", Naipe.Paus, 0.5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("As de Espadas", Naipe.Espadas, 1, true));
        this.cartasBaralho.add(new CartaSeteEMeio("2 de Espadas", Naipe.Espadas, 2, true));
        this.cartasBaralho.add(new CartaSeteEMeio("3 de Espadas", Naipe.Espadas, 3, true));
        this.cartasBaralho.add(new CartaSeteEMeio("4 de Espadas", Naipe.Espadas, 4, true));
        this.cartasBaralho.add(new CartaSeteEMeio("5 de Espadas", Naipe.Espadas, 5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("6 de Espadas", Naipe.Espadas, 6, true));
        this.cartasBaralho.add(new CartaSeteEMeio("7 de Espadas", Naipe.Espadas, 7, true));
        this.cartasBaralho.add(new CartaSeteEMeio("Valete de Espadas", Naipe.Espadas, 0.5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("Dama de Espadas", Naipe.Espadas, 0.5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("Rei de Espadas", Naipe.Espadas, 0.5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("As de Copas", Naipe.Copas, 1, true));
        this.cartasBaralho.add(new CartaSeteEMeio("2 de Copas", Naipe.Copas, 2, true));
        this.cartasBaralho.add(new CartaSeteEMeio("3 de Copas", Naipe.Copas, 3, true));
        this.cartasBaralho.add(new CartaSeteEMeio("4 de Copas", Naipe.Copas, 4, true));
        this.cartasBaralho.add(new CartaSeteEMeio("5 de Copas", Naipe.Copas, 5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("6 de Copas", Naipe.Copas, 6, true));
        this.cartasBaralho.add(new CartaSeteEMeio("7 de Copas", Naipe.Copas, 7, true));
        this.cartasBaralho.add(new CartaSeteEMeio("Valete de Copas", Naipe.Copas, 0.5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("Dama de Copas", Naipe.Copas, 0.5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("Rei de Copas", Naipe.Copas, 0.5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("As de Ouros", Naipe.Ouros, 1, true));
        this.cartasBaralho.add(new CartaSeteEMeio("2 de Ouros", Naipe.Ouros, 2, true));
        this.cartasBaralho.add(new CartaSeteEMeio("3 de Ouros", Naipe.Ouros, 3, true));
        this.cartasBaralho.add(new CartaSeteEMeio("4 de Ouros", Naipe.Ouros, 4, true));
        this.cartasBaralho.add(new CartaSeteEMeio("5 de Ouros", Naipe.Ouros, 5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("6 de Ouros", Naipe.Ouros, 6, true));
        this.cartasBaralho.add(new CartaSeteEMeio("7 de Ouros", Naipe.Ouros, 7, true));
        this.cartasBaralho.add(new CartaSeteEMeio("Valete de Ouros", Naipe.Ouros, 0.5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("Dama de Ouros", Naipe.Ouros, 0.5, true));
        this.cartasBaralho.add(new CartaSeteEMeio("Rei de Ouros", Naipe.Ouros, 0.5, true));
    }

    @Override
    public List<CartaBaralho> colecaoDeCartas() {
        return cartasBaralho;
    }
}
