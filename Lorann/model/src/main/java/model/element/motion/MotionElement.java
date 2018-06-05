package model.element.motion;

import model.Permeability;
import model.element.Element;

public abstract class MotionElement extends Element 
{
	
	protected int x ;
	protected int y ; 
	private boolean alive = true;
	

	public MotionElement(char nom, int x, int y, String ImageC, Permeability permeability ) 
	{
		super(nom, ImageC, permeability);
		this.setX(x);
		this.setY(y); 
	}
	
	public void moveRight() {
		setX(x+1); 
		setY(y);
		
	}


	public void noMove() {
		setX(x);
		setY(y);
	}


	public void moveLeft() {
		setX(x-1);
		setY(y);
	}


	public void moveUp() {
		setY(y+1);
		setX(x);
	}


	public void moveDown() {
		setY(y-1);
		setX(x);
	}

	public boolean isAlive() {
        return alive;
    }
	
    public void setAlive(boolean alive)
    {
        this.alive = alive;
        
    }


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
	

}
