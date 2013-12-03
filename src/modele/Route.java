package modele;

import javax.swing.text.Position;

import controleur.Couple;
import controleur.Partie;

public class Route extends Element {
	public Route ()
	{
		nom = " ";
		
	}

	@Override
	public void update( Couple Acceleration) {
			
		// on met à jour la vitesse en y ajoutant l'acceleration
		Partie.joueur1.Vitesse.setX( Partie.joueur1.Vitesse.getX()+Acceleration.getX());
		Partie.joueur1.Vitesse.setY( Partie.joueur1.Vitesse.getY()+Acceleration.getY());

		//on met à jour la position		
		position();
			
	}
	
	

}
