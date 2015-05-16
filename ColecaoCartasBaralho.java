/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.dcc.pm.seteemeio;

import java.util.Collection;

/**
 *
 * @author ddayrell
 */
public interface ColecaoCartasBaralho {
    public Collection <CartaBaralho> colecaoDeCartas();
    public CartaBaralho retirarProximaCarta();
}
