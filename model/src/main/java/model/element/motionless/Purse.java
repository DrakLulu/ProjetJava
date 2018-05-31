package model.element.motionless;

import model.element.Permeability;

public class Purse extends State 
{
	private static char Purse ='1';
	private static String imageName="purse.png"; 
	
	
	public  Purse () 
	{
		super(Purse, Permeability.Penetrable, imageName);
	}
}
