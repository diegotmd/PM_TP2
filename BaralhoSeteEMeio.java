package br.ufmg.dcc.pm.seteemeio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author ddayrell
 */
public class BaralhoSeteEMeio implements Baralho {

    private ArrayList<CartaBaralho> cartasBaralho;
    
    public BaralhoSeteEMeio(){
        this.cartasBaralho = new ArrayList<CartaBaralho>();
        // carregar cartas do baralho de sete e meio
        this.resetarBaralho();
    }
    
    @Override
    public void embaralhar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cortar(int posicaoCarta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CartaBaralho retirarProximaCarta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void resetarBaralho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CartaBaralho> cartasBaralho() {
        return cartasBaralho;
    }
    
}
