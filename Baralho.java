package br.ufmg.dcc.pm.seteemeio;

import seteemeio.CartaBaralho;

/**
 *
 * @author ddayrell
 */
public interface Baralho extends ColecaoCartasBaralho {
    public void embaralhar();
    public void resetarBaralho();     
    public CartaBaralho retirarProximaCarta();   
}
