package vue;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import controleur.Couple;
import controleur.Partie;
import modele.Name;
import modele.Terrain;

@SuppressWarnings("serial")
class TerrainPanel extends JPanel {
	int voitureIs=5;
	public TerrainPanel( ) {
		
		//setBorder(BorderFactory.createLineBorder(Color.WHITE, 20));
	}

	public int choixVoiture(int vitesseX, int vitesseY){
		
		if(vitesseX<=-1){
			
			if(vitesseY<=-1)
				 voitureIs=7;
			if(vitesseY==0)
				 voitureIs=8;
			if(vitesseY>=1)
				voitureIs=9;
			
		}else if(vitesseX==0){
			if(vitesseY<=-1)
				 voitureIs=4;
			if(vitesseY==0)
				 voitureIs=5;
			if(vitesseY>=1)
				voitureIs=6;
			
		}else if (vitesseX>=1){
			if(vitesseY<=-1)
				 voitureIs=1;
			if(vitesseY==0)
				 voitureIs=2;
			if(vitesseY>=1)
				voitureIs=3;
		}
		return voitureIs;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	//	setPreferredSize(new Dimension(Terrain.HAUTEUR_TERRAIN*1, Terrain.LARGEUR_TERRAIN*1));

		for(int i=0;i<Terrain.HAUTEUR_TERRAIN;i++)
		{
			for(int j=0;j<Terrain.LARGEUR_TERRAIN;j++)
			{

				{	
					switch (Partie.t.getCase(new Couple(i,j)).toString()) {
					
					case "o":
						g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.WATER_NAME), 20*j, 20*i,20,20,Color.WHITE, this);						
						break;	
						
					case ".":
						g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.GRASS_NAME), 20*j, 20*i,20,20,Color.WHITE, this);						
						break;

					case " ":
						g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.ROAD_NAME), 20*j, 20*i,20,20,Color.WHITE, this);						
						break;
						
					case "#":
						g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.ARRIVAL_NAME), 20*j, 20*i,20,20,Color.WHITE, this);						
						break;
						
					case "x":
						g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.ROCK_NAME), 20*j, 20*i,20,20,Color.WHITE, this);						
						break;	
						


					}
					choixVoiture(Partie.joueur1.vitesse.getX(), Partie.joueur1.vitesse.getY());
					if(Partie.joueur1.getPosition().getX() == i && Partie.joueur1.getPosition().getY() == j )
						switch (voitureIs){
						default:
							g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.VOITURE6_NAME), 20*j, 20*i,20,20,Color.WHITE, this);
							break;
						case 1:
							g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.VOITURE1_NAME), 20*j, 20*i,20,20,Color.WHITE, this);
							break;
						case 2 :
							g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.VOITURE2_NAME), 20*j, 20*i,20,20,Color.WHITE, this);
							break;
						case 3:
							g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.VOITURE3_NAME), 20*j, 20*i,20,20,Color.WHITE, this);
							break; 
						case 4 :
							g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.VOITURE4_NAME), 20*j, 20*i,20,20,Color.WHITE, this);
							break;
						 case 7 :
							g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.VOITURE7_NAME), 20*j, 20*i,20,20,Color.WHITE, this);
							break;
						case 8:
							g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.VOITURE8_NAME), 20*j, 20*i,20,20,Color.WHITE, this);
							break;
						case 9 :
							g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.VOITURE9_NAME), 20*j, 20*i,20,20,Color.WHITE, this);
							break;

						}
					
//						g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.VOITURE_NAME), 20*j, 20*i,20,20,Color.WHITE, this);
					
				}	
			}
		}


	}
}