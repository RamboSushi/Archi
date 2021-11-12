package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
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

public class SessionTab {
	

	private JPanel sessionPanel;
	
	private JButton ajouter = new JButton("ajouter une Session");
	private JButton supprimer = new JButton("supprimer une Session");
	private JLabel label = new JLabel();
	
	private JTextField name_session = new JTextField();
	
	private int current_year = ZonedDateTime.now(ZoneId.of("CET")).getYear();
	private SpinnerModel value_year =  new SpinnerNumberModel(current_year,current_year-10,current_year+10,1);  
	private JSpinner spinner_years = new JSpinner(value_year);
	
	private JScrollPane scrollListSession = new JScrollPane();
	
	private ArrayList<Session> session = new ArrayList<Session>();
	private DefaultListModel<Session> listModel = new DefaultListModel<Session>();
	private JList<Session> listSession = new JList<Session>(listModel);
	
	
	private GridBagConstraints c = new GridBagConstraints();
	
	public SessionTab(JPanel panel) {
		this.sessionPanel=panel;
		this.sessionPanel.setLayout(new GridBagLayout());
		
		initComponent();
	}
	
	private void initComponent() {
		sessionPanel.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.HORIZONTAL;
		
		initComponentJButton();
		displaySession();
		
	}
	
	private void initComponentJButton() {
		c.fill = GridBagConstraints.HORIZONTAL;
		label = new JLabel("Année scolaire (Début) :");
		c.gridx = 0;
		c.gridy = 1;
		sessionPanel.add(label, c);
		c.gridy = 2;
		JFormattedTextField spin_years =((JSpinner.DefaultEditor)spinner_years.getEditor()).getTextField();
		spin_years.setEditable(false);
		sessionPanel.add(spinner_years, c);
		label = new JLabel("Nom de la Formation :");
		c.gridy = 3;
		sessionPanel.add(label, c);
		c.gridy = 4;
		sessionPanel.add(name_session, c);
		c.weighty = 0.1;   //request any extra vertical space
		c.gridx = 0;
		c.gridy = 11;
		sessionPanel.add(ajouter, c);
		c.gridx = 2;
		sessionPanel.add(supprimer, c);
		
		scrollListSession.setViewportView(listSession);
		listSession.setLayoutOrientation(JList.VERTICAL);
		listSession.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.gridx = 0;
		c.gridy = 12;
		sessionPanel.add(scrollListSession, c);
		
	}
	
	public void displaySession() {
		listModel.clear();
		
		//System.out.println(ue.size());
		for(int i = 0; i<session.size();i++) {
			listModel.addElement(session.get(i));
		}
		sessionPanel.repaint();
		//panel1.updateUI();
	}
	
	
	public void printSession(Classe classe) {
        JOptionPane.showMessageDialog(sessionPanel, classe.toString(), "Classe Ajoutée", 0);
    }
	public void printError(String msg) {
        JOptionPane.showMessageDialog(sessionPanel, msg, "Error", 0);
    }

	public String getYearSession() {
		return this.spinner_years.getValue().toString();
	}
	

	public String getNameSession() {
		return this.name_session.getText();
	}

	public String getSession() {
		return this.listSession.getSelectedValue().toString();
	}
//	public int getClasseLenght() {
//		return this.dataClasseList.size();
//	}
//	public ArrayList<String> getDataClasseList() {
//		return this.dataClasseList;
//	}
//	public ArrayList<Classe> getDBClasseList() {
//		return this.dbClasse;
//	}
	
	/**************/
	/*** Setter ***/
	/**************/
	
	public void setNewSession(Session session) {
		this.session.add(session);
	}

	public void setDeleteSession(int index) {
		this.session.remove(index);
	}
	
	
	/**************/
	/*** Getter ***/
	/**************/
	
	public ArrayList<Session> getDataSessionList() {
		return this.session;
	}
	
	public JButton getAddSession() {
		return this.ajouter;
	}
	public JButton getDeleteSession() {
		return this.supprimer;
	}
	
	public String getSessionFormation() {
		return name_session.getText();
	}
	
	public String getSessionYear() {
		return spinner_years.getValue().toString();
	}

	public int getIndexListSession() {
		return listSession.getSelectedIndex();
	}
	
}