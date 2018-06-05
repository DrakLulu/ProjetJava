package controller;

import model.IDemons;
import model.IElement;
import model.IModel;
import model.Permeability;
import model.element.motionless.Crystal;
import model.element.motionless.Nothing;
import model.element.motionless.Open_Door;
import model.element.motionless.Purse;
import model.element.motion.Spell;

/**
 * <b>Controller is the class that transfer the informations from the view to the model</b>
 * <p>
 * The Controller needs some informations to know how the game elements are :
 * <ul>
 * <li>An Element table to place the objects</li>
 * <li>The objects of the Demons and there locations</li>
 * <li>Lorann and his locations</li>
 * <li>A score used in the view to show the progression</li>
 * <li>The state of the door that changes in the game</li>
 * <li>The movements of the Spell and its uses</li>
 * 
 * </ul>
 * </p>
 * <p>
 * For all of that, the Controller needs also the instructions given by the player that can be RIGHT, LEFT, UP, DOWN, NOMOVE, SPACE.
 * </p>
 * 
 */
public class Controller  implements IController
{
	/**
	 * Variables model.
	 */
	private IModel model;
	/**
	 * The table Element in where every sprite will be located and placed.
	 * 
	 * @see Element(char sprite, String imageI, Permeability permeability)
	 */
	private IElement[][] tbl; 
	/**
	 * The choice of instruction from the player.
	 * 
	 * @see enum UserOrder
	 */
	private UserOrder userOrder;
	/**
	 * The score. It increase for each Purse picked up.
	 */
	private int score = 0; 
	/**
	 * The values of the location in x of the hero in the table Element.
	 */
	public int lorannX;
	/**
	 * The values of the location in y of the hero in the table Element.
	 */
	public int lorannY; 
	/**
	 * The place of the Door. It is the location in x of the end of the level.
	 */
	public int DoorX;
	/**
	 * The place of the Door. It is the location in y of the end of the level.
	 */
	public int DoorY;
	boolean state = false;
	
	/**
	 * Builder Controller
	 * A variable take the value of model.
	 * @param model
	 */
	public Controller(IModel model){
		this.model= model;
	}

	/**
	 * Running game method.
	 * <p>This method is in function while the game is turned on. 
	 * It sends informations to the view to display the good sprites of the objects in function of their positions. 
	 * It also manages to end the game if the player lose or win.
	 * </p>
	 */
	@Override
	public void play() 
	{
		setUserOrder(UserOrder.NOMOVE);
		
		/**
		 * loop of placements of the character and the Door in the table while the game is running.
		 */
		while (model.getLorann().isAlive() != false) {
			
			setLorannY(model.getLorann().getY());
			setLorannX(model.getLorann().getX());
			setTbl(model.getTable());
			setDoorX(model.getxDoor());
			setDoorY(model.getyDoor());
			
			movement();
			IA();
			
			
			
			
			char className = tbl[lorannX][lorannY].getSprite();
			if (className == Purse.Purse || className == Crystal.Crystal ) 
			{
				/**
				 * A switch that make a pickable object displayed or not.
				 * 
				 */
				switch(className) 
				{
					case '1': 
						tbl[lorannX][lorannY] = new Nothing();
						setScore(score+100);
						break; 
				
					
					case 'Q':
						tbl[lorannX][lorannY] = new Nothing();
						tbl[DoorY][DoorX] = new Open_Door();
						this.model.updatedModel();
						setScore(score+50);
						break; 
					
					default: 
						break; 
				} 
			}
			if (model.isSpellexist() ==true ) {
				moveSpell();
				this.model.updatedModel();
			}
		
			ifWin(); 
			ifDead();
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.model.updatedModel();
		}
	}
	/**
	 * Win condition method. 
	 * This method says when the player can win the game by going on the Door.
	 */
	@Override
	public void ifWin() 
	{
		
		if ( DoorY == lorannX && DoorX == lorannY)  
		{
			
			if( tbl[DoorY][DoorX].getSprite() == '$')
			{
				model.getLorann().setAlive(false);
				System.out.println("Well done Lorann! You win!");
				//System.out.println("Your score is: " +score);
			}
			else 
			{
			model.getLorann().setAlive(false);
			System.out.println("Oh no Lorann! You died!"); ///Your score is: +score);
			}
			
		}
	}
	/**
	 * Loose condition method.
	 * This method says when the player loose the game by getting killed by the enemies.
	 */
	@Override
	public void ifDead() {
		int a ,b; 
		for(IDemons dem : model.getDemon() ) {
			if(dem != null) {
				a = dem.getX();
				b = dem.getY();
				if (a == lorannX && b == lorannY ) {
					model.getLorann().setAlive(false);
					System.out.println("Oh no Lorann! You died!");
				}
			}else continue;
		}
		
	}
	/**
	 * The method of how the enemies work.
	 * The Demons move randomly in 5 choice of movements : RIGHT, DOWN, LEFT, UP, NOMOVE.
	 * 
	 */
	@Override
	public void IA() 
    {
		for(IDemons m : model.getDemon()) {
			if(m == null) continue;
			int y = m.getX();
			int x = m.getY();
	        int nombre = (int)(Math.random()*10)%5;
			switch (nombre)
	        {
	            case 1 :
	                if (tbl[y+1][x].getPermeability() != Permeability.Blocking)
	                {
	                m.moveRight();
	                }
	                else 
	                {
	                m.noMove();
	                }
	                break;

	            case 2 :
	                if (tbl[y][x+1].getPermeability() != Permeability.Blocking)
	                {
	                m.moveUp();
	                }
	                else 
	                {
	                m.noMove();
	                }
	                break;

	            case 3 :
	                if (tbl[y-1][x].getPermeability() != Permeability.Blocking)
	                {
	                m.moveLeft();
	                }
	                else 
	                {
	                m.noMove();
	                }
	                break;

	            case 4 :
	                if (tbl[y][x-1].getPermeability() != Permeability.Blocking)
	                {
	                m.moveDown();
	                }
	                else 
	                {
	                m.noMove();
	                }
	                break;

	            case 0 :
	                m.noMove();

	            default: 
	                m.noMove();
	                break;
	        	}
			}
	        
	    }
	/** 
	 * Method of how the moves work.
	 * The movement of the characters is defined here in function of the UserOrder.
	 * 
	 */
	@Override
	public void movement() 
	{
		switch(userOrder) 
		{
		case NOMOVE: 
			model.getLorann().noMove();
			break; 
			
		case RIGHT: 
			
			if ((tbl[lorannX+1][lorannY]).getPermeability() != Permeability.Blocking) 
			{
				model.getLorann().moveRight();
				model.getLorann().loadImage("lorann_b.png");
			}
			else model.getLorann().noMove();
			break;
			
		case LEFT:
			if (tbl[lorannX-1][lorannY].getPermeability() != Permeability.Blocking) {
				model.getLorann().moveLeft();
				model.getLorann().loadImage("lorann_u.png");
			
				}
			model.getLorann().noMove();
			break;
			
		case UP: 
			if (tbl[lorannX][lorannY+1].getPermeability() != Permeability.Blocking) {
				model.getLorann().moveUp();
				model.getLorann().loadImage("lorann_r.png");
				}
			else model.getLorann().noMove();
			break;
			
		case DOWN: 
			if (tbl[lorannX][lorannY-1].getPermeability() != Permeability.Blocking) {
				model.getLorann().moveDown();
				model.getLorann().loadImage("lorann_l.png");
				
				}
			else model.getLorann().noMove();
			break;
		
		case SPACE:
			throwSpell();
			break;
			
		default: 
			break; 
			
		}
		setUserOrder(UserOrder.NOMOVE);
	}
	/**
	 * This method create the spell and launch it.
	 * The direction of the spell is chosen with the actual direction of lorann at launch in the moveSpell method.
	 * 
	 * @see moveSpell().
	 *  
	 */
	@Override
	public void throwSpell() {

		Spell spell = new Spell(lorannX, lorannY, "fireball_1.png");
		model.setSpell(spell); 
		model.setSpellexist(true);
		String dir = model.getLorann().getImagei();
		model.getSpell().setdir(dir);
		moveSpell();
	}
	/**
	 * This method is just a loop that checks if the spell hit the Demons and so if they will disappear.
	 * 
	 */
	private void checkDeathDemon() {
		int x = model.getSpell().getX();
		int y = model.getSpell().getY();
		
		for(int i = 0; i< model.getDemon().length; i++) {
			IDemons d = model.getDemon()[i];
			if(d != null) {
					int a = model.getDemon()[i].getX();
					int b = model.getDemon()[i].getY();
					if(a == x && b== y){
						model.getDemon()[i] = null; 
				}
			}
		}
	}
	/**
	 * moveSpell is a method that make the spell move in the direction of the player's character.
	 * The sprite of the spell change randomly between 5 different to have an effect of blinking of the object.
	 * In function of the direction at start, the spell go straight in this way and when the spell can't continue in the same line, it move in the opposite way.
	 */
	@Override
	public void moveSpell() {
			
			if (model.isSpellexist() ==true ) {
				int x = model.getSpell().getX();
				int y = model.getSpell().getY();
				
				String dir = model.getSpell().getdir();
				
				switch(dir) 
				{
				case "lorann_b.png":
					
	                if (tbl[x+1][y].getPermeability() != Permeability.Blocking && x+1 < 12 && y+1 < 20 && y-1 > -1 && x > -1)
	                {
	                	int nbr = (int)((Math.random()*10%4)+1);
	                	Spell spell = new Spell(x+1, y, "fireball_1.png");
	                	model.setSpell(spell);
	                	model.getSpell().setdir(dir);
	                	model.getSpell().moveDown();
						model.getSpell().loadImage("fireball_"+nbr+".png");
						checkDeathDemon();
							 x = x+1;
	                }else {
		                model.setSpellexist(false);
		                model.setSpell(null);}
		                break;

	            case "lorann_r.png" :
	            
	               if (tbl[x][y+1].getPermeability() != Permeability.Blocking && x+1 < 12 && y+1 < 20 && y-1 > -1 && x > -1)
	                {
	                	 int nbr = (int)((Math.random()*10%4)+1);
	                	 Spell spell = new Spell(x+1, y, "fireball_1.png");
	                	 model.setSpell(spell);
	                	 model.getSpell().setdir(dir);
	                	 model.getSpell().moveRight(); 
						 model.getSpell().loadImage("fireball_"+nbr+".png");
						 checkDeathDemon();
						 y = y+1;
					   }else {
		                model.setSpellexist(false);
		                model.setSpell(null);}
		            	break; 
	            case "lorann_u.png" :
	              if (tbl[x-1][y].getPermeability() != Permeability.Blocking && x+1 < 12 && y+1 < 20 && y-1 > -1 && x > -1)
	                {
	            	    int nbr = (int)((Math.random()*10%4)+1);
	            	    Spell spell = new Spell(x-1, y, "fireball_1.png");
	            	    model.setSpell(spell);
	            	    model.getSpell().setdir(dir);
	            		model.getSpell().moveUp();
						model.getSpell().loadImage("fireball_"+nbr+".png");
						checkDeathDemon();
							x = x-1;
	                }else {
		              	model.setSpellexist(false);
		                model.setSpell(null);} 
		                break;

	            case "lorann_l.png" :
	                if (tbl[x][y-1].getPermeability() != Permeability.Blocking && x+1 < 12 && y+1 < 20 && y-1 > -1 && x > -1)
	                {
		                int nbr = (int)((Math.random()*10%4)+1);
		                Spell spell = new Spell(x, y-1, "fireball_1.png");
		                model.setSpell(spell);
		                model.getSpell().setdir(dir);
		                model.getSpell().moveLeft();
		                model.getSpell().loadImage("fireball_"+nbr+".png");
						checkDeathDemon();
						y = y-1;
	                } else {
		                model.setSpellexist(false);
		                model.setSpell(null);}
		                break; 
	    
				default:
					System.out.println("default");
					model.setSpellexist(false);
					model.setSpell(null);
					break;
			}	
			}
		}

	
	/**
	 * Getter of UserOrder
	 * @return userOrder
	 */
	@Override
	public UserOrder getUserOrder() 
	{
		return userOrder;
	}
	/**
	 * Setter of UserOrder
	 * @param userOrder
	 */
	@Override
	public void setUserOrder(UserOrder userOrder) 
	{
		this.userOrder = userOrder;
	}
	
	/**
	 * getter of Score
	 * @return score
	 */
	@Override
	public int getScore() {
		return score;
	/**
	 * Setter of Score
	 * @param score
	 */
	}
	@Override
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * getter of LorannX
	 * @return lorannX
	 */
	@Override
	public int getLorannX() {
		return lorannX;
	}
	/**
	 * setter of LorannX
	 * @param lorannX
	 */
	@Override
	public void setLorannX(int lorannX) {
		this.lorannX = lorannX;
	}

	/**
	 * getter of LorannY
	 * @return lorannY
	 */
	@Override
	public int getLorannY() {
		return lorannY;
	}
	/**
	 * setter of LorannY
	 * @param lorannY
	 */
	@Override
	public void setLorannY(int lorannY) {
		this.lorannY = lorannY;
	}
	/**
	 * getter of Tbl
	 * @return tbl
	 */
	@Override
	public IElement[][] getTbl() {
		return tbl;
		/**
		 * setter of Tbl
		 * @param tbl
		 */
	}
	@Override
	public void setTbl(IElement[][] tbl) {
		this.tbl = tbl;
	}

	/**
	 * getter of DoorX
	 * @return DoorX
	 */
	
	@Override
	public int getDoorX() {
		return DoorX;
	}
	/**
	 * setter of DoorX
	 * @param DoorX
	 */
	@Override
	public void setDoorX(int xDoor) {
		this.DoorX = xDoor;
	}

	/**
	 * getter of DoorY
	 * @return DoorY
	 */
	@Override
	public int getDoorY() {
		return DoorY;
	/**
	 * setter of DoorY
	 * @param DoorY
	 */
	}
	@Override
	public void setDoorY(int yDoor) {
		this.DoorY = yDoor;
	}

}



