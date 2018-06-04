package model.element.motionless;


import model.element.Permeability;

public class HBone extends State
{
	public final static char HBone= '-';
	public final static String ImageC="horizontal_bone.png";
	
	public HBone() {
		super(HBone, Permeability.Blocking, ImageC);
		// TODO Auto-generated constructor stub
	}


}
