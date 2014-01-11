package modele;

import controleur.Couple;
import controleur.Partie;

public class Obstacle extends Element {
	
	public Obstacle()
	{
		nom = "x";
		
	}

	@Override
	public void update( Couple Acceleration) {
		
		
			
	}

	@Override
	protected Couple changerVitesse(Couple vitesse) {
		 Partie.joueur1.vitesse.setToZero();
		 vitesse.setToZero();
		return vitesse;
	}


}
