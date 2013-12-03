package modele;

import controleur.Couple;
import controleur.Partie;

public abstract class Element {

	String nom = "?";





	public abstract void update( Couple Acceleration);

	@Override
	public String toString() {
		return "" + nom ;
	}


	protected static void position()
	{
		//debug
		System.out.println(Partie.joueur1.position.getX());
		System.out.println(Partie.joueur1.position.getY());
		
		//la condition est moche mais on verrifie que l'on ne sort pas du terrain, si oui, vitesse à 0
		if((Partie.joueur1.position.getX()+Partie.joueur1.Vitesse.getX())>=0 && (Partie.joueur1.position.getX()+Partie.joueur1.Vitesse.getX())<= Terrain.HAUTEUR_TERRAIN-1)
			if((Partie.joueur1.position.getY()+Partie.joueur1.Vitesse.getY())>=0 && (Partie.joueur1.position.getY()+Partie.joueur1.Vitesse.getY())<= Terrain.LARGEUR_TERRAIN-1)
			{
				Partie.joueur1.position.setX( Partie.joueur1.position.getX()+Partie.joueur1.Vitesse.getX());
				Partie.joueur1.position.setY( Partie.joueur1.position.getY()+Partie.joueur1.Vitesse.getY());
			}
			else
			{
				System.out.println("crash");
				Partie.joueur1.Vitesse.setX(0);
				Partie.joueur1.Vitesse.setY(0);
			}
		else
		{
			System.out.println("crash");
			Partie.joueur1.Vitesse.setX(0);
			Partie.joueur1.Vitesse.setY(0);
		}

	}



}
