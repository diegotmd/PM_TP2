package br.ufmg.dcc.pm.seteemeio;

import java.util.ArrayList;

/**
 *
 * @author ddayrell
 */
public class JogoSeteEMeio {
    private ArrayList <Jogador> jogadores;
    private double apostaMaxima;
    private double apostaMinima;
    private double apostaAtual;
    private Baralho baralhoSeteEMeio;
    private Banqueiro banqueiroAtual;
    
    public JogoSeteEMeio(double apostaMaxima, double apostaMinima){
        this.apostaMaxima = apostaMaxima;
        this.apostaMinima = apostaMinima;
        this.apostaAtual = 0;
        this.baralhoSeteEMeio = new BaralhoSeteEMeio();
        this.jogadores = new ArrayList<Jogador>();        
    }
    public ArrayList<Jogador> getJogadores(){
        return this.jogadores;
    }
    
    public void inicializar(){
        // inicializar jogo
    }
    
    public void adicionarJogador(Jogador jogador){
        // adicionar jogadores
        this.jogadores.add(jogador);
    }
    
    public void definirBanqueiro(Jogador jogador){
        this.banqueiroAtual = new Banqueiro(jogador.getNome(), jogador.getSaldoDisponivel(), this);
    }
    
    private void novaRodada(){
        // zerar maos, aposta atual, baralho, valores de apostas dos jogadores
    }
    
    public void fimRodada(){
        // calcular vencedores, mover valores
        
        // cria nova rodada
        this.novaRodada();
    }   
    
    
}
