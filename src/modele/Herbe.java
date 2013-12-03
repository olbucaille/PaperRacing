package modele;

import controleur.Couple;
import controleur.Partie;

public class Herbe extends Element {
	 
	
	
	public Herbe()
	{
		nom = ".";
		
	}
	
	public void update( Couple Acceleration) {
		//si on a une vitesse inferieur ou egale à 1 on permet d'avancer quand meme
		if(Math.abs(Partie.joueur1.Vitesse.getX())<=1)
			Partie.joueur1.Vitesse.setX( Partie.joueur1.Vitesse.getX()+Acceleration.getX());
		else
			//sinon si on est censé avancer dans cette direction...
			if (Partie.joueur1.Vitesse.getX()!=0)
				//dans un sens..
				if(Partie.joueur1.Vitesse.getX()>0 )
					//on ralenti en mettant un coeff inverse
					Partie.joueur1.Vitesse.setX(Partie.joueur1.Vitesse.getX()-1+Acceleration.getX());
					//si dans l'autre sens, autre coeff
				else
					Partie.joueur1.Vitesse.setX(Partie.joueur1.Vitesse.getX()+1+Acceleration.getX());
			
		//meme chose
		if(Math.abs(Partie.joueur1.Vitesse.getY())<=1)
			Partie.joueur1.Vitesse.setY( Partie.joueur1.Vitesse.getY()+Acceleration.getY());
		else		
			if (Partie.joueur1.Vitesse.getY()!=0)
				if(Partie.joueur1.Vitesse.getY()>0)
					Partie.joueur1.Vitesse.setY(Partie.joueur1.Vitesse.getY()-1+Acceleration.getY());
				else
					Partie.joueur1.Vitesse.setY(Partie.joueur1.Vitesse.getY()+1+Acceleration.getY());
		
		position();
		 
		
	}

	

}
