package model.element.motion;

import model.IDemons;
import model.Permeability;

public class Demons extends MotionElement implements IDemons
{
	/**
	 * The Builder that give the position, the access path of the sprite, and the parameters of the Demons.
	 * @param x
	 * @param y
	 * @param nom
	 * @param image
	 * @param blocking
	 */
	public Demons(int x, int y, char nom, String image, Permeability blocking) {
		super(nom, x, y, image, blocking);
	
	}	
	
	
}
	

