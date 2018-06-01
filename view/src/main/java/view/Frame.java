package view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

import controller.IController;
import model.IModel;


public class Frame extends JFrame implements KeyListener, IView {
	
		private Panel panel;
		private int OrdertoPerform;
		private IController controller; 
		
		
		public Frame(IModel model, IController controller) {
			
			this.controller = controller;
			this.setTitle("jeu");
			this.setSize(700,450);
			this.setVisible(true);
			this.setLocationRelativeTo(null);
			this.setBackground(Color.BLACK);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			Panel panel = new Panel(model);
			this.setContentPane(panel);
			addKeyListener(this);
			
		}
		
		
		@Override
		public void keyPressed(KeyEvent key){
			switch (key.getKeyCode())
			{
			case KeyEvent.VK_UP:
				controller.getUserOderLorann(UserOrder.LEFT);
				break;
			
			case KeyEvent.VK_LEFT:
				controller.getUserOderLorann(UserOrder.DOWN);
				
				break;
			
			case KeyEvent.VK_RIGHT:			
				controller.getUserOderLorann(UserOrder.UP);
				break;
			
			case KeyEvent.VK_DOWN:

				controller.getUserOderLorann(UserOrder.RIGHT);
				break;
			
			case KeyEvent.VK_SPACE:
				controller.getUserOderLorann(UserOrder.SPACE);
				break;
			default: 
				break;
				
			}
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
		
	}