package main;

import controller.Controller;
import controller.IController;
import model.IModel;
import model.Model;
import view.EndFrame;
import view.Frame;

	 /**
	 * <h1>The Class Main.</h1>
	 *
	 */
 
public abstract class Main {

    /**
     * The main method of the game. It calls the method of the Model, Controller and the Frame plus the EndFrame.
     *
     * @param args
     *            the arguments
     */
	
    public static void main(final String[] args) {
    		IModel model = new Model();
    		IController controller = new Controller(model);
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
