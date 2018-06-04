package main;

import java.sql.SQLException;

import controller.Controller;
import controller.ControllerFacade;
import model.Model;
import model.ModelFacade;
import view.EndFrame;
import view.Frame;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
    		Model model = new Model();
    		Controller controller = new Controller(model);
    		Frame frame = new Frame(model, controller);
    	    controller.play();
    	    frame.dispose(); 
    	    EndFrame end = new EndFrame(controller);
    	}
    	
    	
    	
    	
    	

 
    	
    	
    	/*final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());

        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }
*/
}
