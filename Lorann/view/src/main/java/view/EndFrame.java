package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public class EndFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pan = new JPanel();
	private JLabel lab = new JLabel();
	private Controller controller; 
	
	public EndFrame(Controller controller) {
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
