package model.element.mobile;

import model.element.Permeability;
import model.element.mobile.MotionElement;

public class Spell extends MotionElement{

	public final static char Spell= '<';
	public static String Image="fireball_1.png";
	
	public Spell(int x, int y, String Image) {
		super(Spell,0,0,Image, Permeability.Permeable); 
		this.setX(x); 
		this.setY(y);
	}
}