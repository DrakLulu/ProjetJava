package model.element.motionless;
import model.element.Permeability;


public class Crystal extends State 
{
	private static char Crystal ='Q';
	private static String imageName="crystal_ball.png"; 
	
	
	public  Crystal () 
	{
		super(Crystal, Permeability.Penetrable, imageName);
	}
	//get set etat
}
