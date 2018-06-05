package model.element.motionless;

import model.INothing;
import model.Permeability;

public class Nothing extends State implements INothing{
	
	public final static char nothing= ' ';
	/**
	 * The Builder that give the position, the access path of the sprite, and the parameters of nothing.
	 */
	public Nothing() {
		super(nothing, Permeability.Permeable, "");
		
	}

}
