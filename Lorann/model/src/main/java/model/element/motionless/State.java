package model.element.motionless;
import model.Permeability;

public abstract class State extends MotionlessElement
{
	protected boolean state = true;
	/**
	 * This method allows to know if the state of an object is true or false.
	 * @param sprite
	 * @param permeability
	 * @param imageName
	 */
	protected State(char sprite, Permeability permeability, String imageName)
	{
		super(sprite, imageName, permeability);
	}

	
	/**
	 * The getter of state.
	 * @return state
	 */
	public boolean isState() {
		return state;
	}
	/**
	 * The setter of state.
	 * @param state
	 */
	public void setState(boolean state) {
		this.state = state;
	}
}
