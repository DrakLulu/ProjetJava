package model.element;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Element 
{
	private Permeability permeability;
	private char sprite;
	private static Image image;
	
	protected Element ( char sprite, Permeability permeability, String imageName)
	{
		this.setSprite(sprite);
		this.setPermeability(permeability);
		if (imageName != "") 
		{
			Image i = new ImageIcon("lib/"+imageName).getImage();
			setImage(i);
		}
		else 
		{
			setImage(null);
		}
	}

	
	
	public Image getImage() {
		return image;
	}

	public static void setImage(Image image) {
		Element.image = image;
	}



	public char getSprite() {
		return sprite;
	}

	public void setSprite(char sprite) {
		this.sprite = sprite;
	}



	public Permeability getPermeability() {
		return permeability;
	}

	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}
}
