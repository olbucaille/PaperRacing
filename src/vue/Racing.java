package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import modele.Name;
import controleur.Partie;

@SuppressWarnings("serial")
public class Racing extends JFrame implements ActionListener {

	private static Racing instance;
	public static Partie partie;

	public static TerrainPanel picLabel ;

	private JLabel lb_nomJoueur;
	private JLabel jl_nomjoueur;
	private JLabel jl_positionJoueur;
	private JLabel jl_vitesseJoueur;
	private JLabel jl_statutJoueur;
	private JLabel jl_scoreJoueur;

	private JButton bt_control [];


	JLabel logo ;
	JPanel pnLogo;


	private  JSplitPane sp_panel;
	JScrollPane picPane;

	private JPanel gdControl;
	private JPanel bdMenu;
	JPanel pnjoueur;

	private Racing ()
	{
		super("Paper Racing");			
	}

	//singleton
	public static Racing getInstance()
	{
		if(instance == null)
			instance = new Racing();
		return instance;
	}

	public void init(String pseudo)
	{	 
		jl_nomjoueur = new JLabel(pseudo);
		partie = new Partie();
		partie.lancerPartie();
		creerComposants();
		placerComposants();		
	}



	private void creerComposants() 
	{
		lb_nomJoueur = new JLabel("pseudo"+"\n");

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

		for(int i=0; i<9;i++)
		{
			bt_control[i].addActionListener(this);
			bt_control[i].setPreferredSize(new Dimension(60, 60));
		}

		//création des conteneurs et composants

		gdControl = new JPanel(new GridLayout(3,3));
		bdMenu = new JPanel(new BorderLayout());
		new JPanel(new FlowLayout());
		new JPanel(new BorderLayout());
		this.getContentPane().setLayout(new BorderLayout());

		//imagelogo 
		BufferedImage myPicture= null;
		try {
			myPicture = ImageIO.read(new File(Name.LOGO));
		} catch (IOException e) 
		{}
		logo = new JLabel(new ImageIcon( myPicture));
		pnLogo = (JPanel) new JPanel(new FlowLayout()); 
		pnLogo.add(logo);

		//infos nom joueur
		pnjoueur = (JPanel) new JPanel(new GridLayout(10,1));


	}


	private void placerComposants() 
	{
		//affetations infos
		//nomjoueur
		JPanel pn_nomJoueur = new JPanel(new FlowLayout());
		pn_nomJoueur.add(lb_nomJoueur);
		pn_nomJoueur.add(jl_nomjoueur);


		//info position
		JPanel pn_position = new JPanel(new FlowLayout());
		jl_positionJoueur = new JLabel(" "+ Partie.joueur1.getPosition().toString());
		pn_position.add(new JLabel("Position"));
		pn_position.add(jl_positionJoueur);

		//info vitesse
		JPanel pn_vitesse = new JPanel(new FlowLayout());
		jl_vitesseJoueur = new JLabel(" "+ Partie.joueur1.getVitesse());
		pn_vitesse.add(new JLabel("Vitesse"));
		pn_vitesse.add(jl_vitesseJoueur);

		//info score
		JPanel pn_score = new JPanel(new FlowLayout());
		jl_scoreJoueur = new JLabel(" "+ Partie.joueur1.score);
		pn_score.add(new JLabel("Score Joueur : "));
		pn_score.add(jl_scoreJoueur);

		//info statut
		JPanel pn_statut = new JPanel(new FlowLayout());
		jl_statutJoueur = new JLabel(" okay ");
		pn_statut.add(jl_statutJoueur);


		pnjoueur.add(pn_nomJoueur);
		pnjoueur.add(pn_position);
		pnjoueur.add(pn_vitesse);
		pnjoueur.add(pn_score);
		pnjoueur.add(pn_statut);



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
		picPane = new JScrollPane(picLabel);


		//On Affecte les deux conteurs principaux (gauche et droit)
		JSplitPane glDroit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, picPane,logo);
		glDroit.setOneTouchExpandable(true);
		glDroit.setDividerLocation(350);
		JSplitPane glGauche =  new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnjoueur,gdControl);
		glGauche.setOneTouchExpandable(true);
		glGauche.setDividerLocation(350);


		//on cree notre panel avec des splitpane et des scrolpane
		JScrollPane sp_Gauche = new JScrollPane(glGauche);
		sp_Gauche.setPreferredSize(new Dimension(10, 10));
		sp_panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(glDroit),sp_Gauche);
		sp_panel.setOneTouchExpandable(true);
		sp_panel.setDividerLocation(550);


		//On ajoute à la fenetre
		this.getContentPane().add(sp_panel, BorderLayout.CENTER);		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		for(int i=0; i<9;i++)				
			if (source == bt_control[i])			
				partie.update(++i);	
		update();

	}

	public void update()
	{	
		jl_positionJoueur.setText(" "+ Partie.joueur1.getPosition().toString());
		jl_vitesseJoueur.setText( " "+ Partie.joueur1.getVitesse().getX()*-1+", "+Partie.joueur1.getVitesse().getY());
		jl_scoreJoueur.setText( " "+ Partie.joueur1.score);
		
		
		if(Partie.joueur1.crash)
			jl_statutJoueur.setText("CRASH !");

		else if(Partie.joueur1.win){
			for(int i=0; i<9;i++)
			gdControl.getComponent(i).setEnabled(false);
			jl_statutJoueur.setText("FINISH ! ");	
		}
		else
			jl_statutJoueur.setText("continue,...");
		Racing.getInstance().getContentPane().repaint();
		picLabel.repaint();

	}

}



