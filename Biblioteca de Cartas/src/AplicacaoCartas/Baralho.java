/**
 * Copyright (c) 2012 Luiza Bagesteiro e Ricardo Pasqualotti
 * 
 * Este arquivo é parte do programa AplicacaoCartas
 * 
 * AplicacaoCartas é um software livre; você pode redistribui-lo e/ou modifica-lo dentro dos termos da Licença Pública Geral Menor GNU 
 * como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença, ou (na sua opnião) qualquer versão.
 * 
 *  Este programa é distribuido na esperança que possa ser  util, mas SEM NENHUMA GARANTIA; sem uma garantia implicita de ADEQUAÇÂO a qualquer
 *  MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral Menor GNU para maiores detalhes.
 *  
 *  Você deve ter recebido uma cópia da Licença Pública Geral Menor GNU junto com este programa, se não, escreva para a Fundação do Software
 *  Livre(FSF) Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 */

package AplicacaoCartas;

import java.util.ArrayList;
import java.util.Collections;
import AplicacaoCartas.Cartas;

/**
 * Classe que implementa funcionalidades como:
 * embaralhar, cortar em duas partes, retirar uma carta do inicio ou do final,
 * passar uma carta do inicio para o final, além da criação do monte de descarte.
 * @author Luiza Bagesteiro
 * @author Ricardo Pasqualotti
 */
public class Baralho {
	
		public ArrayList<Cartas> baralho = new ArrayList<Cartas>(52);
		public ArrayList<Cartas> descartadas = new ArrayList<Cartas>();
		
		/**
		 * Método construtor da classe Baralho,onde o baralho é instanciado e preenchido
		 */
		public Baralho(){
			
			baralho = new ArrayList<Cartas>(52);

			for(int i=0; i<52; i++){				
				if (i<13){
					baralho.add(new Cartas(i+1, "Copas"));
				}
				else if (i>=13 && i<26){
					baralho.add(new Cartas(i-12, "Espadas"));
				}
				else if (i>=26 && i<39){
					baralho.add(new Cartas(i-25, "Ouros"));
				}
				else if (i>=39 && i<52){
					baralho.add(new Cartas(i-38, "Paus"));
				}				
			}
		}	
		
		
		/**
		 * Método que imprime todas as 52 cartas do baralho
		 */
		public void imprimeBaralho() {
			for (int count=0; count<baralho.size(); count++){
				System.out.println(baralho.get(count).imprimecarta());
	        }
	    }
		
		
		/**
	     * Método que embaralha o baralho
	     */
	    public void embaralhaBaralho(){
	        Collections.shuffle(baralho);
	        System.out.println("Embaralhado com sucesso.");
	   }
	    
	    
	    /**
	     * Método que corta o baralho na posição definida pelo usuário,
	     * onde a parte de cima do baralho passa a ser a parte de baixo, e vice-versa
	     * @param posicao
	     */
		public void cortaEmDois(int posicao) {
	        if(baralho.size()<posicao){
	            System.err.println("Você digitou um número maior que o número de cartas existente");
	        }
	        else{
	            ArrayList<Cartas> temporario = new ArrayList<Cartas>();	        
	            for(int i=posicao; i<baralho.size(); i++)
	                temporario.add(baralho.get(i));
	            for(int i=0; i<posicao; i++)
	                temporario.add(baralho.get(i));	        
	            Collections.copy(baralho, temporario);
	            System.out.println("Baralho cortado com sucesso.");
	        }
	    }		
		
		
		/**
		 * Método que move a primera carta do baralho para o fim do baralho
		 */
		public void moveCartaParaOFim(){
				baralho.add(baralho.remove(0));
				System.out.println("A carta foi movida para o fim.");
		}
		
		
		/**
		 * Método que retira a primeira carta do baralho
		 * @return
		 */
		 public Cartas retiraCartaInicio(){
		        return this.baralho.get(0);
		    }
		 
		 
		 /**
		  * Método que retira a última carta do baralho
		  * @return
		  */
		  public Cartas retiraCartaFim(){
		        return this.baralho.get(baralho.size()-1);
		    }		  
		  
		  
		  /**
		   * Método que descarta uma carta do baralho
		   * @param naipe - String
		   * @param numero - inteiro
		   */
		  public void Descarta(int numero, String naipe){
		    	for (int i=0; i<baralho.size(); i++){
		    		if (baralho.get(i).getNumCarta()==numero && baralho.get(i).getNaipeCarta()==naipe) {
		    			descartadas.add(baralho.get(i));
		    			System.out.println("Descartada a carta " + baralho.get(i).imprimecarta());
		    			baralho.remove(i);		    		
		    		}
		    	}		        
		  }

  
		  /**
		   * Método para visualizar todas as cartas que estão no monte de descarte
		   */
		  public void verCartasDescartadas() {
			  for(int i=0; i<descartadas.size(); i++)
				  System.out.println("Carta: " + descartadas.get(i).imprimecarta());
		  }
		
	    
}