package model.element.motionless;


import model.element.Permeability;

public class HBone extends MotionlessElement{

	private static char Hbone ='-';
	private static String imageName="horizontal_bone.png";
	
	public HBone() 
	{
		super(Hbone, Permeability.Blocking, imageName);
	}

}
