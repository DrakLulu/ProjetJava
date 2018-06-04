package model.element.motionless;

import model.element.Permeability;

public class Open_Door extends MotionlessElement {
	
	public final static char Door= '$';
	public final static String Image="gate_open.png";
	public Open_Door() {
		
		super(Door, Image, Permeability.Permeable );
	}

}
