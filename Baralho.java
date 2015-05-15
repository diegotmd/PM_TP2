package br.ufmg.dcc.pm.seteemeio;

import java.util.Collection;

/**
 *
 * @author ddayrell
 */
public interface Baralho {
    public Collection<CartaBaralho> cartasBaralho();
    public void embaralhar();
    public void cortar(int posicaoCarta);
    public CartaBaralho retirarProximaCarta();
    public void resetarBaralho();        
}
