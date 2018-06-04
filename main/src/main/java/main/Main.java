package main;

import java.sql.SQLException;

import view.ViewFacade;
import model.IModel;
import controller.Controller;
import model.Model;
import view.EndFrame;
import view.Frame;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Groupe 4, Louka, Guillaume & Charlotte
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
        /*
         * WIP
         * 
         * 
       
        IModel model = new IModel();
		Controller controller = new Controller(IModel);
		Frame frame = new Frame(IModel, IController);

		
        /*try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }*/
    }

}
