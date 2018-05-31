package model.element.mobile;

import model.element.Permeability;

public class Kyracj extends Demons
{
	private static char Kyracj ='A';
	private static String imageName="monster_3.png";
	
	public Kyracj(int x, int y) 
	{
		super(Kyracj, Permeability.Penetrable, imageName);
		setX(x);
		setY(y);
	}

}
