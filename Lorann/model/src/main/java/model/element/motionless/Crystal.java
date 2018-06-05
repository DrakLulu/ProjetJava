package model.element.motionless;

import model.Permeability;

public class Crystal extends MotionlessElement
{
	public final static char Crystal= 'Q';
	private final static String imageC ="crystal_ball.png";
	

	public Crystal() 
	{
		super(Crystal, imageC, Permeability.Permeable);
	}
	
}

