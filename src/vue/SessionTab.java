package vue;

import java.awt.Dimension;
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
	
	private JScrollPane scrollListSessionUe = new JScrollPane();
	private JScrollPane scrollListSessionClasse = new JScrollPane();
	private JScrollPane scrollListSessionCreneau = new JScrollPane();
	private JScrollPane scrollListSession = new JScrollPane();
	
	private ArrayList<Ue> ue = new ArrayList<Ue>();
	private DefaultListModel<Ue> listModelUe = new DefaultListModel<Ue>();
	private JList<Ue> listUe = new JList<Ue>(listModelUe);
	
	private ArrayList<Classe> classe = new ArrayList<Classe>();
	private DefaultListModel<Classe> listModelClasse = new DefaultListModel<Classe>();
	private JList<Classe> listClasse = new JList<Classe>(listModelClasse);
	
	private ArrayList<Creneau> creneau = new ArrayList<Creneau>();
	private DefaultListModel<Creneau> listModelCreneau = new DefaultListModel<Creneau>();
	private JList<Creneau> listCreneau = new JList<Creneau>(listModelCreneau);
	
	private ArrayList<Session> session = new ArrayList<Session>();
	private DefaultListModel<Session> listModelSession = new DefaultListModel<Session>();
	private JList<Session> listSession = new JList<Session>(listModelSession);
	
	private GridBagConstraints c = new GridBagConstraints();
	
	public SessionTab(JPanel panel) {
		this.sessionPanel=panel;
		this.sessionPanel.setLayout(new GridBagLayout());
		
		initComponent();
	}
	
	private void initComponent() {
		
		//position the elements
		c.fill = GridBagConstraints.HORIZONTAL;
		
		label = new JLabel("UE :");
		c.gridx = 0;
		c.gridy = 0;
		sessionPanel.add(label, c);
		
		scrollListSessionUe.setViewportView(listUe);
		listUe.setLayoutOrientation(JList.VERTICAL);
		listUe.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		listUe.setPreferredSize(new Dimension(200, 200));
		c.gridy = 1;
		sessionPanel.add(scrollListSessionUe, c);
		
		label = new JLabel("Nom de la Formation :");
		c.gridx = 1;
		c.gridy = 0;
		sessionPanel.add(label, c);
		
		scrollListSessionClasse.setViewportView(listClasse);
		listClasse.setLayoutOrientation(JList.VERTICAL);
		listClasse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.gridy = 1;
		sessionPanel.add(scrollListSessionClasse, c);
		
		label = new JLabel("Session :");
		c.gridx = 1;
		c.gridy = 5;
		sessionPanel.add(label, c);
		
		scrollListSession.setViewportView(listSession);
		listSession.setLayoutOrientation(JList.VERTICAL);
		listSession.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.gridx = 1;
		c.gridy = 6;
		sessionPanel.add(scrollListSession, c);
		
		label = new JLabel("Creneau :");
		c.gridx = 0;
		c.gridy = 5;
		sessionPanel.add(label, c);
		
		scrollListSessionCreneau.setViewportView(listCreneau);
		listCreneau.setLayoutOrientation(JList.VERTICAL);
		listSession.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		c.gridy = 6;
		sessionPanel.add(scrollListSessionCreneau, c);
		
		c.weighty = 0.1;   //request any extra vertical space
		c.gridx = 0;
		c.gridy = 7;
		sessionPanel.add(ajouter, c);
		
		c.gridx = 1;
		sessionPanel.add(supprimer, c);
		
		displayUe();
		displayClasse();
		displayCreneau();
		displaySession();
		
	}
	
	public void displayUe() {
		listModelUe.clear();
		
		for(int i = 0; i<ue.size();i++) {
			listModelUe.addElement(ue.get(i));
		}
		sessionPanel.repaint();
	}
	
	public void displayClasse() {
		listModelClasse.clear();
		
		for(int i = 0; i<classe.size();i++) {
			listModelClasse.addElement(classe.get(i));
		}
		sessionPanel.repaint();
	}
	
	public void displayCreneau() {
		listModelCreneau.clear();
		
		for(int i = 0; i<creneau.size();i++) {
			listModelCreneau.addElement(creneau.get(i));
		}
		sessionPanel.repaint();
	}
	
	public void displaySession() {
		listModelSession.clear();
		
		for(int i = 0; i<session.size();i++) {
			listModelSession.addElement(session.get(i));
		}
		sessionPanel.repaint();
	}
	
	
	public void writeErrorMessage(String str) {
		if( str.equals("errorCreateSession") )
			str = "impossible de creer une session";
		else if( str.equals("errorDeleteSession") )
			str = "impossible de supprimer une session";	
		JOptionPane.showMessageDialog(sessionPanel, str, "Erreur", JOptionPane.ERROR_MESSAGE);
	}
	
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
	
	public ArrayList<Ue> getDataUeList() {
		return this.ue;
	}
	
	public ArrayList<Classe> getDataClasseList() {
		return this.classe;
	}
	
	public ArrayList<Creneau> getDataCreneauList() {
		return this.creneau;
	}
	
	public ArrayList<Session> getDataSessionList() {
		return this.session;
	}
	
	public JButton getAddSession() {
		return this.ajouter;
	}
	public JButton getDeleteSession() {
		return this.supprimer;
	}
	
	public int getIndexListUE() {
		return listUe.getSelectedIndex();
	}
	public int getIndexListClasse() {
		return listClasse.getSelectedIndex();
	}
	
	public int[] getIndexListCreneau() {
		return listCreneau.getSelectedIndices();
	}
	
	public int getIndexListSession() {
		return listSession.getSelectedIndex();
	}
}