package model;

import java.awt.Image;
import java.sql.SQLException;
import java.util.List;


/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

    public IElement[][] mapping (String map);
	
	public void updatedModel();
	
	
	public IHero getLorann();
	public void setLorann(IHero hero);
	
	public ISpell getSpell();
	public void setSpell(ISpell spell);
	
	public IDemons[] getDemon();
	public void setDemon(IDemons[] demon);
	
	public IElement[][] getTable();
	public void setTable(IElement[][] table, int x, int y);
	
	public Image getImage(int x, int y);
	
	public boolean isSpellexist();
	public void setSpellexist(boolean spellexist);
	
	public int getxDoor();
	public void setxDoor(int xDoor);
	
	public int getyDoor();
	public void setyDoor(int yDoor);
	
	
	
	
	/**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    /*Example getExampleById(int id) throws SQLException;*/

    /**
     * Gets the example by name.
     *
     * @param name
     *            the name
     * @return the example by name
     * @throws SQLException
     *             the SQL exception
     */
	/*Example getExampleByName(String name) throws SQLException;*/

    /**
     * Gets the all examples.
     *
     * @return the all examples
     * @throws SQLException
     *             the SQL exception
     */
	/*List<Example> getAllExamples() throws SQLException;*/
}
