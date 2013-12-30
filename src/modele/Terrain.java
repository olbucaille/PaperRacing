package modele;

import java.io.*;
import controleur.Couple;
import controleur.Partie;


/**
 * 
 * @author olbucaille
 *		Represent le terrain
 */
public class Terrain {

	private Case[][] Cases;
	public static  int HAUTEUR_TERRAIN = 0;
	public static  int LARGEUR_TERRAIN = 0;

	public String chaine;
	public  Terrain(Partie main,File file)
	{
		if(file.canRead()&& file.exists())
		{

			try{
				InputStream ips=new FileInputStream(file.getAbsolutePath()); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				String ligne;


				while ((ligne=br.readLine())!=null){
					HAUTEUR_TERRAIN ++;
					if( ligne.lastIndexOf('.')+1 > LARGEUR_TERRAIN)
						LARGEUR_TERRAIN =  ligne.lastIndexOf('.')+1 ;
					if( ligne.lastIndexOf('S')+1 > LARGEUR_TERRAIN)
						LARGEUR_TERRAIN =  ligne.lastIndexOf('S')+1 ;
					if( ligne.lastIndexOf('#')+1 > LARGEUR_TERRAIN)
						LARGEUR_TERRAIN =  ligne.lastIndexOf('#')+1 ;
				}

				//a modif plus tard en fonction de choix
			//	LARGEUR_TERRAIN = LargeurTerrainFichier;
			//	HAUTEUR_TERRAIN = HauteurTerrainFichier;

				//creation de du damier
				Cases = new Case[HAUTEUR_TERRAIN][]; 
				for(int i =0;i<HAUTEUR_TERRAIN;i++)
					Cases[i] = new Case[LARGEUR_TERRAIN];
				for(int i =0;i<HAUTEUR_TERRAIN;i++)
					for(int j =0;j<LARGEUR_TERRAIN;j++)
						Cases[i][j]= new Case();
				

				ipsr.close();
				br.close();
				ips.close();
				ips = new FileInputStream(file.getAbsolutePath()); 
				ipsr = new InputStreamReader(ips);
				br = new BufferedReader(ipsr);


				
				for(int i=0;i<HAUTEUR_TERRAIN;i++)
				{
					ligne=br.readLine();
					
						for(int j=0;j<LARGEUR_TERRAIN;j++)
						{
								Cases[i][j]= new Case();		
								Cases[i][j].affecter(ligne.charAt(j));
								if(ligne.charAt(j)=='S')
								{
									controleur.Partie.joueur1 = new Voiture(new Couple(i,j));
								}
							}
							
						}
					
				br.close(); 
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
		}
	}

	public Case getCase(Couple Coord)
	{
		return Cases[Coord.getX()][Coord.getY()];
		
	}
	}
