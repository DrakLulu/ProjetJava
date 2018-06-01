package model.element.motionless;

import model.element.Permeability;

public class Nothing extends  MotionlessElement
{
	private static char Nothing =' ';
	private static String imageName="";
	
	public Nothing() 
	{
		super(Nothing, Permeability.Penetrable, imageName);
	}
}
