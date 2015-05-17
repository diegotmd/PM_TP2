package br.ufmg.dcc.pm.seteemeio;

import java.util.Collection;

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
