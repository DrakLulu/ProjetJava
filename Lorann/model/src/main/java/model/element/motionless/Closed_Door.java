package model.element.motionless;

import model.Permeability;

public class Closed_Door extends MotionlessElement
{
	public final static char Door= 'Y';
	public final static String Image="gate_closed.png";
	/**
	 * The Builder that give the position, the access path of the sprite, and the parameters of the Closed Door.
	 */
	public Closed_Door() {
		super(Door, Image, Permeability.Permeable );
	}

}
