package model.element.motionless;

import model.Permeability;

public class Crystal extends MotionlessElement
{
	public final static char Crystal= 'Q';
	private final static String imageC ="crystal_ball.png";
	
	/**
	 * The Builder that give the position, the access path of the sprite, and the parameters of the Crystal.
	 */
	public Crystal() 
	{
		super(Crystal, imageC, Permeability.Permeable);
	}
	
}

