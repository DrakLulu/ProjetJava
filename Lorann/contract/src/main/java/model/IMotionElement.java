package model;

public interface IMotionElement extends IElement
{
	public void moveRight();
	
	public void noMove();
	
	public void moveLeft();
	
	public void moveUp();
	
	public void moveDown();
	
	public boolean isAlive();
	
	public void setAlive(boolean alive);
	
	public int getX();
	
	public void setX(int x);
	
	public int getY();
	
	public void setY(int y);
	
}
