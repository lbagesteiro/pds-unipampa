/**
 *  Copyright (c) 2012 Luiza Bagesteiro e Ricardo Pasqualotti
 * 
 *  Este arquivo é parte do programa AplicacaoCartas
 * 
 *  AplicacaoCartas é um software livre; você pode redistribui-lo e/ou modifica-lo dentro dos termos da Licença Pública Geral Menor GNU 
 *  como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença, ou (na sua opnião) qualquer versão.
 * 
 *  Este programa é distribuido na esperança que possa ser  util, mas SEM NENHUMA GARANTIA; sem uma garantia implicita de ADEQUAÇÂO a qualquer
 *  MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral Menor GNU para maiores detalhes.
 *  
 *  Você deve ter recebido uma cópia da Licença Pública Geral Menor GNU junto com este programa, se não, escreva para a Fundação do Software
 *  Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 */

package AplicacaoCartas;
import java.util.Scanner;
import AplicacaoCartas.Baralho;

/**
 *Classe que representa a manipulação das cartas pelo jogador
 *Funções possíveis: mostrar baralho, embaralhar, cortar em duas partes, retirar uma carta do inicio ou do final,
 *passar uma carta do inicio para o final, adicionar carta ao monte de descarte.
 *@author Luiza Bagesteiro
 *@author Ricardo Pasqualotti
 */
public class Main {
   
	static Baralho baralho = new Baralho();
    static Cartas card;
    static Baralho desc;
    static int option = 100;
    static int localdocorte = 0;
    
    /**
     * Método de escolha das funções pelo jogador
     */
    public static void ManipulaCartas(){  
    	
    	Scanner is = new Scanner(System.in);
    	
        System.out.println("\n\n" + "Digite o que você quer fazer: ");
        System.out.println("1 - Mostrar baralho");
        System.out.println("2 - Embaralhar");
        System.out.println("3 - Cortar o baralho no local que você define");
        System.out.println("4 - Mover uma carta do início para o final do baralho, sem mostrar a carta");
        System.out.println("5 - Retirar a primeira carta do baralho");
        System.out.println("6 - Retirar a última carta do baralho");
        System.out.println("7 - Descartar do baralho uma carta que você define");
        System.out.println("8 - Mostrar as cartas descartadas" + "\n\n");
        
        option = is.nextInt();
    
        if (option==1){
        	baralho.imprimeBaralho();
        	ManipulaCartas();   
        }

        else if (option==2){
        	baralho.embaralhaBaralho(); 
        	ManipulaCartas();   
        }
    
        else if (option==3){    
        	System.out.println("Posição do corte: ");
        	localdocorte = is.nextInt();
        	baralho.cortaEmDois(localdocorte); 
        	ManipulaCartas();   
        }
   
        else if (option==4){
        	baralho.moveCartaParaOFim();
        	ManipulaCartas();   
        }
    
        else if (option==5){
        	card = baralho.retiraCartaInicio();
            System.out.println("Você retirou a carta: " + card.imprimecarta());
        	ManipulaCartas();   
        }
       
        else if(option==6){
        	card = baralho.retiraCartaFim();
        	System.out.println("Você retirou a carta: " + card.imprimecarta());
        	ManipulaCartas();   
        }
    
        else if(option==7){      
        	System.out.println("Descartando carta...");
        	System.out.println("Digite o número da carta: ");
            int numero = is.nextInt();
        	System.out.println("Digite o número correspondente ao naipe: (1 = Copas; 2 = Espadas; 3 = Ouros; 4 = Paus) ");
        	int n = is.nextInt();
        	
        	if (n==1){
        		baralho.Descarta(numero, "Copas");
        	}
        	else if (n==2){
        		baralho.Descarta(numero, "Espadas");
        	}        	
        	else if (n==3){
        		baralho.Descarta(numero, "Ouros");
        	}        	
        	else if (n==4){
        		baralho.Descarta(numero, "Paus");
        	}
        	else{
        		System.err.println("Erro: você digitou um naipe inválido!");
            	ManipulaCartas();
        	}        	
            
        	ManipulaCartas();
        }
        
        else if(option==8){
        	baralho.verCartasDescartadas();
        	ManipulaCartas();   
        }
    
        else{
        	System.err.println("Erro: você digitou um número inválido!");
        	ManipulaCartas();   
        }	 
   
    }
    
    
    /**
     * chama o método para manipular as cartas
     */
    public static void main(String[] args) {
    	ManipulaCartas();        
    }
    
}