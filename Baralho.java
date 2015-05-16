package br.ufmg.dcc.pm.seteemeio;

import java.util.Collection;

/**
 *
 * @author ddayrell
 */
public interface Baralho extends ColecaoCartasBaralho {
    public void embaralhar();
    public void cortar(int posicaoCarta);
    public void resetarBaralho();        
}
