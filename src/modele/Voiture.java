package modele;
import controleur.*;


public class Voiture {
	
	Couple position;	
	Couple vitesse;
	public int score;
	public Pilote pilote;	
	public boolean crash;
	public boolean win;
	
	
	public Voiture(Couple pos)
	{
		position = pos;
		pilote = new Joueur();		
		vitesse = new Couple();
		score = 1000;
	
	}
	
	public void update()
	{
		
		Couple cp = pilote.update();
		update(cp);
				
	}
	
	public void update(Couple Acceleration)
	{
		Partie.t.getCase(position).elt.update(Acceleration);
	}

	public Couple getPosition()
	{
		return position;
	}
	
	public Couple getVitesse()
	{
		return vitesse;
	}

}
