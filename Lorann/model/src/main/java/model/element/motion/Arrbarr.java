package model.element.motion;

import model.Permeability;

public class Arrbarr extends Demons {
	public final static char Arrbarr= 'B';
	public final static String ImageB="monster_2.png";

	/**
	 * The Builder that give the position, the access path of the sprite, and the parameters of Arrbarr.
	 * @param x
	 * @param y
	 */
	public Arrbarr(int x, int y) {
		super(x, y, Arrbarr, ImageB,Permeability.Blocking);
	
	}

}
