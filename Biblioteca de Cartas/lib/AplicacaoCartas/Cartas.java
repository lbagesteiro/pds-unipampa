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

/**
 *Classe que representa uma carta do jogo: numero + naipe
 *@author Luiza Bagesteiro
 *@author Ricardo Pasqualotti
 */

public class Cartas {

    private int numCarta;
    private String naipeCarta;

    /**
     * Define os atributos da carta simultaneamente: n�mero e naipe
     * @param numero - inteiro referente ao numero da carta
     * @param naipe - string referente ao naipe da carta
     */    
    public Cartas(int numero, String naipe) {
    	this.numCarta = numero;
    	this.naipeCarta = naipe;
    }
    
    /**
     * Obt�m o n�mero de uma carta
     * @return - inteiro referente ao n�mero da carta
     */
    public int getNumCarta() {
        return numCarta;
    }

    /**
     * Obt�m o naipe de uma carta
     * @return - string referente ao naipe da carta
     */
    public String getNaipeCarta() {
        return naipeCarta;
    }

    /**
     * Determina o n�mero de uma carta
     * @param numeroCarta - inteiro referente ao n�mero da carta
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
     * M�todo que retorna uma string referente ao n�mero e naipe da carta
     * @return
     */
    public String imprimecarta() {
        return this.getNumCarta() + " de " + this.getNaipeCarta();
    }
  
}