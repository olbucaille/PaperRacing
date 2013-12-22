package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import modele.Name;
import modele.Terrain;
import controleur.Couple;
import controleur.Partie;

public class Racing extends JFrame implements ActionListener {

	private static Racing instance;
	public static Partie partie;
	public JLabel img;
	public JButton bt_valider;
	public JLabel lb_nomJoueur;
	public JTextField tf_nomjoueur;
	public static 	TerrainPanel picLabel ;
	private JButton bt_control [];

	private Racing ()
	{
		super("Paper Racing");	

		partie = new Partie();
		partie.lancerPartie();
		creerComposants();
		placerComposants();		

	}

	public static Racing getInstance()
	{
		if(instance == null)
			instance = new Racing();
		return instance;
	}

	public void init(String pseudo)
	{
	 
		lb_nomJoueur = new JLabel(pseudo);
	}



	private void creerComposants() 
	{


		lb_nomJoueur = new JLabel("pseudo");
		tf_nomjoueur = new JTextField("unknown");
		bt_control= new JButton[9];


		bt_control[0] = new JButton(new ImageIcon(Name.FLECHE_BAS_GAUCHE));
		bt_control[1] = new JButton(new ImageIcon(Name.FLECHE_BAS));		
		bt_control[2] = new JButton(new ImageIcon(Name.FLECHE_BAS_DROIT));
		bt_control[3] = new JButton(new ImageIcon(Name.FLECHE_GAUCHE));
		bt_control[4] = new JButton(new ImageIcon(Name.CENTRE));
		bt_control[5] = new JButton(new ImageIcon(Name.FLECHE_DROITE));
		bt_control[6] = new JButton(new ImageIcon(Name.FLECHE_HAUT_GAUCHE));
		bt_control[7] = new JButton(new ImageIcon(Name.FLECHE_HAUT));
		bt_control[8] = new JButton(new ImageIcon(Name.FLECHE_HAUT_DROIT));

		for(int i=0; i<9;i++){
			bt_control[i].addActionListener(this);
			bt_control[i].setPreferredSize(new Dimension(60, 60));
		}



		//new ImageIcon("./../media/fleche.jpg")
	}


	private void placerComposants() 
	{
		//création des conteneurs et composants

		JPanel gdControl = new JPanel(new GridLayout(3,3));
		JPanel bdMenu = new JPanel(new BorderLayout());
		JPanel flPseudo = new JPanel(new FlowLayout());
		JPanel pan1 = new JPanel(new BorderLayout());
		this.getContentPane().setLayout(new BorderLayout());
		
		BufferedImage myPicture= null;
		try {
		myPicture = ImageIO.read(new File(Name.LOGO));
			} catch (IOException e) 
			{}
			JLabel logo = new JLabel(new ImageIcon( myPicture));
			JPanel pnLogo = (JPanel) new JPanel(new FlowLayout()); 
			pnLogo.add(logo);
			
		
			JPanel pnjoueur = (JPanel) new JPanel(new FlowLayout()); 
			pnjoueur.add(lb_nomJoueur);
			
			
			
		gdControl.add(bt_control[6]);
		gdControl.add(bt_control[7]);
		gdControl.add(bt_control[8]);
		gdControl.add(bt_control[3]);
		gdControl.add(bt_control[4]);
		gdControl.add(bt_control[5]);
		gdControl.add(bt_control[0]);
		gdControl.add(bt_control[1]);
		gdControl.add(bt_control[2]);



		bdMenu.add(gdControl, BorderLayout.SOUTH);

		picLabel = new TerrainPanel();
		

		//picLabel.setPreferredSize(new Dimension(Terrain.LARGEUR_TERRAIN*20,(Terrain.HAUTEUR_TERRAIN+1)*20));
		bdMenu.setPreferredSize(new Dimension(180, 180));
		//On Affecte le conteneur principal
		
		JPanel glDroit = new JPanel(new GridLayout(2,1));
		JPanel glGauche = new JPanel(new GridLayout(2,1));
		
		glDroit.add(picLabel);
		glDroit.add(logo);
		glGauche.add(pnjoueur);
		glGauche.add(gdControl);
		
	//	pan1.add(glDroit, BorderLayout.EAST);
	//	pan1.add(glGauche, BorderLayout.WEST);	
		
		//On ajoute à la fenetre
		this.getContentPane().add(glGauche,BorderLayout.EAST);
		this.getContentPane().add(glDroit, BorderLayout.CENTER);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		for(int i=0; i<9;i++)
		{		
			if (source == bt_control[i])
			{
				partie.update(++i);		

			}

		}

		update();

	}

	public void update()
	{	

		Racing.getInstance().getContentPane().repaint();
		picLabel.repaint();	

	}

}



