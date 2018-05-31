package model.element.mobile;

import model.element.Permeability;

public class Cargyv extends Demons 
{
	private static char Cargyv ='D';
	private static String imageName="monster_2.png";
	
	public Cargyv(int x, int y) 
	{
		super(Cargyv, Permeability.Penetrable, imageName);
		setX(x);
		setY(y);
	}

}
