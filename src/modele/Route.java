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
			
		// on met � jour la vitesse en y ajoutant l'acceleration
		Partie.joueur1.vitesse.setX( Partie.joueur1.vitesse.getX()+Acceleration.getX());
		Partie.joueur1.vitesse.setY( Partie.joueur1.vitesse.getY()+Acceleration.getY());
	//	updateInterne(Partie.joueur1.position);
		
		// appel qui passe d'elt en elt 
		
		//on met � jour la position		
		position();
			
	}

	@Override
	protected Couple changerVitesse(Couple Vitesse) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	updateInterne(Couple vitesse)
	{
		Couple c = prochaineCase(Partie.joueur1.position,	vitesse);
		changerVitesseJoueur();
		vitesse = changerVitesseSimulee(vitesse);
		if(vitesse==0)
			return;
		else
		Partie.t.getCase(c).elt.updateInterne(vitesse)
		
	}
	

	@Override
	protected Couple changerVitesseSimulee(Couple vitesse) {
		
		
			vitesse.setX(x);//...on change
		
		return vitesse;
			
			
	}
	
	protected changerVitesseJoueur() {
	return;
	}
*/

}
