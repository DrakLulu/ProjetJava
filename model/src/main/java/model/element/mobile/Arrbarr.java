package model.element.mobile;

import model.element.Permeability;
import model.element.mobile.Demons;

public class Arrbarr extends Demons {
	public final static char Arrbarr= 'B';
	public final static String ImageB="monster_2.png";

	public Arrbarr(int x, int y) {
		super(x, y, Arrbarr, ImageB,Permeability.Blocking);
	
	}

}