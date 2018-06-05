package model.element.motionless;

import model.Permeability;

public class BallBone extends  State
{
	
	public final static char BoneBall= 'O';
	public final static String ImageC="bone.png";
	public BallBone() {
		super(BoneBall, Permeability.Blocking, ImageC);
	}

}
