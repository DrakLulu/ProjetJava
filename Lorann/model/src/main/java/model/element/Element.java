package model.element;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Element 
{

	private char sprite;
	private Image image;
	private Permeability permeability;
	private String imagei;
	
	
	
	public Element (char sprite, String imageI, Permeability permeability)  
	{
		
		setSprite(sprite);
		setPermeability(permeability);
		loadImage(imageI);
		setImagei(imageI); 
		
	}
	
	public void loadImage(String imageI) {
		
		if(imageI != "") {
			ImageIcon icon = new ImageIcon("lib/"+imageI);
			Image img = icon.getImage();
			setImage(img);	
			}else {
				setImage(null);
			}
		setImagei(imageI);
	}
	
	
	public  Image getImage() {
		return image;
	}

	public void setImage(Image imagen) {
		this.image = imagen;
	}

	public char getSprite() 
	{
		return sprite;
	}

	public void setSprite(char sprite) 
	{
		this.sprite = sprite;
	}

	public Permeability getPermeability() {
		return permeability ;
	}
	
	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	public void setState(boolean state) {
		
	}

	public String getImagei() {
		return imagei;
	}

	public void setImagei(String imagei) {
		this.imagei = imagei;
	}		

}