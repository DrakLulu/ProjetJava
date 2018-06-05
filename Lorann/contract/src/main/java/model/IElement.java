package model;

import java.awt.Image;

public interface IElement 
{
	public void loadImage(String imageI);
	
	public  Image getImage();
	public void setImage(Image imagen);
	
	public char getSprite();
	public void setSprite(char sprite);
	
	public Permeability getPermeability();
	public void setPermeability(Permeability permeability);
	
	
	public String getImagei();
	public void setImagei(String imagei);
}
