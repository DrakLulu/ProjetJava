package model.element.mobile;

import model.element.Permeability;

public class Arrbarr extends Demons
{
	private static char Arrbarr ='B';
	private static String imageName="monster_1.png";
	
	
	public Arrbarr(int x, int y) 
	{
		super(Arrbarr, Permeability.Penetrable, imageName);
		setX(x);
		setY(y);
	}

}
