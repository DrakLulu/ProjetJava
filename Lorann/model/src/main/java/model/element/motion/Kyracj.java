package model.element.motion;

import model.Permeability;

public class Kyracj extends Demons {
	
	public final static char Kyracj= 'A';
	public final static String ImageA="monster_1.png";

	public Kyracj(int x, int y) {
		super(x, y, Kyracj, ImageA, Permeability.Blocking);
		
	}

}
