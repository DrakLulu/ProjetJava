package model.element;

import java.awt.Image;
import javax.swing.ImageIcon;

import model.IElement;
import model.Permeability;

/**
 * This class calls the picture of the element and its permeability.
 * 
 *
 */
public abstract class Element implements IElement
{

	private char sprite;
	private Image image;
	private Permeability permeability;
	private String imagei;
	
	
	/**
	 * This Builder sets the parameters of the element.
	 * @param sprite
	 * @param imageI
	 * @param permeability
	 */
	public Element (char sprite, String imageI, Permeability permeability)  
	{
		
		setSprite(sprite);
		setPermeability(permeability);
		loadImage(imageI);
		setImagei(imageI); 
		
	}
	/**
	 * This method get the appropriate picture with the link to the library.
	 * @param imageI
	 */
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
	
	/**
	 * The getter of Image
	 * @return Image
	 */
	public  Image getImage() {
		return image;
	}
	/**
	 * The setter of Image
	 * @param imagen
	 */
	public void setImage(Image imagen) {
		this.image = imagen;
	}
	/**
	 * The getter of Sprite
	 * @return sprite
	 */
	public char getSprite() 
	{
		return sprite;
	}
	/**
	 * The setter of Sprite
	 * @param sprite
	 */
	public void setSprite(char sprite) 
	{
		this.sprite = sprite;
	}
	/**
	 * The getter of Permeability
	 * @return permeability
	 */
	public Permeability getPermeability() {
		return permeability ;
	}
	/**
	 * The setter of Permeability
	 * @param permeability
	 */
	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}
	/**
	 * The getter of Imagei (index of Image)
	 * @return imagei
	 */
	public String getImagei() {
		return imagei;
	}
	/**
	 * The setter of Imagei (index of Image)
	 * @param imagei
	 */
	public void setImagei(String imagei) {
		this.imagei = imagei;
	}		

	
}