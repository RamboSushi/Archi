package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import modele.*;

public class CreneauTab {

	private JPanel creneauPanel;
	
	private JButton ajouter = new JButton("ajouter un creneau");
	private JButton supprimer = new JButton("supprimer un creneau");
	private JButton load = new JButton("Init Load");
	private JLabel label = new JLabel();
	private String[] option_days  = { "01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31" };
	private String[] option_months = { "01","02","03","04","05","06","07","08","09","10","11","12"};
	private String[] option_hours = { "00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24" };
	private String[] option_minutes = { "00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60" };
	private JComboBox box_days = new JComboBox(option_days);
	private JComboBox box_months = new JComboBox(option_months);
	private JComboBox box_hour_begin = new JComboBox(option_hours);
	private JComboBox box_hour_end = new JComboBox(option_hours);
	private JComboBox box_minute_begin = new JComboBox(option_minutes);
	private JComboBox box_minute_end = new JComboBox(option_minutes);
	private int year = ZonedDateTime.now(ZoneId.of("CET")).getYear();
	private SpinnerModel value =  new SpinnerNumberModel(year,year-10,year+10,1);  
	private JSpinner spinner_years = new JSpinner(value);
	private ArrayList<String> dataCreneauList = new ArrayList<String>();
	private ArrayList<Creneau> dbCreneau = new ArrayList<Creneau>();
	private JScrollPane scrollListCreneau = new JScrollPane();
	private JList listCreneau = new JList(dataCreneauList.toArray(new String[dataCreneauList.size()]));
	
	private GridBagConstraints c = new GridBagConstraints();
	
	public CreneauTab(JPanel panel) {
		this.creneauPanel=panel;
		this.creneauPanel.setLayout(new GridBagLayout());
		initComponent();
	}
	
	private void initComponent() {
		creneauPanel.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.HORIZONTAL;
		
		initComponentJButton();
		initComponentJList();
		
	}
	
	private void initComponentJButton() {
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
		label = new JLabel("Ann�e :");
		c.gridy = 5;
		creneauPanel.add(label, c);
		c.gridy = 6;
		JFormattedTextField spin=((JSpinner.DefaultEditor)spinner_years.getEditor()).getTextField();
		spin.setEditable(false);
		creneauPanel.add(spinner_years, c);
		label = new JLabel("Heure d�but :");
		c.gridy = 7;
		creneauPanel.add(label, c);
		c.gridy = 8;
		creneauPanel.add(box_hour_begin, c);
		label = new JLabel("Heure fin :");
		c.gridy = 9;
		creneauPanel.add(label, c);
		c.gridy = 10;
		creneauPanel.add(box_hour_end, c);
		label = new JLabel("Minute d�but :");
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
	
	public void initComponentJList() {
		c.fill = GridBagConstraints.HORIZONTAL;
		listCreneau = new JList(dataCreneauList.toArray(new String[dataCreneauList.size()]));
		scrollListCreneau.setViewportView(listCreneau);
		listCreneau.setLayoutOrientation(JList.VERTICAL);
		listCreneau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if (dataCreneauList.size() != 0) {
			listCreneau.setSelectedIndex(0);
		}
		c.gridx = 0;
		c.gridy = 12;
		creneauPanel.add(scrollListCreneau, c);
	}
	
	public JButton loadCreneau() {
		return this.load;
	}
	
	public void printCreneau(Creneau creneau) {
        JOptionPane.showMessageDialog(creneauPanel, creneau.toString(), "Creneau Ajout�", 0);
    }
	public void printError(String msg) {
        JOptionPane.showMessageDialog(creneauPanel, msg, "Error", 0);
    }
	
	public String getDayCreneau() {
		return this.box_days.getSelectedItem().toString();
	}
	public String getMonthCreneau() {
		return this.box_months.getSelectedItem().toString();
	}
	public String getYearCreneau() {
		return this.spinner_years.getValue().toString();
	}
	public String getHourBeginCreneau() {
		return this.box_hour_begin.getSelectedItem().toString();
	}
	public String getHourEndCreneau() {
		return this.box_hour_end.getSelectedItem().toString();
	}
	public String getMinuteBeginCreneau() {
		return this.box_minute_begin.getSelectedItem().toString();
	}
	public String getMinuteEndCreneau() {
		return this.box_minute_end.getSelectedItem().toString();
	}
	public String getCreneau() {
		return this.listCreneau.getSelectedValue().toString();
	}
	public int getCreneauLenght() {
		return this.dataCreneauList.size();
	}
	public ArrayList<String> getDataCreneauList() {
		return this.dataCreneauList;
	}
	public ArrayList<Creneau> getDBCreneauList() {
		return this.dbCreneau;
	}
	
	public JButton addCreneau() {
		return this.ajouter;
	}
	public JButton deleteCreneau() {
		return this.supprimer;
	}
}
