package model.element.motion;

import model.Permeability;

public class Maarcg extends Demons {

	public final static char Maarcg= 'C';
	public final static String ImageC="monster_3.png";

	/**
	 * The Builder that give the position, the access path of the sprite, and the parameters of Maarcg.
	 * @param x
	 * @param y
	 */
	public Maarcg(int x, int y) {
		super(x, y, Maarcg, ImageC, Permeability.Blocking);
	
		}

}
