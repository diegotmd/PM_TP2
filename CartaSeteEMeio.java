package br.ufmg.dcc.pm.seteemeio;

/**
 *
 * @author ddayrell
 */
public class CartaSeteEMeio implements CartaBaralho {

    private String nome;
    private Naipe naipe;
    private double valor;
    private boolean valorAberto;
    
    public CartaSeteEMeio(String nome, Naipe naipe, double valor, boolean valorAberto){
        this.nome = nome;
        this.naipe = naipe;
        this.valor = valor;
        this.valorAberto = valorAberto;
    }
    
    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public Naipe getNaipe() {
        return this.naipe;
    }

    @Override
    public double getValor() {
        return this.valor;
    }

    @Override
    public boolean valorEhAberto() {
        return this.valorAberto;
    }
    
    @Override
    public boolean ehCartaCoringa() {
    	return (valor == 7 && naipe == Naipe.Ouros);
    }
    
    private void setValorAbertoFechado(boolean idcValorAberto){
        this.valorAberto = idcValorAberto;
    }

    @Override
    public void abrirCarta() {
        setValorAbertoFechado(true);
    }

    @Override
    public void fecharCarta() {
        setValorAbertoFechado(false);
    }
}
