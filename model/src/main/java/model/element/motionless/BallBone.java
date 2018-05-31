package model.element.motionless;

import model.element.Permeability;

public class BallBone extends MotionlessElement
{
	private static char Ballbone ='O';
	private static String imageName = "bone.png";
	
	public BallBone() 
	{
		super(Ballbone, Permeability.Blocking, imageName);
	}
	
	

}
