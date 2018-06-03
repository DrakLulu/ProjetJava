package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import controller.UserOrder;
import model.Model;
import model.ThreadSpell;

public class Frame extends JFrame implements KeyListener {
// Controller 
	Panel panel;
	private int OrdertoPerform;
	private Controller controller; 
	JLabel lab = new JLabel();
	
	public Frame(Model model, Controller controller) {
		Panel panel = new Panel(model);
		this.controller = controller;
		
		this.setTitle("jeu");
		this.setSize(700,450);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.setLayout(new BorderLayout());
		lab.setForeground(Color.white);
		lab.setText("Score: " + controller.getScore());
		panel.add(lab,BorderLayout.SOUTH);
		this.setContentPane(panel);
		addKeyListener(this);
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent key){
		lab.setText("Score: " + controller.getScore());
		switch (key.getKeyCode())
		{
		case KeyEvent.VK_UP:
			controller.setUserOrder(UserOrder.LEFT);
			break;
		
		case KeyEvent.VK_LEFT:
			controller.setUserOrder(UserOrder.DOWN);
			
			break;
		
		case KeyEvent.VK_RIGHT:			
			controller.setUserOrder(UserOrder.UP);
			break;
		
		case KeyEvent.VK_DOWN:

			controller.setUserOrder(UserOrder.RIGHT);
			break;
		
		case KeyEvent.VK_SPACE:
			controller.setUserOrder(UserOrder.SPACE);
			break;
		default: 
			break;
			
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		lab.setText("Score: " + controller.getScore());
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}