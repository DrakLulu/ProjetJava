package model.element.motion;

import model.IDemons;
import model.Permeability;

public class Demons extends MotionElement implements IDemons
{
	public Demons(int x, int y, char nom, String image, Permeability blocking) {
		super(nom, x, y, image, blocking);
	
	}	
	
	
}
	

