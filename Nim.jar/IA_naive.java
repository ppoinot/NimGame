import java.util.*;
import java.util.Random;
/**
 * Inteligence artificielle aleatoire contre joueur
 * @author N'GONDO Cédric
 **/
class IA_naive
{
    String  name;
    int     nbWin;
    LCM play;
  


    /**
     * Contructeur IA_naive
     * @init le nom et le nombre de partie gagnée
     * @param (tab) int[] correspondant au d'allumette
     */
    public IA_naive(int[] tab)
    {
    	this.name = "Bot";
    	this.nbWin = 0;
	this.play = new LCM(null);
	
        
    }

    /**
     * Accesseur de l'attribut name
     * @return le nom de de l'IA
     */
    public String getName()
    {
	   return this.name;
    }

    /**
     * Accesseur de l'attribut nbWin
     * @return le nombre de parties gangné de l'objet instancié
     */
    public int getNbWin()
    {
	   return this.nbWin++;
    }
    
    

    /**
     * Mutateur de l'attribut name
     * @param n correspond au nom à afficher
     */
    public void setName(String n)
    {
	   this.name = n;
    }

    /**
     * Mutateur de l'attribut nbWin
     * @param n correspond au nombre de partie gagnée à afficher
     */
    public void setNbWin()
    {
	   this.nbWin++;
    }

    /**
     * Méthode qui renvoie un Move en fonction des class (LCM) et (MaillonM)
     * @param (tab) int[] qui correspond au tableau d'allumette
     * @return Move - coups de l'IA en fonction du nombre d'allumette du tableau
     **/
    public Move iaPlays(int[] tab)
    {
	this.play = new LCM(null);
	Move m = new Move();
	int a;
	int i;
	
	a = 0;
	this.play.ajoutPlays(tab);
	this.play.showPlays();
	i = this.play.nbElemList();
	a = (int) (Math.random() * (i - 1) + 1);
       	m = this.play.choice(a);
	    
	return new Move(m.getLine()  , m.getMatchNb() );
    }
    
}
