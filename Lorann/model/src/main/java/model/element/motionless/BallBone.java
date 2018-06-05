package model.element.motionless;

import model.Permeability;

public class BallBone extends  State
{
	
	public final static char BoneBall= 'O';
	public final static String ImageC="bone.png";
	/**
	 * The Builder that give the position, the access path of the sprite, and the parameters of the BallBone.
	 */
	public BallBone() {
		super(BoneBall, Permeability.Blocking, ImageC);
	}

}
