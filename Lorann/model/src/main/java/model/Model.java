package model;

import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

import model.dao.DAOConnector;
import model.element.Element;
import model.element.motion.Arrbarr;
import model.element.motion.Cargyv;
import model.element.motion.Demons;
import model.element.motion.Kyracj;
import model.element.motion.Hero;
import model.element.motion.Maarcg;
import model.element.motion.Spell;
import model.element.motionless.BallBone;
import model.element.motionless.Crystal;
import model.element.motionless.Closed_Door;
import model.element.motionless.HBone;
import model.element.motionless.Nothing;
import model.element.motionless.Purse;
import model.element.motionless.VBone;

/**
 * The model hierarchizes the different classes that will be used in the programm :
 * <l>Hero</l>
 * <l>Spell</l>
 * <l>Demons</l>
 * <l>The table</l>
 * <l>Door</l>
 * 
 */
public class Model extends Observable implements IModel{

	private IHero hero;
	private ISpell spell; 
	private IDemons[] demon = new Demons[4];
	private IElement[][] table;
	private boolean Spellexist = false;
	private int xDoor;
	private int yDoor;
	
	/**
	 * Builder of Model.
	 * Instantiate the connection at the database with DAOConnector.
	 * String 
	 * 
	 */
	public Model() {
		DAOConnector daoConnector =  new DAOConnector(); 
		String mapS = daoConnector.start();
		table = mapping(mapS);
	}
	
	/*
	 *Create a table of element that represent the map.
	 *All the letters wrote in the database are replaced by the sprites of the different elements.
	 *
	 *@param map
	 *			the represented string of the map.
	 */
	public IElement[][] mapping(String map) {
		
		table = new Element[12][20];
		char caract; 
		int y = 0;
		int x = 0;
			for(int i= 0; i < map.length(); i ++) 
			{
				caract = map.charAt(i);
				
				switch(caract)
				{
					case 'O': 
						table[y][x] = new BallBone();
						break;		
					case '-':
						table[y][x] = new HBone();				
						break;						
					case 'I':
						table[y][x] = new VBone();					
						break;							
					case '1':
						table[y][x] = new Purse();					
						break;					
					case '2':
						table[y][x] = new Purse();				
						break;						
					case '3':
						table[y][x] = new Purse();
						break;						
					case '4':
						table[y][x] = new Purse();					
						break;							
					case 'w':
						table[y][x] = new Nothing();						
						break;							
					case 'A':
						table[y][x] = new Nothing();
						demon[0] = new Kyracj(y,x);
						break;						
					case 'B':
						table[y][x] = new Nothing();
						demon[1] = new Arrbarr(y,x);						
						break;						
					case 'C':
						table[y][x] = new Nothing();
						demon[2] = new Maarcg(y,x);
						break;						
					case 'D':
						table[y][x] = new Nothing();
						demon[3] = new Cargyv(y,x);
						break;						
					case 'Q':
						table[y][x] = new Crystal();					
						break;					
					case 'Y':
						table[y][x] = new Closed_Door();
						setxDoor(x);
						setyDoor(y); 
						break;					
					case '@':
						table[y][x] = new Nothing();
						hero = new Hero(y,x);
						break;						
					case '#':
						table[y][x]= new Nothing();
						break;						
					case '+':
						table[y][x]= new Nothing();
						break;						
					case ';':
						y++;
						x = -1;
						break;						
					case 'e':
						table[y][x] = new Nothing();
						break;						
					default:
						table[y][x] = new Nothing();					
						break;
				}
				x++;
			}

			  int l =0;
		      int h =0;
		       for (l = 0; l<12; l++) {
		        	for(h = 0; h <20; h++) {
		        		System.out.print(table[l][h].getSprite());
		        	}
		        	System.out.println("");
		        }
			return table;
	}
	
	/**
	 * This method allow the link between the Observable and the Observer to repaint the level regularly.
	 * 
	 * @see java;util.Observable
	 */
	public void updatedModel() {
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * The getter of Hero.
	 * @return hero
	 */
	public IHero getLorann() {
		return hero;
		
	}
	/**
	 * The setter of Hero.
	 * @param hero
	 */
	public void setLorann(IHero hero) {
		this.hero = hero;
	}

	/**
	 * The getter of Spell.
	 * @return spell
	 */
	public ISpell getSpell() {
		return spell;
	}
	/**
	 * The setter of Spell.
	 * @param spell
	 */
	public void setSpell(ISpell spell) {
		this.spell = spell;
	}

	/**
	 * The getter of Demons.
	 * @return demon
	 */
	
	public IDemons[] getDemon() {
		return demon;
	}
	/**
	 * The setter of Demons.
	 * @param demon
	 */
	public void setDemon(IDemons[] demon) {
		this.demon = demon;
	}

	/**
	 * The getter of Element.
	 * @return table
	 */
	public IElement[][] getTable() {
		return table;
	}
	/**
	 * The setter of Element.
	 * @param table
	 * @param x
	 * @param y
	 */
	public void setTable(IElement[][] table, int x, int y) {
		this.table[y][x] = new Nothing();
	}

	/**
	 * This method print the sprite of an element in the table.
	 * @param x
	 * @param y
	 * @return
	 */
	public Image getImage(int x, int y) {
		IElement [][] tbl = getTable();
		
		  int l =0;
	      int h =0;
	        
	       for (l = 0; l<12; l++) {
	        	for(h = 0; h <20; h++) {
	        		System.out.print(tbl[l][h].getSprite());
	        	}
	        	System.out.println("");
	        }
		
		if (y < tbl.length && y > -1 && x > -1 && x < tbl[y].length) {
		return getTable()[x][y].getImage();
		}
		else {
			return null; 
		}
	}

	/**
	 * The boolean existence of the Spell (getter).
	 * @return Spellexist
	 */
	public boolean isSpellexist() {
		return Spellexist;
	}
	/**
	 * The boolean existence of the Spell (setter).
	 * @param spellexist
	 */
	public void setSpellexist(boolean spellexist) {
		Spellexist = spellexist;
	}

	/**
	 * The getter of the Door (x).
	 * @return xDoor
	 */
	public int getxDoor() {
		return xDoor;
	}
	/**
	 * The setter of the Door (x).
	 * @param xDoor
	 */
	public void setxDoor(int xDoor) {
		this.xDoor = xDoor;
	}

	/**
	 * The getter of the Door (y).
	 * @return yDoor
	 */
	public int getyDoor() {
		return yDoor;
	}
	/**
	 * The setter of the Door (y).
	 * @param yDoor
	 */
	public void setyDoor(int yDoor) {
		this.yDoor = yDoor;
	}

}