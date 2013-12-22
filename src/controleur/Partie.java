package controleur;
import java.io.File;

import vue.AffichageConsole;
import vue.Racing;
import modele.Name;
import modele.Terrain;
import modele.Voiture;



public class Partie {
	public static Voiture joueur1;
	public static Terrain t;
	
/*	public static void main(String[] args)
	{
		Partie Mc = new Partie();
		Mc.lancerPartie();		
		
	}*/
	
	
	
	
	
	public void lancerPartie()
	{
	 	t = new Terrain(this,new File(Name.TEST_GRID));
		
				
	}
	
	public void update(int btPressed)
	{
		joueur1.update(joueur1.pilote.update(btPressed));
	}
	
	
	
}
