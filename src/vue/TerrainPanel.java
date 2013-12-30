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

	public TerrainPanel( ) {
	
		//setBorder(BorderFactory.createLineBorder(Color.WHITE, 25));
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
					case ".":
						g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.GRASS_NAME), 20*j, 20*i,20,20,Color.WHITE, this);						
						break;

					case " ":
						g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.ROAD_NAME), 20*j, 20*i,20,20,Color.WHITE, this);						
						break;

					}

					if(Partie.joueur1.getPosition().getX() == i && Partie.joueur1.getPosition().getY() == j )
						g.drawImage(SkinProvider.GetInstance().SpriteProvider(Name.VOITURE_NAME), 20*j, 20*i,20,20,Color.WHITE, this);
						
					
				}	
			}
		}


	}
	
	


	
}