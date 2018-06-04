package model.element.mobile;

import model.element.Element;
import model.element.Permeability;

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

	public void noMove() {
		setX(x);
		setY(y);
	}

	public void moveLeft(int x, int y) {
		setX(x);
		setY(y-1);
	}

	public  void moveUp(int x, int y) {
		setY(y);
		setX(x-1);
	}

	public void moveRight(int x, int y) {
		setX(x);
		setY(y+1);
		
	}

	public void moveDown(int x, int y) {
		setX(x+1);
		setY(y);
		
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

