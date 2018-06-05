package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.IController;

public class EndFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel pan; 
	private JLabel lab;
	private IController controller; 
	/**
	 * This method is called at the end of the game when the player win or lose.
	 * The score obtained is displayed in a new window.
	 * @param controller
	 */
	public EndFrame(IController controller) {
		pan = new JPanel();
		lab = new JLabel();
		this.controller = controller;
		this.setTitle("Votre score");
		this.setBounds(0, 0, 200, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		pan.setBackground(Color.GRAY);
		pan.add(lab); 
		lab.setText("Score: " + controller.getScore());
		this.setContentPane(pan);
		this.setVisible(true);
		
		
		
		
	}

}
