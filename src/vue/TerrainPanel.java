package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;







import controleur.Couple;
import controleur.Partie;
import modele.Terrain;

class TerrainPanel extends JPanel {

	public TerrainPanel( ) {
	
		setBorder(BorderFactory.createLineBorder(Color.WHITE, 25));
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
					switch (Partie.t.getCase(new Couple(i,j)).toString().toString()) {
					case ".":
						g.setColor(Color.green);						
						break;

					case " ":
						g.setColor(Color.BLACK);						
						break;


					}

					if(Partie.joueur1.getPosition().getX() == i && Partie.joueur1.getPosition().getY() == j )
						g.setColor(Color.WHITE);	


					g.fillRect(20*j, 20*i, 20, 20);

					//System.out.print(Partie.t.getCase(new Couple(i,j)).toString());

				}	
			}
		}

		//  AffichageConsole.afficherTerrain();
		//  Racing.partie.joueur1.update();



	}


	public void paintCase(Graphics g, int x, int y, Color color)
	{
		//paintComponent(g);
		g.setColor(color);
		g.fillRect(x, y, 10,10);     

	}
}