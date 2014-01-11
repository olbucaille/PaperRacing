package modele;

import controleur.Couple;
import controleur.Partie;

public abstract class Element {

	String nom = "?";





	public abstract void update( Couple Acceleration);
	protected abstract Couple changerVitesse(Couple vitesse);
	
	protected  Couple updateInterne(Couple vitesse, Couple positionActuelle, Couple positionPrecedente)
	{//System.out.println("anc : "+vitesse);
		Couple nouvellePosition = prochaineCase(new Couple(positionActuelle),vitesse);	
		Couple nouvelleVitesse = changerVitesse(vitesse);
			
		//	System.out.println("nouv : "+ nouvelleVitesse);
		if( this instanceof Obstacle) 
			return positionPrecedente;
		if(verifyPosition(nouvellePosition)&&Partie.t.getCase(nouvellePosition).elt instanceof Obstacle)
			return positionActuelle;
		if(nouvelleVitesse.isnull())
			if(!verifyPosition(nouvellePosition))
				return positionActuelle;
			else
				return nouvellePosition;
		else
		{		
			
			if(verifyPosition(nouvellePosition))
				return Partie.t.getCase(nouvellePosition).elt.updateInterne(nouvelleVitesse, nouvellePosition, positionActuelle);
			else
				return positionActuelle;
						
		}
	}
	

	@Override
	public String toString() {
		return "" + nom ;
	}


	protected static boolean verifyPosition(Couple position)
	{
		
		//la condition est moche mais on verrifie que l'on ne sort pas du terrain, si oui, vitesse � 0
		if(position.getX()>=0 && position.getX()<= Terrain.HAUTEUR_TERRAIN-1)
			if(position.getY()>=0 && position.getY()<= Terrain.LARGEUR_TERRAIN-1)
				return true;	
			
				System.out.println("crash");
				Partie.joueur1.vitesse.setX(0);
				Partie.joueur1.vitesse.setY(0);
				return false;

	}
	
	
	protected static void position()
	{
		
		//la condition est moche mais on verrifie que l'on ne sort pas du terrain, si oui, vitesse � 0
		if((Partie.joueur1.position.getX()+Partie.joueur1.vitesse.getX())>=0 && (Partie.joueur1.position.getX()+Partie.joueur1.vitesse.getX())<= Terrain.HAUTEUR_TERRAIN-1)
			if((Partie.joueur1.position.getY()+Partie.joueur1.vitesse.getY())>=0 && (Partie.joueur1.position.getY()+Partie.joueur1.vitesse.getY())<= Terrain.LARGEUR_TERRAIN-1)
			{
				Partie.joueur1.position.setX( Partie.joueur1.position.getX()+Partie.joueur1.vitesse.getX());
				Partie.joueur1.position.setY( Partie.joueur1.position.getY()+Partie.joueur1.vitesse.getY());
			}
			else
			{
				System.out.println("crash");
				Partie.joueur1.vitesse.setX(0);
				Partie.joueur1.vitesse.setY(0);
			}
		else
		{
			System.out.println("crash");
			Partie.joueur1.vitesse.setX(0);
			Partie.joueur1.vitesse.setY(0);
		}

	}
	
	protected Couple prochaineCase(Couple positionActuelle,Couple vitesse )
	{
		Couple positionFuture = positionActuelle;
		if(vitesse.getX() != 0)
		{
			if(vitesse.getX()>=1)
			{
				positionFuture.setX(positionActuelle.getX()+1);
			
			}
			if(vitesse.getX()<=-1)
			{
				positionFuture.setX(positionActuelle.getX()-1);
				
			}
		}
		
		if(vitesse.getY() != 0)
		{
			if(vitesse.getY()>=1)
			{
				positionFuture.setY(positionActuelle.getY()+1);
				
			}
			if(vitesse.getY()<=-1)
			{
				positionFuture.setY(positionActuelle.getY()-1);
				
			}
		}
		
		if(positionFuture.getX()>=0 &&positionFuture.getX() <= Terrain.HAUTEUR_TERRAIN-1)
			if(positionFuture.getY()>=0 && positionFuture.getY()<= Terrain.LARGEUR_TERRAIN-1)
				return positionFuture;
		
		//msg crash + gerer si on a heurrté un obstacle 
		return 	positionActuelle;
		
	}



}
