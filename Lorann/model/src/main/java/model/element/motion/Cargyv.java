package model.element.motion;

import model.element.Permeability;

public class Cargyv extends Demons {
	
	public final static char Cargyv= 'D';
	public final static String ImageD="monster_4.png";


	public Cargyv( int x, int y) {
		super(x, y, Cargyv, ImageD, Permeability.Blocking);

	}

}
