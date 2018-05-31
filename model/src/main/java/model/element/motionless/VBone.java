package model.element.motionless;

import model.element.Permeability;

public class VBone extends MotionlessElement{

	private static char Vbone ='I';
	private static String imageName="vertical_bone.png";
	
	public VBone() 
	{
		super(Vbone, Permeability.Blocking, imageName);
	}

}
