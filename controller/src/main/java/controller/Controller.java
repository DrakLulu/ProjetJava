package controller;

import java.awt.Image;

import model.Model;
import model.ThreadSpell;
import model.element.Element;
import model.element.Permeability;
import model.element.motionless.Crystal;
import model.element.motionless.Nothing;
import model.element.motionless.Open_Door;
import model.element.motionless.Purse;
import model.element.motion.Demons;
import model.element.motion.Spell;


public abstract class Controller {
	
	private Model model;
	private Element[][] tbl; 
	private Demons [] dem; 
	private UserOrder userOrder;
	private int score = 0; 

	public int lorannX;
	public int lorannY; 
	public int DoorX;
	public int DoorY;
	boolean state = false;
	
	public Controller(Model model){
		this.model= model;
	}

	
	public void play() 
	{
		setUserOrder(UserOrder.NOMOVE);
		
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
				switch(className) 
				{
					case '1': 
						tbl[lorannX][lorannY].setState(state);
						tbl[lorannX][lorannY] = new Nothing();
						setScore(score+100);
						break; 
				
					
					case 'Q':
						tbl[lorannX][lorannY].setState(state);
						tbl[lorannX][lorannY] = new Nothing();
						tbl[DoorY][DoorX] = new Open_Door();
						this.model.updatedModel();
						setScore(score+50);
						break; 
					
					default: 
						break; 
				} 
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
	
	public void ifDead() {
		int a ,b; 
		for(Demons dem : model.getDemon() ) {
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
	
	public void IA() 
    {
		for(Demons m : model.getDemon()) {
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
			model.setSpellexist(true);
			Thread threadSpell = new Thread(new ThreadSpell(this, model));
			threadSpell.run();
			//throwSpell();
			break;
			
		default: 
			break; 
			
		}
		setUserOrder(UserOrder.NOMOVE);
	}
	

	
//Getter and Setter
	public UserOrder getUserOrder() 
	{
		return userOrder;
	}
	public void setUserOrder(UserOrder userOrder) 
	{
		this.userOrder = userOrder;
	}
	
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	
	public int getLorannX() {
		return lorannX;
	}
	public void setLorannX(int lorannX) {
		this.lorannX = lorannX;
	}


	public int getLorannY() {
		return lorannY;
	}
	public void setLorannY(int lorannY) {
		this.lorannY = lorannY;
	}


	public Element[][] getTbl() {
		return tbl;
	}
	public void setTbl(Element[][] tbl) {
		this.tbl = tbl;
	}

	
	public int getDoorX() {
		return DoorX;
	}
	public void setDoorX(int xDoor) {
		this.DoorX = xDoor;
	}

	
	public int getDoorY() {
		return DoorY;
	}
	public void setDoorY(int yDoor) {
		this.DoorY = yDoor;
	}
}