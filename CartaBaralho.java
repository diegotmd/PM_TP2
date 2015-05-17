package br.ufmg.dcc.pm.seteemeio;

/**
 *
 * @author ddayrell
 */
public interface CartaBaralho {
    public String getNome();
    public Naipe getNaipe();
    public double getValor();
    public boolean valorEhAberto();
    public boolean ehCartaCoringa();
    public void abrirCarta();
}
