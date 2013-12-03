package controleur;
import java.io.File;

import vue.AffichageConsole;

import modele.Terrain;
import modele.Voiture;



public class Partie {
	public static Voiture joueur1;
	public static Terrain t;
	
	public static void main(String[] args)
	{
		Partie Mc = new Partie();
		Mc.LancerPartie();
		
		
		
	}
	
	public void LancerPartie()
	{
	 	t = new Terrain(this,new File("./grid/grid2.txt"));
		
		while(true)
		{
				AffichageConsole.afficherTerrain();
				joueur1.Update();
				
		
		}
	}
	
	
	
}
