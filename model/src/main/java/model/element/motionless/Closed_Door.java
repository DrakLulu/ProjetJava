package model.element.motionless;

import model.element.Permeability;

public class Closed_Door extends MotionlessElement
{
	public final static char Door= 'Y';
	public final static String Image="gate_closed.png";
	
	public Closed_Door() {
		super(Door, Image, Permeability.Permeable );
	}

}

