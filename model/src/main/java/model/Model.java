package model;

import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import view.IView;
import model.dao.ExampleDAO;
import model.dao.LorannBDDConnector;
import model.element.Element;
import model.element.mobile.Arrbarr;
import model.element.mobile.Cargyv;
import model.element.mobile.Demons;
import model.element.mobile.Hero;
import model.element.mobile.Kyracj;
import model.element.mobile.Maarcg;
import model.element.motionless.BallBone;
import model.element.motionless.Crystal;
import model.element.motionless.Door;
import model.element.motionless.HBone;
import model.element.motionless.Nothing;
import model.element.motionless.Purse;
import model.element.motionless.VBone;


/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Groupe 4, Louka, Guillaume & Charlotte
 * @version 1.0
 */
public final class Model implements IModel, IView {

    /**
     * Instantiates a new model facade.
     */
		private Hero lorann; 
		private Demons[] demon = new Demons[4];
		private static Element[][] table;
		String map;
		public Model() 
		{
			LorannBDDConnector daoConnector =  new LorannBDDConnector(); 
			String lol = daoConnector.start();
			table = mapping(lol);
			// TODO Auto-generated constructor stub
		}
		/*
		 *Create a table of element that represent the map.
		 *
		 *@param map
		 *			the represented string of the map.
		 */
		
		
		
		/* (non-Javadoc)
		 * @see model.IModel1#mapping(java.lang.String)
		 */
		@Override
		public Element[][] mapping(String map) {
			 this.map= map; 
			Element[][] tbl = new Element[12][20];
			char caract; 
			int y = 0;
			int x = 0;
				for(int i= 0; i < this.map.length(); i ++) 
				{
					caract = map.charAt(i);
					
					switch(caract)
					{
						case 'e':
							tbl[y][x] = new Nothing();
							break;
						
						case 'O': 
							tbl[y][x] = new BallBone();
							break;
								
						case '-':
							tbl[y][x] = new HBone();				
							break;
							
						case 'I':
							tbl[y][x] = new VBone();					
							break;	
							
						case '1':
							tbl[y][x] = new Purse();					
							break;
						
						case '2':
							tbl[y][x] = new Purse();				
							break;
							
						case '3':
							tbl[y][x] = new Purse();
							break;
							
						case '4':
							tbl[y][x] = new Purse();					
							break;	
							
						case 'w':
							tbl[y][x] = new Nothing();						
							break;	
							
						case 'A':
							tbl[y][x] = new Nothing();
							demon[0] = new Kyracj(y,x);
							break;
							
						case 'B':
							tbl[y][x] = new Nothing();
							demon[1] = new Arrbarr(y,x);						
							break;
							
						case 'C':
							tbl[y][x] = new Nothing();
							demon[2] = new Maarcg(y,x);
							break;
							
						case 'D':
							tbl[y][x] = new Nothing();
							demon[3] = new Cargyv(y,x);
							break;
							
						case 'Q':
							tbl[y][x] = new Crystal();					
							break;
						
						case 'Y':
							tbl[y][x] = new Door();					
							break;
						
						case '@':
							tbl[y][x] = new Nothing();
							lorann = new Hero(y,x);
							break;
							
						case '#':
							tbl[y][x]= new Nothing();
							break;
							
						case '+':
							tbl[y][x]= new Nothing();
							break;	
						
						case ';':
							y++;
							x = -1;
							break;
							
						default:
							tbl[y][x] = new Nothing();					
							break;
					}
					x++;
					
					
				}

				  int l =0;
			      int h =0;
			        
			       for (l = 0; l<12; l++) {
			        	for(h = 0; h <20; h++) {
			        		System.out.print(tbl[l][h].getSprite());
			        	}
			        	System.out.println("");
			        }
				return tbl;
		}


		/* (non-Javadoc)
		 * @see model.IModel1#getLorann()
		 */
		@Override
		public Hero getLorann() {
			return lorann;
		}


		/* (non-Javadoc)
		 * @see model.IModel1#setLorann(model.element.mobile.Hero)
		 */
		@Override
		public void setLorann(Hero lorann) {
			this.lorann = lorann;
		}


		/* (non-Javadoc)
		 * @see model.IModel1#getDemon()
		 */
		@Override
		public Demons[] getDemon() {
			return demon;
		}


		/* (non-Javadoc)
		 * @see model.IModel1#setDemon(model.element.mobile.Demons[])
		 */
		@Override
		public void setDemon(Demons[] demon) {
			this.demon = demon;
		}


		public static Element[][] getTable() {
			return table;
		}


		/* (non-Javadoc)
		 * @see model.IModel1#setTable(model.element.Element[][])
		 */
		@Override
		public void setTable(Element[][] table) {
			this.table = table;
		}


		/* (non-Javadoc)
		 * @see model.IModel1#getImage(int, int)
		 */
		@Override
		public Image getImage(int x, int y) {
			Element [][] tbl = getTable();
			
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



		
		
		/* 
		 /////To Cast the Spell, WIP//////
		 
		 public void throwSpell() {
		// Spell cast in front of Lorann, from right to left, range of 4
		int y = getLorann().getY(); 
		int x = getLorann().getX();
		this.setSpellexist(true);
		System.out.println("Spell cast!");
		for (int i=1; i<5; i++) {
			for(int j =y; j<(y+5); j++) {				
				if(table[y][x+1].getPermeability() != Permeability.Blocking) {
					spell = new Spell(y, x+1, "Image"+j+"");
					System.out.println("Image"+j+"");
					System.out.println(y +", "+ x+1);
					updatedModel();
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					} 
				else break; 
			}
		}
		this.setSpellexist(false);	
	}
*/
		
}



