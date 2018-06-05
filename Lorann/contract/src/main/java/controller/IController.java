package controller;

import model.IElement;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IController 
{
	public void play();
	
	public void ifWin();
	
	public void ifDead();
	
	public void IA();
	
	public void movement(); 
	
	public void throwSpell();
	
	public void moveSpell();
	
	
	public UserOrder getUserOrder();
	public void setUserOrder(UserOrder userOrder);
	
	public int getScore();
	public void setScore(int score);
	
	public int getLorannX();
	public void setLorannX(int lorannX);
	
	public int getLorannY();
	public void setLorannY(int lorannY);
	
	public IElement[][] getTbl();
	public void setTbl(IElement[][] tbl);
	
	public int getDoorX();
	public void setDoorX(int xDoor);
	
	public int getDoorY();
	public void setDoorY(int yDoor);
}
