/**
 * Copyright (c) 2012 Luiza Bagesteiro e Ricardo Pasqualotti
 * 
 * Este arquivo e parte do programa AplicacaoCartas
 * 
 * AplicacaoCartas e um software livre; voce pode redistribui-lo e/ou modifica-lo dentro dos termos da Licenca Publica Geral Menor GNU 
 * como publicada pela Fundacao do Software Livre (FSF); na versao 2 da Licenca, ou (na sua opiniao) qualquer versao.
 * 
 *  Este programa e distribuido na esperanca que possa ser util, mas SEM NENHUMA GARANTIA; sem uma garantia implicita de ADEQUACAO a qualquer
 *  MERCADO ou APLICACAO EM PARTICULAR. Veja a Licenca Publica Geral Menor GNU para maiores detalhes.
 *  
 *  Voce deve ter recebido uma copia da Licenca Publica Geral Menor GNU junto com este programa, se nao, escreva para a Fundacao do Software
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
 * passar uma carta do inicio para o final, alem da criacao do monte de descarte.
 * @author Luiza Bagesteiro
 * @author Ricardo Pasqualotti
 */
public class Baralho {
	
		public ArrayList<Cartas> baralho = new ArrayList<Cartas>(52);
		public ArrayList<Cartas> descartadas = new ArrayList<Cartas>();
		
		/**
		 * Metodo construtor da classe Baralho,onde o baralho e instanciado e preenchido
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
		 * Metodo que imprime todas as 52 cartas do baralho
		 */
		public void imprimeBaralho() {
			for (int count=0; count<baralho.size(); count++){
				System.out.println(baralho.get(count).imprimecarta());
	        }
	    }
		
		
		/**
	     * Metodo que embaralha o baralho
	     */
	    public void embaralhaBaralho(){
	        Collections.shuffle(baralho);
	        System.out.println("Embaralhado com sucesso.");
	   }
	    
	    
	    /**
	     * Metodo que corta o baralho na posicao definida pelo usuario,
	     * onde a parte de cima do baralho passa a ser a parte de baixo, e vice-versa
	     * @param posicao
	     */
		public void cortaEmDois(int posicao) {
	        if(baralho.size()<posicao){
	            System.err.println("Voce digitou um numero maior que o numero de cartas existente");
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
		 * Metodo que move a primera carta do baralho para o fim do baralho
		 */
		public void moveCartaParaOFim(){
				baralho.add(baralho.remove(0));
				System.out.println("A carta foi movida para o fim.");
		}
		
		
		/**
		 * Metodo que retira a primeira carta do baralho
		 * @return
		 */
		 public Cartas retiraCartaInicio(){
		        return this.baralho.get(0);
		    }
		 
		 
		 /**
		  * Metodo que retira a ultima carta do baralho
		  * @return
		  */
		  public Cartas retiraCartaFim(){
		        return this.baralho.get(baralho.size()-1);
		    }		  
		  
		  
		  /**
		   * Metodo que descarta uma carta do baralho
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
		   * Metodo para visualizar todas as cartas que estao no monte de descarte
		   */
		  public void verCartasDescartadas() {
			  for(int i=0; i<descartadas.size(); i++)
				  System.out.println("Carta: " + descartadas.get(i).imprimecarta());
		  }
		
	    
}
