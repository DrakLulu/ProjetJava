package model.element.motionless;

import model.Permeability;
import model.element.Element;

public abstract class MotionlessElement extends Element
{	
	/**
	 * This method is for the element that can't move.
	 * @param sprite
	 * @param image
	 * @param perm
	 */
	public MotionlessElement(char sprite, String image, Permeability perm) {
		super(sprite, image, perm);
	
	}

}
