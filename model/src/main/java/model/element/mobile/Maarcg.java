package model.element.mobile;

import model.element.Permeability;

public class Maarcg extends Demons
{
	private static char Maarcg ='C';
	private static String imageName="monster_4.png";
	
	public Maarcg(int x, int y) 
	{
		super(Maarcg, Permeability.Penetrable, imageName);
		setX(x);
		setY(y);
	}

}
