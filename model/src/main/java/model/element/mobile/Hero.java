package model.element.mobile;

import model.element.Permeability;
import model.element.mobile.MotionElement;

public class Hero extends MotionElement
{
	public final static char Lorann= '@';
	public final static String Image1="lorann_b.png";
	

	public Hero(int x,int y) {
		super(Lorann, x, y, Image1, Permeability.Permeable);

	}	
}
