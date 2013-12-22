package vue;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import modele.Name;


public class Lanceur extends JFrame implements ActionListener
{
	public JLabel img;
	public JButton bt_valider;
	public JLabel lb_nomJoueur;
	public JTextField tf_nomjoueur;

	public static void main(String[] arg) 
	{
		Lanceur p = new Lanceur();
		p.setMinimumSize(new Dimension(600,225));	
		p.setVisible(true);	
		p.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public Lanceur ()
	{
		super("Paper Racing");	
		creerComposants();
		placerComposants();

	}


	private void creerComposants() 
	{

	
	
		
		bt_valider = new JButton("c'est partit !!!");
		bt_valider.addActionListener(this);
		lb_nomJoueur = new JLabel("pseudo");
		tf_nomjoueur = new JTextField("unknown");


	}


	private void placerComposants() 
	{
		//création des conteneurs et composants
		JPanel gdForm = new JPanel(new GridLayout(2,1));
		JPanel flPseudo = new JPanel(new FlowLayout());
		JPanel pan1 = new JPanel(new BorderLayout());
		this.getContentPane().setLayout(new BorderLayout());
		

		bt_valider.setMaximumSize(new Dimension(10,30));
		
		
		//On charge l'image
		BufferedImage myPicture= null;
			try {
			myPicture = ImageIO.read(new File(Name.LOGO));
				} catch (IOException e) 
				{}
				JLabel picLabel = new JLabel(new ImageIcon( myPicture));
							
		//on met label et champ ensemble
		flPseudo.add(lb_nomJoueur);
		flPseudo.add(tf_nomjoueur);
		
		//mise en forme du formulaire
		gdForm.add(flPseudo);
		gdForm.add(bt_valider);	
		
		//On Affecte le conteneur principal
		pan1.add(gdForm, BorderLayout.EAST);
		pan1.add(picLabel, BorderLayout.WEST);	
		pan1.setSize(new Dimension(50,50));
		
		//On ajoute à la fenetre
		this.getContentPane().add(pan1,BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == bt_valider)
		{
			this.setVisible(false);


			Racing game =Racing.getInstance();
			game.init(lb_nomJoueur.getText());
			game.setMinimumSize(new Dimension(800,700));
			game.setVisible(true);	
			game.setDefaultCloseOperation(EXIT_ON_CLOSE);
			//Racing.init(tf_nomjoueur.getText());

		}

	}



}
