package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import modele.*;

public class ClasseTab {
	

	private JPanel classePanel;
	
	private JButton ajouter = new JButton("ajouter une classe");
	private JButton supprimer = new JButton("supprimer une classe");
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
	private ArrayList<String> dataClasseList = new ArrayList<String>();
	private ArrayList<Classe> dbClasse = new ArrayList<Classe>();
	private JScrollPane scrollListClasse = new JScrollPane();
	private JList listClasse = new JList(dataClasseList.toArray(new String[dataClasseList.size()]));
	
	
	private GridBagConstraints c = new GridBagConstraints();
	
	public ClasseTab(JPanel panel) {
		this.classePanel=panel;
		this.classePanel.setLayout(new GridBagLayout());
		initComponent();
	}
	
	private void initComponent() {
		classePanel.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.HORIZONTAL;
		
		initComponentJButton();
		initComponentJList();
		
	}
	
	private void initComponentJButton() {
		c.fill = GridBagConstraints.HORIZONTAL;
		label = new JLabel("Jour :");
		c.gridx = 0;
		c.gridy = 1;
		classePanel.add(label, c);
		c.gridy = 2;
		classePanel.add(box_days, c);
		label = new JLabel("Mois :");
		c.gridy = 3;
		classePanel.add(label, c);
		c.gridy = 4;
		classePanel.add(box_months, c);
		label = new JLabel("Année :");
		c.gridy = 5;
		classePanel.add(label, c);
		c.gridy = 6;
		JFormattedTextField spin=((JSpinner.DefaultEditor)spinner_years.getEditor()).getTextField();
		spin.setEditable(false);
		classePanel.add(spinner_years, c);
		label = new JLabel("Heure début :");
		c.gridy = 7;
		classePanel.add(label, c);
		c.gridy = 8;
		classePanel.add(box_hour_begin, c);
		label = new JLabel("Heure fin :");
		c.gridy = 9;
		classePanel.add(label, c);
		c.gridy = 10;
		classePanel.add(box_hour_end, c);
		label = new JLabel("Minute début :");
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.gridx = 2;
		c.gridy = 7;
		classePanel.add(label, c);
		c.gridy = 8;
		classePanel.add(box_minute_begin, c);
		label = new JLabel("Minute fin :");
		c.gridy = 9;
		classePanel.add(label, c);
		c.gridy = 10;
		classePanel.add(box_minute_end, c);
		c.weighty = 0.1;   //request any extra vertical space
		c.gridx = 0;
		c.gridy = 11;
		classePanel.add(ajouter, c);
		c.gridx = 2;
		classePanel.add(supprimer, c);
	}
	
	public void initComponentJList() {
		c.fill = GridBagConstraints.HORIZONTAL;
		listClasse = new JList(dataClasseList.toArray(new String[dataClasseList.size()]));
		scrollListClasse.setViewportView(listClasse);
		listClasse.setLayoutOrientation(JList.VERTICAL);
		listClasse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if (dataClasseList.size() != 0) {
			listClasse.setSelectedIndex(0);
		}
		c.gridx = 0;
		c.gridy = 12;
		classePanel.add(scrollListClasse, c);
	}
	
	public JButton loadClasse() {
		return this.load;
	}
	
	public void printClasse(Classe classe) {
        JOptionPane.showMessageDialog(classePanel, classe.toString(), "Classe Ajouté", 0);
    }
	public void printError(String msg) {
        JOptionPane.showMessageDialog(classePanel, msg, "Error", 0);
    }
	
	public String getDayClasse() {
		return this.box_days.getSelectedItem().toString();
	}
	public String getMonthClasse() {
		return this.box_months.getSelectedItem().toString();
	}
	public String getYearClasse() {
		return this.spinner_years.getValue().toString();
	}
	public String getHourBeginClasse() {
		return this.box_hour_begin.getSelectedItem().toString();
	}
	public String getHourEndClasse() {
		return this.box_hour_end.getSelectedItem().toString();
	}
	public String getMinuteBeginClasse() {
		return this.box_minute_begin.getSelectedItem().toString();
	}
	public String getMinuteEndClasse() {
		return this.box_minute_end.getSelectedItem().toString();
	}
	public String getClasse() {
		return this.listClasse.getSelectedValue().toString();
	}
	public int getClasseLenght() {
		return this.dataClasseList.size();
	}
	public ArrayList<String> getDataClasseList() {
		return this.dataClasseList;
	}
	public ArrayList<Classe> getDBClasseList() {
		return this.dbClasse;
	}
	
	public JButton addClasse() {
		return this.ajouter;
	}
	public JButton deleteClasse() {
		return this.supprimer;
	}

	
}

