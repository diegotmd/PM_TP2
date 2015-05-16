package br.ufmg.dcc.pm.seteemeio;

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
    
    // efetua uma aposta e reduz saldo
    public void apostar(double valor){
        if (saldoDisponivel >= valor) {
            valorApostaAtual = valor;
            saldoDisponivel-=valor;
        } else {
            // lanca exception
        }
        
    }
    
    // adiciona uma nova carta à mão atual
    public void adicionarCartaAMao(CartaBaralho novaCarta){
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
}
