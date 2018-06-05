package model.element.motionless;

import model.INothing;
import model.Permeability;

public class Nothing extends State implements INothing{
	
	public final static char nothing= ' ';
	public Nothing() {
		super(nothing, Permeability.Permeable, "");
		
	}

}
