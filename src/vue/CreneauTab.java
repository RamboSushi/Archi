package vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import modele.*;

public class CreneauTab {

	private JPanel creneauPanel;
	
	public CreneauTab(JPanel panel) {
		this.creneauPanel=panel;
		
		//panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.creneauPanel.setLayout(new GridBagLayout());
		
		initComponent();
	}
	
	private void initComponent() {
		JButton button;
		JLabel label;
		JComboBox box;
		JSpinner spinner;
		//creneauPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		creneauPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		String[] option_days  = { "01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31" };
		label = new JLabel("Jour :");
		c.gridx = 0;
		c.gridy = 1;
		creneauPanel.add(label, c);
		box = new JComboBox(option_days);
		c.gridy = 2;
		creneauPanel.add(box, c);

		String[] option_months = { "01","02","03","04","05","06","07","08","09","10","11","12"};
		label = new JLabel("Mois :");
		c.gridx = 0;
		c.gridy = 3;
		creneauPanel.add(label, c);
		box = new JComboBox(option_months);
		c.gridy = 4;
		creneauPanel.add(box, c);
		
		SpinnerModel value =  new SpinnerNumberModel(2020,0,2022,1);  
		label = new JLabel("Année :");
		c.gridx = 0;
		c.gridy = 5;
		creneauPanel.add(label, c);
		spinner = new JSpinner(value);
		c.gridy = 6;
		creneauPanel.add(spinner, c);
		
		String[] option_hours = { "00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24" };
		label = new JLabel("Heure début :");
		c.gridx = 0;
		c.gridy = 7;
		creneauPanel.add(label, c);
		box = new JComboBox(option_hours);
		c.gridy = 8;
		creneauPanel.add(box, c);
		label = new JLabel("Heure fin :");
		c.gridy = 9;
		creneauPanel.add(label, c);
		box = new JComboBox(option_hours);
		c.gridy = 10;
		creneauPanel.add(box, c);
		
		String[] option_minutes = { "00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60" };
		label = new JLabel("Minute début :");
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.gridx = 2;
		c.gridy = 7;
		creneauPanel.add(label, c);
		box = new JComboBox(option_minutes);
		c.gridy = 8;
		creneauPanel.add(box, c);
		label = new JLabel("Minute fin :");
		c.gridy = 9;
		creneauPanel.add(label, c);
		box = new JComboBox(option_minutes);
		c.gridy = 10;
		creneauPanel.add(box, c);
		
		button = new JButton("ajouter un creneau");
		c.weighty = 0.1;   //request any extra vertical space
		c.gridx = 0;
		c.gridy = 11;
		creneauPanel.add(button, c);
		button = new JButton("supprimer un creneau");
		c.gridx = 2;
		creneauPanel.add(button, c);
	}
}
