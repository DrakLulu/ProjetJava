package model.element.motion;

import model.Permeability;
import model.element.Element;

public abstract class MotionElement extends Element 
{
	
	protected int x ;
	protected int y ; 
	private boolean alive = true;
	
	/**
	 * This method is for the element that can move.
	 * @param nom
	 * @param x
	 * @param y
	 * @param ImageC
	 * @param permeability
	 */
	public MotionElement(char nom, int x, int y, String ImageC, Permeability permeability ) 
	{
		super(nom, ImageC, permeability);
		this.setX(x);
		this.setY(y); 
	}
	/**
	 * The method that moves the element to the right.
	 */
	public void moveRight() {
		setX(x+1); 
		setY(y);
		
	}

	/**
	 * The method makes the element stay on place.
	 */
	public void noMove() {
		setX(x);
		setY(y);
	}

	/**
	 * The method that moves the element to the left.
	 */
	public void moveLeft() {
		setX(x-1);
		setY(y);
	}

	/**
	 * The method that moves the element to the top.
	 */
	public void moveUp() {
		setY(y+1);
		setX(x);
	}

	/**
	 * The method that moves the element down. 
	 */
	public void moveDown() {
		setY(y-1);
		setX(x);
	}
	/**
	 * The boolean that says if the character is still alive (getter).
	 * @return alive
	 */
	public boolean isAlive() {
        return alive;
    }
	/**
	 * The boolean that says if the character is still alive (ssetter).
	 * @param alive
	 */
    public void setAlive(boolean alive)
    {
        this.alive = alive;
        
    }

    /**
     * The getter of X.
     * @return x
     */
	public int getX() {
		return x;
	}

	/**
	 * The setter of X.
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * The getter of Y.
	 * @return y
	 */

	public int getY() {
		return y;
	}
	/**
	 * The setter of Y.
	 * @param y
	 */

	public void setY(int y) {
		this.y = y;
	}
	

}
