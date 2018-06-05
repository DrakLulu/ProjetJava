package model.element.motionless;

import model.IOpen_Door;
import model.Permeability;

public class Open_Door extends MotionlessElement implements IOpen_Door{
	
	public final static char Door= '$';
	public final static String Image="gate_open.png";
	
	/**
	 * The Builder that give the position, the access path of the sprite, and the parameters of an opened Door.
	 */
	public Open_Door() {
		
		super(Door, Image, Permeability.Permeable );
	}

}
