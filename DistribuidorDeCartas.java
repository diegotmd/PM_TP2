/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufmg.dcc.pm.seteemeio;

/**
 *
 * @author ddayrell
 */
public interface DistribuidorDeCartas {
    // capacidade de distribuir cartas de um baralho para um jogador especifico
    public void distribuirCartas(Jogador jogador, Baralho baralho, boolean cartaAberta);
}
