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

/**
 *Classe que representa uma carta do jogo: numero + naipe
 *@author Luiza Bagesteiro
 *@author Ricardo Pasqualotti
 */

public class Cartas {

    private int numCarta;
    private String naipeCarta;

    /**
     * Define os atributos da carta simultaneamente: numero e naipe
     * @param numero - inteiro referente ao numero da carta
     * @param naipe - string referente ao naipe da carta
     */    
    public Cartas(int numero, String naipe) {
    	this.numCarta = numero;
    	this.naipeCarta = naipe;
    }
    
    /**
     * Obtem o numero de uma carta
     * @return - inteiro referente ao numero da carta
     */
    public int getNumCarta() {
        return numCarta;
    }

    /**
     * Obtem o naipe de uma carta
     * @return - string referente ao naipe da carta
     */
    public String getNaipeCarta() {
        return naipeCarta;
    }

    /**
     * Determina o numero de uma carta
     * @param numeroCarta - inteiro referente ao numero da carta
     */
    public void setNumCarta(int numeroCarta) {
        this.numCarta = numeroCarta;
    }

    /**
     * Determina o naipe de uma carta
     * @param naipes - string referente ao naipe da carta
     */
    
    public void setNaipeCarta(String naipes) {
        this.naipeCarta = naipes;
    }
    
    /**
     * Metodo que retorna uma string referente ao numero e naipe da carta
     * @return
     */
    public String imprimecarta() {
        return this.getNumCarta() + " de " + this.getNaipeCarta();
    }
  
}
