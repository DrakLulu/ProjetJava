package model.element.motion;

import model.IHero;
import model.Permeability;

public class Hero extends MotionElement implements IHero
{
	public final static char Lorann= '@';
	public final static String Image1="lorann_b.png";
	
	/**
	 * The Builder that give the position, the access path of the sprite, and the parameters of Lorann.
	 * @param x
	 * @param y
	 */
	public Hero(int x,int y) {
		super(Lorann, x, y, Image1, Permeability.Permeable);

	}	
}
