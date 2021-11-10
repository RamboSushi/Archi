package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import modele.*;

public class CreneauTab {
	

	private JPanel creneauPanel;
	
	private JTextArea text = new JTextArea();
	
	JButton ajouter = new JButton("ajouter un creneau");
	JButton supprimer = new JButton("supprimer un creneau");
	JLabel label = new JLabel();
	String[] option_days  = { "01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31" };
	String[] option_months = { "01","02","03","04","05","06","07","08","09","10","11","12"};
	String[] option_hours = { "00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24" };
	String[] option_minutes = { "00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60" };
	JComboBox box_days = new JComboBox(option_days);
	JComboBox box_months = new JComboBox(option_months);
	JComboBox box_hour_begin = new JComboBox(option_hours);
	JComboBox box_hour_end = new JComboBox(option_hours);
	JComboBox box_minute_begin = new JComboBox(option_minutes);
	JComboBox box_minute_end = new JComboBox(option_minutes);
	int year = ZonedDateTime.now(ZoneId.of("CET")).getYear();
	SpinnerModel value =  new SpinnerNumberModel(year,year-10,year+10,1);  
	JSpinner spinner_year = new JSpinner(value);
	
	
	public CreneauTab(JPanel panel) {
		this.creneauPanel=panel;
		this.creneauPanel.setLayout(new GridBagLayout());
		
		initComponent();
	}
	
	private void initComponent() {
		//creneauPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		creneauPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		label = new JLabel("Jour :");
		c.gridx = 0;
		c.gridy = 1;
		creneauPanel.add(label, c);
		c.gridy = 2;
		creneauPanel.add(box_days, c);
		label = new JLabel("Mois :");
		c.gridy = 3;
		creneauPanel.add(label, c);
		c.gridy = 4;
		creneauPanel.add(box_months, c);
		label = new JLabel("Année :");
		c.gridy = 5;
		creneauPanel.add(label, c);
		c.gridy = 6;
		JFormattedTextField spin=((JSpinner.DefaultEditor)spinner_year.getEditor()).getTextField();
		spin.setEditable(false);
		creneauPanel.add(spinner_year, c);
		label = new JLabel("Heure début :");
		c.gridy = 7;
		creneauPanel.add(label, c);
		c.gridy = 8;
		creneauPanel.add(box_hour_begin, c);
		label = new JLabel("Heure fin :");
		c.gridy = 9;
		creneauPanel.add(label, c);
		c.gridy = 10;
		creneauPanel.add(box_hour_end, c);
		label = new JLabel("Minute début :");
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.gridx = 2;
		c.gridy = 7;
		creneauPanel.add(label, c);
		c.gridy = 8;
		creneauPanel.add(box_minute_begin, c);
		label = new JLabel("Minute fin :");
		c.gridy = 9;
		creneauPanel.add(label, c);
		c.gridy = 10;
		creneauPanel.add(box_minute_end, c);
		c.weighty = 0.1;   //request any extra vertical space
		c.gridx = 0;
		c.gridy = 11;
		creneauPanel.add(ajouter, c);
		c.gridx = 2;
		creneauPanel.add(supprimer, c);
	}
	
	public void printCreneau(Creneau creneau) {
        JOptionPane.showMessageDialog(creneauPanel, creneau.toString(), "Creneau Ajouté", 0);
    }
	
	
	
	public JButton AddCreneau() {
		return this.ajouter;
	}
	public JButton DeleteCreneau() {
		return this.supprimer;
	}

	
}
