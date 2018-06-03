package model.element.mobile;

import model.element.Permeability;
import model.element.mobile.Demons;

public class Maarcg extends Demons {

	public final static char Maarcg= 'C';
	public final static String ImageC="monster_3.png";

	
	public Maarcg(int x, int y) {
		super(x, y, Maarcg, ImageC, Permeability.Blocking);
	
		}

}
