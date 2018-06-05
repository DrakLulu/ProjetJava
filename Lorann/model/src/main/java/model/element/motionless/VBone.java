package model.element.motionless;

import model.Permeability;

public class VBone extends State
{
	public final static char VBone= '|';
	private final static String imageC ="vertical_bone.png";
	/**
	 * The Builder that give the position, the access path of the sprite, and the parameters of the Vertical Bone.
	 */
	public VBone() {
		super(VBone, Permeability.Blocking, imageC);
	}

}
