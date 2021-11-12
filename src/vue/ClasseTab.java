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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import modele.*;

public class ClasseTab {
	

	private JPanel classePanel;
	
	private JButton ajouter = new JButton("ajouter une classe");
	private JButton supprimer = new JButton("supprimer une classe");
	private JLabel label = new JLabel();
	
	private JTextField name_classe = new JTextField();
	
	private int current_year = ZonedDateTime.now(ZoneId.of("CET")).getYear();
	private SpinnerModel value_year =  new SpinnerNumberModel(current_year,current_year-10,current_year+10,1);  
	private JSpinner spinner_years = new JSpinner(value_year);
	
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
		label = new JLabel("Année scolaire (Début) :");
		c.gridx = 0;
		c.gridy = 1;
		classePanel.add(label, c);
		c.gridy = 2;
		JFormattedTextField spin_years =((JSpinner.DefaultEditor)spinner_years.getEditor()).getTextField();
		spin_years.setEditable(false);
		classePanel.add(spinner_years, c);
		label = new JLabel("Nom de la Formation :");
		c.gridy = 3;
		classePanel.add(label, c);
		c.gridy = 4;
		classePanel.add(name_classe, c);
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
	
	
	public void printClasse(Classe classe) {
        JOptionPane.showMessageDialog(classePanel, classe.toString(), "Classe Ajoutée", 0);
    }
	public void printError(String msg) {
        JOptionPane.showMessageDialog(classePanel, msg, "Error", 0);
    }

	public String getYearClasse() {
		return this.spinner_years.getValue().toString();
	}
	

	public String getNameClasse() {
		return this.name_classe.getText();
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