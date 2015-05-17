package br.ufmg.dcc.pm.tp2;
import br.ufmg.dcc.pm.seteemeio.Banqueiro;
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
        char jogadorEhBanqueiro = 'N';
        Scanner in = new Scanner(System.in); 
        
        System.out.printf("Digite a quantidade de jogadores, de 2 a 10: ");
        qteJogadores = in.nextInt();
        System.out.printf("Digite o valor da aposta minima: ");
        apostaMinima = in.nextDouble();
        System.out.printf("Digite o valor da aposta maxima: ");
        apostaMinima = in.nextDouble();
        jogoSeteEmeio = new JogoSeteEMeio(apostaMaxima, apostaMinima);
       
        // adicionar jogadores
        for (int i=0; i<qteJogadores; i++) {
            System.out.printf("Digite o nome do jogador " + i + ": ");
            nomeJogador=in.nextLine();
            System.out.printf("Digite o saldo inicial do jogador " + i + ": ");
            saldoInicial=in.nextDouble();
            
            // define se o jogador eh o banqueiro
            if (jogadorEhBanqueiro == 'N'){
                System.out.printf("Esse jogador e o banqueiro? (S/N): ");
                in.next().charAt(0);
            }
            
            // adiciona jogador/banqueiro ao jogo
            if (jogadorEhBanqueiro == 'S'){
                jogoSeteEmeio.definirBanqueiro(new Jogador(nomeJogador, saldoInicial, jogoSeteEmeio));
            } else {
                jogoSeteEmeio.adicionarJogador(new Jogador(nomeJogador, saldoInicial, jogoSeteEmeio));
            }
            
            jogoSeteEmeio.inicializar();
       }
       
    }
    
}
