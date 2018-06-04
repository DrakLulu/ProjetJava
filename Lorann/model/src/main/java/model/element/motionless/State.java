package model.element.motionless;
import model.element.Permeability;

public abstract class State extends MotionlessElement
{
	protected boolean state = true;
	
	protected State(char sprite, Permeability permeability, String imageName)
	{
		super(sprite, imageName, permeability);
	}

	
//getter and setter of state
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
