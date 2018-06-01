package model.element.mobile;

import model.element.Element;
import model.element.Permeability;

public class Spell extends Element{

	public final static char Spell= '<';
	public static String Image="fireball_1.png";
	public final static String Image1="fireball_1.png";
	public final static String Image2="fireball_2.png";
	public final static String Image3="fireball_3.png";
	public final static String Image4="fireball_4.png";
	private int x;
	private int y; 
	
	public Spell(int x, int y, String Image) {
		super(Spell, Permeability.Penetrable, Image); 
		this.setX(x); 
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}