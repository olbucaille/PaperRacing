package modele;

import controleur.Couple;

public class Obstacle extends Element {
	
	public Obstacle()
	{
		nom = "x";
		//this.setCoefficientRalentissement(0f);
	}

	@Override
	public void update( Couple Acceleration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Couple changerVitesse(Couple Vitesse) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
