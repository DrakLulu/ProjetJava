package main;

import java.sql.SQLException;

import view.ViewFacade;
import controller.ControllerFacade;
import model.IModel;
import controller.Controller;
import model.Model;
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
        final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new Model());
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
