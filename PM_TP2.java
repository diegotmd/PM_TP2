package br.ufmg.dcc.pm.seteemeio;

import br.ufmg.dcc.pm.seteemeio.Jogador;
import br.ufmg.dcc.pm.seteemeio.JogoSeteEMeio;
import java.util.Scanner;

/**
 *
 * @author ddayrell
 */
public class PM_TP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int qteJogadores = 0;
        double apostaMinima = 0, apostaMaxima = 0, saldoInicial = 0;
        String nomeJogador;
        JogoSeteEMeio jogoSeteEmeio;
        Scanner in = new Scanner(System.in); 
        
        System.out.printf("Digite a quantidade de jogadores, de 2 a 10: ");
        qteJogadores = in.nextInt();
        System.out.printf("Digite o valor da aposta minima: ");
        apostaMinima = in.nextDouble();
        System.out.printf("Digite o valor da aposta maxima: ");
        apostaMaxima = in.nextDouble();
        jogoSeteEmeio = new JogoSeteEMeio(apostaMaxima, apostaMinima);
        
        // saldo inicial dos jogadores será aposta máxima * quantidade de jogadores
        saldoInicial = apostaMaxima * qteJogadores;
        
        System.out.printf("\nDigite o nome do banqueiro: ");
        nomeJogador = in.next();
        // define banqueiro
        jogoSeteEmeio.definirBanqueiro(new Jogador(nomeJogador, saldoInicial, jogoSeteEmeio));
       
        // adicionar jogadores
        for (int i = 1; i < qteJogadores; i++) {
            System.out.printf("Digite o nome do jogador " + i + ": ");
            nomeJogador = in.next();
            
            // adiciona jogador
            jogoSeteEmeio.adicionarJogador(new Jogador(nomeJogador, saldoInicial, jogoSeteEmeio));
        }

        // inicializa jogo
        jogoSeteEmeio.inicializar();
        
        //
        
        in.close();       
    }
    
}
