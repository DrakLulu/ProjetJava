package model.element.motionless;

import model.IOpen_Door;
import model.Permeability;

public class Open_Door extends MotionlessElement implements IOpen_Door{
	
	public final static char Door= '$';
	public final static String Image="gate_open.png";
	public Open_Door() {
		
		super(Door, Image, Permeability.Permeable );
	}

}
