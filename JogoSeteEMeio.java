package br.ufmg.dcc.pm.seteemeio;

import java.util.ArrayList;

import seteemeio.Banqueiro;

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
    	
    	// distribuir cartas aos jogadoes
    	for (Jogador jogador : jogadores) {
    		banqueiroAtual.distribuirCartas(jogador, baralhoSeteEMeio, false);
    	}
    	
    	// distribuir carta ao proprio banqueiro
    	banqueiroAtual.distribuirCartas(banqueiroAtual, baralhoSeteEMeio, false);    	
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
    	double valorBanqueiro = banqueiroAtual.getMaoAtual().calcularValorDaMao();
    	double valorJogador = 0.0;
    	Jogador novoBanqueiro = null;
    	
    	// calcular vencedores, mover valores
        for (Jogador jogador : jogadores) {
        	if (valorBanqueiro > 7.5) {
        		banqueiroAtual.bonificaJogador(jogador, 2);
        	} else {
        		valorJogador = jogador.getMaoAtual().calcularValorDaMao();
	        	if (valorJogador > 7.5) {
	        		// paga dobro da aposta feita ao banqueiro
	        		jogador.pagaAposta(banqueiroAtual, 2);	        		
	        	} else if (valorJogador == 7.5) {
	        		// banqueiro paga o dobro da aposta do jogador
	        		banqueiroAtual.bonificaJogador(jogador, 2);
	        		
	        		// se jogador tiver a carta coringa e uma carta meio, será novo banqueiro
	        		if (jogador.getMaoAtual().colecaoDeCartas().size() == 2) {
	        			/*if ((jogador.getMaoAtual().colecaoDeCartas().get(0).ehCartaCoringa() &&
	        				 jogador.getMaoAtual().colecaoDeCartas().get(1).getValor() == 0.5) ||
	        				(jogador.getMaoAtual().colecaoDeCartas().get(0).getValor() == 0.5 &&
	        				 jogador.getMaoAtual().colecaoDeCartas().get(1).ehCartaCoringa())) {
	        				novoBanqueiro = jogador;
	        			}*/
	        		}
	        	} else {
	        		if (valorJogador < valorBanqueiro) {
	        			// banqueiro paga aposta do jogador
	        			banqueiroAtual.bonificaJogador(jogador, 1);
	        		} else {
	        			// jogador paga aposta feita ao banqueiro
	        			jogador.pagaAposta(banqueiroAtual, 1);
	        		}
	        	}
        	}
        }
        
        if (novoBanqueiro != null) {
        	// trocar banqueiro para nova rodada
        	Jogador antigoBanqueiro = banqueiroAtual;
        	
        	banqueiroAtual = new Banqueiro(novoBanqueiro.getNome(), novoBanqueiro.getSaldoDisponivel(), novoBanqueiro.getJogoAtual());
        	jogadores.remove(novoBanqueiro);
        	
        	jogadores.add(antigoBanqueiro);
        }
    	
        // cria nova rodada
        this.novaRodada();
    }
    
    public Double getApostaMaxima() {
    	return this.apostaMaxima;
    }
    
    public Double getApostaMinima() {
    	return this.apostaMinima;
    }
}
