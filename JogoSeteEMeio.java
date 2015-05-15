package br.ufmg.dcc.pm.seteemeio;

import java.util.List;

/**
 *
 * @author ddayrell
 */
public class JogoSeteEMeio {
    private List <Jogador> jogadores;
    private double apostaMaxima;
    private double apostaMinima;
    private Baralho baralhoSeteEMeio;
    
    public JogoSeteEMeio(double apostaMaxima, double apostaMinima){
        this.apostaMaxima = apostaMaxima;
        this.apostaMinima = apostaMinima;
        this.baralhoSeteEMeio = new BaralhoSeteEMeio();
    }
    
    public void inicializar(){
        // inicializar jogo
    }
    
    public void adicionarJogador(Jogador jogador){
        // adicionar jogadores
    }
    
    private void novaRodada(){
        // zerar maos, baralho, valores de apostas dos jogadores
    }
    
    public void fimRodada(){
        // calcular vencedores, mover valores
        
        // cria nova rodada
        this.novaRodada();
    }   
    
    
}
