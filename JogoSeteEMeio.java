package br.ufmg.dcc.pm.seteemeio;

import java.util.Scanner;
import java.util.ArrayList;

import br.ufmg.dcc.pm.seteemeio.Banqueiro;
import br.ufmg.dcc.pm.seteemeio.Jogador;

/**
 *
 * @author ddayrell
 */
public class JogoSeteEMeio implements JogoDeBaralho {
    private ArrayList <Jogador> jogadores;
    private double apostaMaxima;
    private double apostaMinima;
    private Baralho baralhoSeteEMeio;
    private Banqueiro banqueiroAtual;
    
    public JogoSeteEMeio(double apostaMaxima, double apostaMinima){
        this.apostaMaxima = apostaMaxima;
        this.apostaMinima = apostaMinima;
        this.baralhoSeteEMeio = new BaralhoSeteEMeio();
        this.jogadores = new ArrayList<Jogador>();        
    }
    
    public ArrayList<Jogador> getJogadores(){
        return this.jogadores;
    }
    
    @Override
    public String descricaoRegraJogo() {
            return "Regra do jogo de Sete e Meio:";
    }

    @Override
    public String getNomeJogo() {
            return "Sete e Meio";
    }

    @Override
    public Baralho getBaralho(int numeroBaralho) {
            return baralhoSeteEMeio;
    }

    @Override
    public void inicializarJogo(Scanner in) {

        // inicializar jogo
    	
    	// embaralha
    	this.baralhoSeteEMeio.embaralhar();
    	
    	// distribuir cartas aos jogadoes
    	for (Jogador jogador : jogadores) {
    		banqueiroAtual.distribuirCartas(jogador, baralhoSeteEMeio, false);
    	}
    	
    	// distribuir carta ao proprio banqueiro
    	banqueiroAtual.distribuirCartas(banqueiroAtual, baralhoSeteEMeio, false);

        // rodada de apostas iniciais
        this.fazerApostasIniciais(in);
    }
    
    private void fazerApostasIniciais(Scanner in){
        // para cada jogador, mostra qual carta ele tem e pergunta valor da aposta
        double aposta = 0.0;
        
        for (Jogador jogador : jogadores){
            jogador.imprimirMaoAtual();
            System.out.printf("Digite o valor da aposta do jogaodor %s: ", jogador.getNome());
            aposta = in.nextDouble();
            jogador.apostar(aposta);
        }
    }
    
    public void oferecerCarta(Jogador jogador, Scanner in) {
    	String novaCarta, cartaAberta;

    	// imprime mao atual para que o jogador avalie a situacao
    	jogador.imprimirMaoAtual();
    	
    	System.out.print(jogador.getNome() + ", deseja retirar mais uma carta? (s/n)");
    	novaCarta = in.next();
    	
    	while(novaCarta.equalsIgnoreCase("S")) {
    		System.out.print("Deseja carta aberta? (s/n)");
    		cartaAberta = in.next();
    		banqueiroAtual.distribuirCartas(jogador, this.baralhoSeteEMeio, cartaAberta.equalsIgnoreCase("S"));
    		
    		// imprime novamente como ficou a mao apos o recebimento da carta
    		jogador.imprimirMaoAtual();
	    	
	    	System.out.printf("%s, deseja retirar mais uma carta? (s/n)", jogador.getNome());
	    	novaCarta = in.next();
    	}
    
    	// ao finalizar pedidos de carta, verifica se m�o aberta estourou
    	if (jogador.getMaoAtual().calcularValorDaMaoAberta() > 7.5) {
    		// paga aposta e sai da rodada
    		jogador.pagaAposta(banqueiroAtual, 2);
    	}
    }
    
    public void retirarCartasBanqueiro(Scanner in) {
    	String novaCarta, cartaAberta;

    	// imprime mao atual para que o jogador avalie a situacao
    	banqueiroAtual.imprimirMaoAtual();
    	
    	System.out.print(banqueiroAtual.getNome() + " (BANQUEIRO), deseja retirar mais uma carta? (s/n)");
    	novaCarta = in.next();
    	
    	while(novaCarta.equalsIgnoreCase("S")) {
    		System.out.print("Deseja carta aberta? (s/n)");
    		cartaAberta = in.next();
    		banqueiroAtual.distribuirCartas(banqueiroAtual, this.baralhoSeteEMeio, cartaAberta.equalsIgnoreCase("S"));
    		
    		// imprime novamente como ficou a mao apos o recebimento da carta
    		banqueiroAtual.imprimirMaoAtual();
	    	
	    	System.out.printf("%s, deseja retirar mais uma carta? (s/n)", banqueiroAtual.getNome());
	    	novaCarta = in.next();
    	}
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
	        		
	        		// se jogador tiver a carta coringa e uma carta meio, ser� novo banqueiro
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
        	
        	this.definirBanqueiro(novoBanqueiro);
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
