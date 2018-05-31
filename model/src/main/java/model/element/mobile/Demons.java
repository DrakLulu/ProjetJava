package model.element.mobile;

import model.element.Element;
import model.element.Permeability;
import model.Model;
public abstract class Demons extends MotionElement 
{
	private int Nombre;

	protected Demons(char sprite, Permeability permeability, String imageName) {
		super(sprite, permeability, imageName);
	}
	
	public void IA(int x, int y) 
	{
		Element[][] tbl = Model.getTable();
		Nombre = (int)(Math.random()*10)%5; 
		switch (Nombre)
		{
			case 1 :
				if (tbl[x+1][y].getPermeability() != Permeability.Blocking)
				{
				moveRight();
				}
				else 
				{
				noMove();
				}
				break;
				
			case 2 :
				if (tbl[x][y+1].getPermeability() != Permeability.Blocking)
				{
				moveDown();
				}
				else 
				{
				noMove();
				}
				break;
			
			case 3 :
				if (tbl[x-1][y].getPermeability() != Permeability.Blocking)
				{
				moveLeft();
				}
				else 
				{
				noMove();
				}
				break;
			
			case 4 :
				if (tbl[x][y-1].getPermeability() != Permeability.Blocking)
				{
				moveUp();
				}
				else 
				{
				noMove();
				}
				break;
			
			case 0 :
				noMove();
			
			default: 
				noMove();
				break;
		}
	}
}
