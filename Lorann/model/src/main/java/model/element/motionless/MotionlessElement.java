package model.element.motionless;

import model.Permeability;
import model.element.Element;

public abstract class MotionlessElement extends Element
{	
	public MotionlessElement(char sprite, String image, Permeability perm) {
		super(sprite, image, perm);
	
	}

}
