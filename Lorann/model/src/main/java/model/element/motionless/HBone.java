package model.element.motionless;

import model.Permeability;

public class HBone extends State
{
	public final static char HBone= '-';
	public final static String ImageC="horizontal_bone.png";
	
	/**
	 * The Builder that give the position, the access path of the sprite, and the parameters of the horizontal bone.
	 */
	public HBone() {
		super(HBone, Permeability.Blocking, ImageC);
		// TODO Auto-generated constructor stub
	}


}
