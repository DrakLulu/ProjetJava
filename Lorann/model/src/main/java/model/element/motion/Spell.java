package model.element.motion;

import model.ISpell;
import model.Permeability;
import model.element.motion.MotionElement;

public class Spell extends MotionElement implements ISpell{

	public final static char Spell= '<';
	public static String Image="fireball_1.png";
	private String dir;
	
	public Spell(int x, int y, String Image) {
		super(Spell,0,0,Image, Permeability.Permeable); 
		this.setX(x); 
		this.setY(y);
	}
	public String getdir() {
		return dir;
	}
	
	public void setdir(String dir) {
		this.dir = dir;
	}
}