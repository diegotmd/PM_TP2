package br.ufmg.dcc.pm.seteemeio;

import seteemeio.Banqueiro;
import seteemeio.JogoSeteEMeio;
import seteemeio.Mao;

/**
 *
 * @author ddayrell
 */
public class Jogador {
    private String nome;
    private double saldoDisponivel;
    private JogoSeteEMeio jogoAtual;
    private Mao maoAtual;
    private double valorApostaAtual;
    
    public Jogador(String nome, double saldoInicial, JogoSeteEMeio jogo){
        this.nome = nome;
        this.saldoDisponivel = saldoInicial;
        this.maoAtual = new Mao(this);
        this.jogoAtual = jogo;
        this.valorApostaAtual = 0;
    }
    
    public boolean possuiCartasNaMao(){
        return (maoAtual != null && maoAtual.colecaoDeCartas().size() > 0);
    }
    
    // efetua uma aposta
    public void apostar(double valor){
    	// saldo do jogador deve ser suficiente para pagar o dobro, caso estoure
        if (valor <= jogoAtual.getApostaMaxima() &&
            valor >= jogoAtual.getApostaMinima() &&
            saldoDisponivel >= valor * 2) {
            valorApostaAtual = valor;
        } else {
            // lanca exception
        }
    }
    
    // paga aposta
    public void pagaAposta(Banqueiro banqueiro, int fator) {
    	if (saldoDisponivel >= valorApostaAtual * fator) {
            saldoDisponivel -= valorApostaAtual * fator;
            banqueiro.recebeAposta(valorApostaAtual * fator);
        } else {
            // lanca exception
        }
    }
    
    // recebe aposta (bonificacao)
    public void recebeAposta(double valor) {
    	saldoDisponivel += valor;
    }
    
    // adiciona uma nova carta a mao atual
    public void adicionarCartaAMao(CartaBaralho novaCarta) {
        this.maoAtual.adicionarCarta(novaCarta);
    }
    
    // devolve as cartas da mao para que sejam colocadas de volta no baralho 
    public ColecaoCartasBaralho devolerCartaDaMao(){
        Mao maoRetornada = new Mao(this);
        while (possuiCartasNaMao()){
            maoRetornada.adicionarCarta(maoAtual.retirarProximaCarta());
        }        
        return maoRetornada;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public double getSaldoDisponivel(){
        return this.saldoDisponivel;
    }
    
    public double getValorApostaAtual() {
    	return this.valorApostaAtual;
    }
    
    public Mao getMaoAtual() {
    	return this.maoAtual;
    }
    
    public JogoSeteEMeio getJogoAtual() {
    	return this.jogoAtual;
    }
    
    public void setSaldoDisponivel(double novoSaldoDisponivel) {
    	this.saldoDisponivel = novoSaldoDisponivel;
    }
}
