package modele;

public class Case {
	
	Element elt;
	
	public Case()
	{
	
		elt = new Route(false);
	}
	public void affecter(char val)
	{
		if(val == ' ')
			elt = new Route(false);
		if(val == '.')
			elt = new Herbe();
		if(val == 'x')
			elt = new Obstacle();
		if(val == 'S')
			elt = new Route(false);
		if(val == '#')
			elt = new Route(true);
		
		
	}

	@Override
	public String toString() {
		return ""+elt.nom;
	}
	
	

}
