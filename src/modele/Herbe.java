package modele;

import controleur.Couple;
import controleur.Partie;

public class Herbe extends Element {
	 
	
	
	public Herbe()
	{
		nom = ".";
		
	}
	
	public void update( Couple Acceleration) {
		//si on a une vitesse inferieur ou egale � 1 on permet d'avancer quand meme
		if(Math.abs(Partie.joueur1.vitesse.getX())<=1)
			Partie.joueur1.vitesse.setX( Partie.joueur1.vitesse.getX()+Acceleration.getX());
		else
			//sinon si on est cens� avancer dans cette direction...
			if (Partie.joueur1.vitesse.getX()!=0)
				//dans un sens..
				if(Partie.joueur1.vitesse.getX()>0 )
					//on ralenti en mettant un coeff inverse
					Partie.joueur1.vitesse.setX(Partie.joueur1.vitesse.getX()-1+Acceleration.getX());
					//si dans l'autre sens, autre coeff
				else
					Partie.joueur1.vitesse.setX(Partie.joueur1.vitesse.getX()+1+Acceleration.getX());
			
		//meme chose
		if(Math.abs(Partie.joueur1.vitesse.getY())<=1)
			Partie.joueur1.vitesse.setY( Partie.joueur1.vitesse.getY()+Acceleration.getY());
		else		
			if (Partie.joueur1.vitesse.getY()!=0)
				if(Partie.joueur1.vitesse.getY()>0)
					Partie.joueur1.vitesse.setY(Partie.joueur1.vitesse.getY()-1+Acceleration.getY());
				else
					Partie.joueur1.vitesse.setY(Partie.joueur1.vitesse.getY()+1+Acceleration.getY());
		
		position();
		 
		
	}

	@Override
	protected Couple changerVitesse(Couple Vitesse) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
