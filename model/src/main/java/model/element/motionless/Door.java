package model.element.motionless;
import model.element.Permeability;

public class Door extends State
{
	private static char charDoor ='Y';
	private static String close="gate_closed.png";
	private static String open="gate_open.png";
	
	
	private static Permeability perm= Permeability.Blocking; 
	private static String doorstate = close; 
	
	
	public Door() 
	{
		super(charDoor, perm, doorstate);		
	}

	
//	
	public void changestate () 
	{
		if (this.state= true)
		{
			setPerm(Permeability.Blocking);
			doorstate= close; 
		}
		else
		{
			setPerm(Permeability.Penetrable);
			doorstate= open;
			
		}
	}

	
	

//getter and setter of perm
	public static Permeability getPerm() {
		return perm;
	}

	public static void setPerm(Permeability perm) {
		Door.perm = perm;
	}

}
