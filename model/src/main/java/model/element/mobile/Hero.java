package model.element.mobile;

import model.element.Permeability;

public class Hero extends MotionElement
{
	private static char Hero ='@';
	private static String LorannU="lorann_u.png";
	private static String LorannD="lorann_b.png";
	private static String LorannL="lorann_l.png";
	private static String LorannR="lorann_r.png";
	
	
	public static String LorannState= LorannD;
	
	public Hero(int x, int y) {
		super(Hero, Permeability.Penetrable, LorannState);
		setX(x);
		setY(y);
	}




}
