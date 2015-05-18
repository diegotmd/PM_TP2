package br.ufmg.dcc.pm.tp2;
import br.ufmg.dcc.pm.seteemeio.Banqueiro;
import br.ufmg.dcc.pm.seteemeio.Jogador;
import br.ufmg.dcc.pm.seteemeio.JogoDeBaralho;
import br.ufmg.dcc.pm.seteemeio.JogoDeBaralhoFactory;
import br.ufmg.dcc.pm.seteemeio.JogoSeteEMeioFactory;

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


        JogoDeBaralho jogo;
        JogoDeBaralhoFactory fabricaJogo;
		
        int tipoJogo;

        Scanner in = new Scanner(System.in); 
        
        System.out.printf("Lista de jogos de baralho:\n");
        System.out.printf("1 - Sete e Meio\n");
        System.out.printf("2 - Truco (nao implementado)\n");
        System.out.printf("3 - Poker (nao implementado)\n");
        
        System.out.printf("Digite o numero do tipo de jogo: ");
        tipoJogo = in.nextInt();
        
        if (tipoJogo == 1){
        	System.out.println("\nCriando jogo de Sete e Meio...\n");
        	fabricaJogo = new JogoSeteEMeioFactory();
        } else {
        	System.out.println("Tipo de jogo ainda nao implementado.");
            fabricaJogo = new JogoSeteEMeioFactory();
        } 

        // cria jogo e inicializa
        jogo = fabricaJogo.criarJogo(in);
        jogo.inicializarJogo(in);
        jogo.jogar(in);
        
        in.close();
    }
    
}
