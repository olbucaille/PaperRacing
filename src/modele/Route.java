package modele;

import controleur.Couple;
import controleur.Partie;

public class Route extends Element {
	public Route ()
	{
		nom = " ";
		
	}

	@Override
	public void update( Couple Acceleration) {
		
		// on met � jour la vitesse en y ajoutant l'acceleration
		Partie.joueur1.vitesse.setX( Partie.joueur1.vitesse.getX()+Acceleration.getX());
		Partie.joueur1.vitesse.setY( Partie.joueur1.vitesse.getY()+Acceleration.getY());
	
	//	updateInterne(Partie.joueur1.position);
		Couple nouvellePosition= updateInterne(new Couple(Partie.joueur1.vitesse),Partie.joueur1.position,new Couple(Partie.joueur1.vitesse));
	
		// appel qui passe d'elt en elt 
		
		//on met � jour la position		
		//position();
	
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


}
