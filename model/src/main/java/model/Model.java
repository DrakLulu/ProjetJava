package model;

import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;

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
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class Model {

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


		public Hero getLorann() {
			return lorann;
		}


		public void setLorann(Hero lorann) {
			this.lorann = lorann;
		}


		public Demons[] getDemon() {
			return demon;
		}


		public void setDemon(Demons[] demon) {
			this.demon = demon;
		}


		public static Element[][] getTable() {
			return table;
		}


		public void setTable(Element[][] table) {
			this.table = table;
		}


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
	}

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleById(int)
     
    @Override
    public Example getExampleById(final int id) throws SQLException {
        return ExampleDAO.getExampleById(id);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getExampleByName(java.lang.String)
     
    @Override
    public Example getExampleByName(final String name) throws SQLException {
        return ExampleDAO.getExampleByName(name);
    }

    /*
     * (non-Javadoc)
     * @see model.IModel#getAllExamples()
     
    @Override
    public List<Example> getAllExamples() throws SQLException {
        return ExampleDAO.getAllExamples();
    }*/


