package model;

import java.awt.Image;
import java.sql.SQLException;
import java.util.List;


/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Groupe 4, Louka, Guillaume & Charlotte
 * @version 1.0
 */
public interface IModel {

	Element[][] mapping(String map);

	Hero getLorann();

	void setLorann(Hero lorann);

	Demons[] getDemon();

	void setDemon(Demons[] demon);

	void setTable(Element[][] table);

	Image getImage(int x, int y);

}
