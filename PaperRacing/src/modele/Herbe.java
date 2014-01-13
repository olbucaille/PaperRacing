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
		
	//	position();
		Couple nouvellePosition = updateInterne(new Couple(Partie.joueur1.vitesse),Partie.joueur1.position,new Couple(Partie.joueur1.vitesse));
		Partie.joueur1.score-=10;
			Partie.joueur1.position.setX( nouvellePosition.getX());
			Partie.joueur1.position.setY(nouvellePosition.getY());

	}

	@Override
	protected Couple changerVitesse(Couple vitesse) {
		if(vitesse.getX()==1) 
			vitesse.setX(vitesse.getX()-1);
		if(vitesse.getX()==-1) 
			vitesse.setX(vitesse.getX()+1);
		if(vitesse.getY()==1) 
			vitesse.setY(vitesse.getY()-1);
		if(vitesse.getY()==-1) 
			vitesse.setY(vitesse.getY()+1);
		
		
		if(vitesse.getX()>=2) 
			vitesse.setX(vitesse.getX()-2);
		if(vitesse.getX()<=-2) 
			vitesse.setX(vitesse.getX()+2);
		if(vitesse.getY()>=2) 
			vitesse.setY(vitesse.getY()-2);
		if(vitesse.getY()<=-2) 
			vitesse.setY(vitesse.getY()+2);
	//	vitesse.setToZero();
		return vitesse;
	}

	@Override
	public boolean isArrival() {
		
		return false;
	}

	

}
