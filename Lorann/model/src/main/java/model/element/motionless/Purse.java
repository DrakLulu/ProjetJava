package model.element.motionless;

import model.Permeability;

public class Purse extends MotionlessElement
{
	public final static char Purse= '1';
	public final static String ImageC= "purse.png";
	/**
	 * The Builder that give the position, the access path of the sprite, and the parameters of the Purse.
	 */
	public Purse() 
	{
		super(Purse, ImageC, Permeability.Permeable);
	}

}
