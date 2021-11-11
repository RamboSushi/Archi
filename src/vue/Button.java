package vue;

import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import modele.*;

public class Button extends JButton {
	
	private static final Dimension dim = new Dimension(50, 20);
	
	private UE ue;
	
	public Button(UE ue) {
		
		this.ue=ue;

		setContentAreaFilled(false);
		setFocusPainted(true);
		setBorderPainted(false);
		setPreferredSize(dim);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.gray);
		g.fillRoundRect(0, 0, dim.width, dim.height, 10, 10);
		g.setColor(Color.black);
		g.drawString(this.ue.getNomination(),0,10);
	}
}
