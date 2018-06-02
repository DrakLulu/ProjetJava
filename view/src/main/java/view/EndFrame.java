package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Controller;

public class EndFrame extends JFrame {

	Controller controller; 
	
	public EndFrame(Controller controller) {
		this.controller = controller;
		this.setTitle("Votre score");
		this.setBounds(0, 0, 200, 100);
		this.setLocationRelativeTo(null);
		JPanel pan = new JPanel();
		JLabel lab = new JLabel();
		pan.setBackground(Color.GRAY);
		this.setContentPane(pan);
		pan.add(lab); 
		lab.setText("Score: " + controller.getScore());
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		
		
	}

}