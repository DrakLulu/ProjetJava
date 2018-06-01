package controller;

import java.awt.Image;

import model.Demons;
import model.Element;
import model.Hero;
import model.IModel;


public abstract class Controller implements IModel, IController{
	
	private IModel model;
	private Element[][] tbl; 
	private UserOrder userOrder;

	
	public Controller(IModel model){
		this.model= model;
	}
	
	/* (non-Javadoc)
	 * @see controller.IController#getUserOderLorann(controller.UserOrder)
	 */
	@Override
	public UserOrder getUserOderLorann(UserOrder order){
		
		tbl = model.getTable(); 
		
		switch(order) {
		
		case RIGHT: 
			
			if ((tbl[model.getLorann().getX()+1][model.getLorann().getY()]).getPermeability() != Permeability.Blocking) {
				model.getLorann().moveRight();
				}
			else model.getLorann().noMove();
			break;
			
		case LEFT:
			if (tbl[model.getLorann().getX()-1][model.getLorann().getY()].getPermeability() != Permeability.Blocking) {
				model.getLorann().moveLeft();
			
				}
			model.getLorann().noMove();
			break;
			
		case UP: 
			if (tbl[model.getLorann().getX()][model.getLorann().getY()+1].getPermeability() != Permeability.Blocking) {
				model.getLorann().moveUP();
			
				}
			else model.getLorann().noMove();
			break;
			
		case DOWN: 
			if (tbl[model.getLorann().getX()][model.getLorann().getY()-1].getPermeability() != Permeability.Blocking) {
				model.getLorann().moveDown();
				
				}
			else model.getLorann().noMove();
			break;
			
		default: 
			model.throwSpell();
			
			break;
			
		}
		this.model.updatedModel();
		return order;
		
		
	}


	/* (non-Javadoc)
	 * @see controller.Icontroller#setUserOrder(controller.UserOrder)
	 */
	@Override
	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	@Override
	public Element[][] mapping(String map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hero getLorann() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLorann(Hero lorann) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Demons[] getDemon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDemon(Demons[] demon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTable(Element[][] table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getImage(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
}
