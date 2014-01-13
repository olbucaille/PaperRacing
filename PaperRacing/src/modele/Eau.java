package modele;

import controleur.Couple;
import controleur.Partie;

public class Eau extends Element {
	
	public Eau()
	{
		nom = "o";		
	}

	@Override
	public void update( Couple Acceleration) {
		
		//ici, on ne met pas a jour la vitesse car l'acceleration n'est pas prise en compte
		//sauf si la vitesse est nulle
		if(Partie.joueur1.vitesse.getX()==0&&Partie.joueur1.vitesse.getY()==0){
			Partie.joueur1.vitesse.setX(Partie.joueur1.vitesse.getX()+Acceleration.getX());
			Partie.joueur1.vitesse.setY(Partie.joueur1.vitesse.getX()+Acceleration.getY());
		}
		Couple nouvellePosition= updateInterne(new Couple(Partie.joueur1.vitesse),Partie.joueur1.position,new Couple(Partie.joueur1.vitesse));		
		
		//on met a jour le score et la position		
		Partie.joueur1.score-=20;
	
		Partie.joueur1.position.setX( nouvellePosition.getX());
		Partie.joueur1.position.setY(nouvellePosition.getY());

			
	}

	@Override
	protected Couple changerVitesse(Couple vitesse) {
		if(vitesse.getX()>=1) 
			vitesse.setX(vitesse.getX()-1);
		if(vitesse.getX()<=-1) 
			vitesse.setX(vitesse.getX()+1);
		if(vitesse.getY()>=1) 
			vitesse.setY(vitesse.getY()-1);
		if(vitesse.getY()<=-1) 
			vitesse.setY(vitesse.getY()+1);
		
	//	 vitesse.setToZero();
		return vitesse;
	}
	
	public boolean isArrival()	{
		return false;
	}


}
