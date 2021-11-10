package vue;

import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import modele.*;

public class Button extends JButton {
	
	private static final Dimension dim = new Dimension(300, 100);
	
	public Button(UE ue) {
		setContentAreaFilled(false);
		setFocusPainted(true);
		setBorderPainted(false);
		setPreferredSize(dim);
	}
	
	public void paintComponent(Graphics g){
		g.setColor(Color.black);
		g.fillRoundRect(0, 0, dim.width, dim.height, 20, 20);
		
	}
}
