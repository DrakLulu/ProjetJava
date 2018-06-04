package model.element.motionless;

import model.element.Permeability;

public class Nothing extends State{
	
	public final static char nothing= ' ';
	public Nothing() {
		super(nothing, Permeability.Permeable, "");
		
	}

}
