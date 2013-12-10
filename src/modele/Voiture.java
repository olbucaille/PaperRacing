package modele;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import vue.Joueur;


import com.sun.accessibility.internal.resources.accessibility;

import controleur.*;


public class Voiture {
	
	Couple position;
	Couple vitesseInter;
	Couple vitesse;
	Pilote pilote;	
	
	
	public Voiture(Couple pos)
	{
		position = pos;
		pilote = new Joueur();		
		vitesse = new Couple();
		vitesseInter = new Couple();
	}
	
	public void update()
	{
		
		Couple cp = pilote.update();
		update(cp);
	
	
		
	}
	
	private void update(Couple Acceleration)
	{
		Partie.t.getCase(position).elt.update(Acceleration);
	}

	public Couple getPosition()
	{
		return position;
	}
	

}
