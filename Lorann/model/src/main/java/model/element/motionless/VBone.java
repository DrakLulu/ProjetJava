package model.element.motionless;

import model.Permeability;

public class VBone extends State
{
	public final static char VBone= '|';
	private final static String imageC ="vertical_bone.png";
	public VBone() {
		super(VBone, Permeability.Blocking, imageC);
	}

}
