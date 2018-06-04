package model.element.motionless;

import model.element.Permeability;

public class Purse extends MotionlessElement
{
	public final static char Purse= '1';
	public final static String ImageC= "purse.png";
	
	public Purse() 
	{
		super(Purse, ImageC, Permeability.Permeable);
	}

}
