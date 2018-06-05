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

public class Controller  implements IController
{
	
	private IModel model;
	private IElement[][] tbl; 
	private UserOrder userOrder;
	private int score = 0; 

	public int lorannX;
	public int lorannY; 
	public int DoorX;
	public int DoorY;
	boolean state = false;
	
	public Controller(IModel model){
		this.model= model;
	}

	@Override
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
	
	@Override
	public void throwSpell() {

		Spell spell = new Spell(lorannX, lorannY, "fireball_1.png");
		model.setSpell(spell); 
		model.setSpellexist(true);
		String dir = model.getLorann().getImagei();
		model.getSpell().setdir(dir);
		moveSpell();
	}
	
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

	
//Getter and Setter
	@Override
	public UserOrder getUserOrder() 
	{
		return userOrder;
	}
	@Override
	public void setUserOrder(UserOrder userOrder) 
	{
		this.userOrder = userOrder;
	}
	
	
	@Override
	public int getScore() {
		return score;
	}
	@Override
	public void setScore(int score) {
		this.score = score;
	}

	
	@Override
	public int getLorannX() {
		return lorannX;
	}
	@Override
	public void setLorannX(int lorannX) {
		this.lorannX = lorannX;
	}

	
	@Override
	public int getLorannY() {
		return lorannY;
	}
	@Override
	public void setLorannY(int lorannY) {
		this.lorannY = lorannY;
	}

	@Override
	public IElement[][] getTbl() {
		return tbl;
	}
	@Override
	public void setTbl(IElement[][] tbl) {
		this.tbl = tbl;
	}

	
	@Override
	public int getDoorX() {
		return DoorX;
	}
	@Override
	public void setDoorX(int xDoor) {
		this.DoorX = xDoor;
	}

	
	@Override
	public int getDoorY() {
		return DoorY;
	}
	@Override
	public void setDoorY(int yDoor) {
		this.DoorY = yDoor;
	}

}



