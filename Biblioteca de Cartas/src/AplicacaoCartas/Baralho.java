/**
 * Copyright (c) 2012 Luiza Bagesteiro e Ricardo Pasqualotti
 * 
 * Este arquivo � parte do programa AplicacaoCartas
 * 
 * AplicacaoCartas � um software livre; voc� pode redistribui-lo e/ou modifica-lo dentro dos termos da Licen�a P�blica Geral Menor GNU 
 * como publicada pela Funda��o do Software Livre (FSF); na vers�o 2 da Licen�a, ou (na sua opni�o) qualquer vers�o.
 * 
 *  Este programa � distribuido na esperan�a que possa ser  util, mas SEM NENHUMA GARANTIA; sem uma garantia implicita de ADEQUA��O a qualquer
 *  MERCADO ou APLICA��O EM PARTICULAR. Veja a Licen�a P�blica Geral Menor GNU para maiores detalhes.
 *  
 *  Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral Menor GNU junto com este programa, se n�o, escreva para a Funda��o do Software
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
 * passar uma carta do inicio para o final, al�m da cria��o do monte de descarte.
 * @author Luiza Bagesteiro
 * @author Ricardo Pasqualotti
 */
public class Baralho {
	
		public ArrayList<Cartas> baralho = new ArrayList<Cartas>(52);
		public ArrayList<Cartas> descartadas = new ArrayList<Cartas>();
		
		/**
		 * M�todo construtor da classe Baralho,onde o baralho � instanciado e preenchido
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
		 * M�todo que imprime todas as 52 cartas do baralho
		 */
		public void imprimeBaralho() {
			for (int count=0; count<baralho.size(); count++){
				System.out.println(baralho.get(count).imprimecarta());
	        }
	    }
		
		
		/**
	     * M�todo que embaralha o baralho
	     */
	    public void embaralhaBaralho(){
	        Collections.shuffle(baralho);
	        System.out.println("Embaralhado com sucesso.");
	   }
	    
	    
	    /**
	     * M�todo que corta o baralho na posi��o definida pelo usu�rio,
	     * onde a parte de cima do baralho passa a ser a parte de baixo, e vice-versa
	     * @param posicao
	     */
		public void cortaEmDois(int posicao) {
	        if(baralho.size()<posicao){
	            System.err.println("Voc� digitou um n�mero maior que o n�mero de cartas existente");
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
		 * M�todo que move a primera carta do baralho para o fim do baralho
		 */
		public void moveCartaParaOFim(){
				baralho.add(baralho.remove(0));
				System.out.println("A carta foi movida para o fim.");
		}
		
		
		/**
		 * M�todo que retira a primeira carta do baralho
		 * @return
		 */
		 public Cartas retiraCartaInicio(){
		        return this.baralho.get(0);
		    }
		 
		 
		 /**
		  * M�todo que retira a �ltima carta do baralho
		  * @return
		  */
		  public Cartas retiraCartaFim(){
		        return this.baralho.get(baralho.size()-1);
		    }		  
		  
		  
		  /**
		   * M�todo que descarta uma carta do baralho
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
		   * M�todo para visualizar todas as cartas que est�o no monte de descarte
		   */
		  public void verCartasDescartadas() {
			  for(int i=0; i<descartadas.size(); i++)
				  System.out.println("Carta: " + descartadas.get(i).imprimecarta());
		  }
		
	    
}