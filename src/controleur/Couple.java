package controleur;

public class Couple {
	int x;
	int y;
	
	public Couple(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Couple(Couple c)
	{
		x = c.x;
		y = c.y;
	}
	

	public Couple()
	{
		x=0;
		y=0;
	}
	
	public void setToZero()
	{
		x = 0;
		y=0;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isnull()
	{
		if(x==0&&y==0)
			return true;
		return false;
	}


	@Override
	public String toString() {
		return ""+ x + ", " + y ;
	}
	
	

}
