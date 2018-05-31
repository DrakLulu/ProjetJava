package model.element.mobile;

import model.element.Element;
import model.element.Permeability;

public abstract class MotionElement extends Element
{
	private int x,y ;
	private boolean alive = true; 
	
	protected MotionElement(char sprite, Permeability permeability, String imageName) 
	{
		super(sprite, permeability, imageName);
	}


	
	
//Method of movement
	public void moveUp() 
	{
		setX(x);
		setY(y--);
	}
	public void moveDown() 
	{
		setX(x);
		setY(y++);
	}
	public void moveLeft() 
	{
		setX(x--);
		setY(y);
	}
	public void moveRight() 
	{
		setX(x++);
		setY(y);
	}
	public void noMove() 
	{
		setX(x);
		setY(y);
	}
	
//Method of Die
	public boolean Die () 
	{
		return alive;
	}
	
//getter and setter of x
	public int getX() 
	{
		return x;
	}
	protected void setX(int x) 
	{
		this.x = x;
	}
	
	
//getter and setter of y
	public int getY() 
	{
		return y;
	}
	protected void setY(int y) 
	{
		this.y = y;
	}




	
	
//getter and setter of Die
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive)
	{

		this.alive = alive;
	}
}
