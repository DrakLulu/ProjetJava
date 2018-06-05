package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import model.IDemons;
import model.IElement;
import model.IModel;


public class Panel extends JPanel implements Observer, IPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	Image imagei = null;
	

	private IModel model;
	
	public Panel(IModel model) {
		this.model = model;
		((Observable) this.model).addObserver(this);
	
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 700);
		int y = 0;
		int x = 0;
		
		IElement[][] tbl = model.getTable();
		for(IElement[] te : tbl) {
			for(IElement t: te) {
				imagei = t.getImage();
				if(imagei != null)
				g.drawImage(imagei, (x*32), (y*32), this);
				x++;
			}
			y++;
			x=0;
		} 
		
		IDemons [] demon = model.getDemon();
		
		for(IDemons dem : demon) {
			if(dem == null) continue; 
			imagei = dem.getImage();
			if(imagei != null)
			g.drawImage(imagei, (dem.getY()*32), (dem.getX()*32), this);
		}
	
		x = model.getLorann().getX();
		y = model.getLorann().getY();
		imagei = model.getLorann().getImage();
		g.drawImage(imagei, y*32, x*32, this);
		
		
		if (model.isSpellexist() == true) {
			x = model.getSpell().getX();
			y =	model.getSpell().getY();	
			imagei = model.getSpell().getImage();
			g.drawImage(imagei, x*32, y*32, this);
		}
	
	}
}
