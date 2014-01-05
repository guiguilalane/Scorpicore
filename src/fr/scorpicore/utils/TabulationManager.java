/**
 * 
 */
package fr.scorpicore.utils;

/**
 * @author Guillaume
 * 
 */
public class TabulationManager {

    private int nbTab;

    /**
     * 
     */
    public TabulationManager() {
	nbTab = 0;
    }

    /**
     * 
     * @param nbTab
     *            le nombre de tabulation
     */
    public TabulationManager(int nbTab) {
	this.nbTab = nbTab;
    }

    /**
     * Ajoute une tabulation
     */
    public void plusPlus() {
	this.nbTab++;
    }

    /**
     * Supprime une tabulation si le nombre de tabulation est positif
     */
    public void moinMoins() {
	if (this.nbTab > 0) {
	    this.nbTab--;
	}
    }

    /**
     * Ajoute addTab tabulation.
     * 
     * @param addTab
     *            le nombre de tabulation à ajouter
     */
    public void plus(int addTab) {
	this.nbTab += addTab;
    }

    /**
     * Supprime removeTab tabulation. Le nombre de tablation sera au pire égale
     * à 0.
     * 
     * @param removeTab
     *            le nombre de tabulation à retirer
     */
    public void moins(int removeTab) {
	this.nbTab -= removeTab;
	if (this.nbTab < 0) {
	    this.nbTab = 0;
	}
    }

    /**
     * Retourne la chaine de caractères contenant le nombre de tabulation.
     * 
     * @return la chaine de caractères contenant le nombre de tabulation.
     */
    public String toString() {
	String s = "";
	for (int i = 0; i < this.nbTab; ++i) {
	    s += "\t";
	}
	return s;
    }
}
