package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

import model.IModel;

public class Panel extends JPanel implements Observer{

	private Image imagei = null;
	private IModel model;
	
	public Panel(IModel model) {
		
		this.model = model;
		this.model.addObserver(this);
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
		
		Element[][] tbl = model.getTable();
		for(Element[] te : tbl) {
			for(Element t: te) {
				imagei = t.getImage();
				if(imagei != null)
				g.drawImage(imagei, (x*32), (y*32), this);
				x++;
			}
			y++;
			x=0;
		} 
		
		Demon [] demon = model.getDemon();
		
		for(Demon dem : demon) {
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
