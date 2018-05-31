package model.element.motionless;

import model.element.Element;
import model.element.Permeability;

public abstract class MotionlessElement extends Element
{
	protected MotionlessElement(char sprite, Permeability permeability, String imageName)
	{
		super(sprite, permeability, imageName);
	}
}
