package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
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
	
	private JScrollPane scrollListCreneau = new JScrollPane();
	
	private ArrayList<Creneau> creneau = new ArrayList<Creneau>();
	DefaultListModel<Creneau> listModel = new DefaultListModel<Creneau>();
	private JList<Creneau> listCreneau = new JList<Creneau>(listModel);
	
	private GridBagConstraints c = new GridBagConstraints();
	
	public CreneauTab(JPanel panel) {
		this.creneauPanel=panel;
		this.creneauPanel.setLayout(new GridBagLayout());
		
		initComponent();
	}
	
	/**
	 * initialise les composants de l'onglet créneau
	 */
	private void initComponent() {
		
		//position the elements
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
		label = new JLabel("Annee :");
		c.gridy = 5;
		creneauPanel.add(label, c);
		c.gridy = 6;
		JFormattedTextField spin=((JSpinner.DefaultEditor)spinner_years.getEditor()).getTextField();
		spin.setEditable(false);
		creneauPanel.add(spinner_years, c);
		label = new JLabel("Heure debut :");
		c.gridy = 7;
		creneauPanel.add(label, c);
		c.gridy = 8;
		creneauPanel.add(box_hour_begin, c);
		label = new JLabel("Heure fin :");
		c.gridy = 9;
		creneauPanel.add(label, c);
		c.gridy = 10;
		creneauPanel.add(box_hour_end, c);
		label = new JLabel("Minute debut :");
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
		
		scrollListCreneau.setViewportView(listCreneau);
		listCreneau.setLayoutOrientation(JList.VERTICAL);
		listCreneau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.gridx = 0;
		c.gridy = 12;
		creneauPanel.add(scrollListCreneau, c);
	
		displayCreneau();
		
	}
	
	/**
	 * rafraichit l'affichage des créneaux
	 */
	public void displayCreneau() {
		listModel.clear();
		
		for(int i = 0; i<creneau.size();i++) {
			listModel.addElement(creneau.get(i));
		}
		creneauPanel.repaint();
	}
	
	/**
	 * Affiche un message pop-up 
	 * @param str : information sur le message à afficher
	 */
	public void writeMessage(String str) {
		if( str.equals("errorCreateCreneau") )
			JOptionPane.showMessageDialog(creneauPanel, "Impossible de creer un creneau", "erreur", JOptionPane.ERROR_MESSAGE);
		else if( str.equals("errorDeleteCreneau") )
			JOptionPane.showMessageDialog(creneauPanel, "Impossible de supprimer un creneau", "erreur", JOptionPane.ERROR_MESSAGE);
		else if( str.equals("successfullycreateCreneau") ) 
			JOptionPane.showMessageDialog(creneauPanel, "creneau ajoute", "succes", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**************/
	/*** Setter ***/
	/**************/
	
	/**
	 * ajoute un créneau 
	 * @param index : un Creneau contenant le creneau à ajouter
	 */
	public void setNewCreneau(Creneau creneau) {
		this.creneau.add(creneau);
	}

	/**
	 * supprime un créneau
	 * @param index : un entier permettant de récupérer le créneau à supprimer
	 */
	public void setDeleteCreneau(int index) {
		this.creneau.remove(index);
	}
	
	/**************/
	/*** Getter ***/
	/**************/
	
	/**
	 * retourne le jour d'un créneau
	 * @return un entier représentant le jour d'un créneau
	 */
	public String getDayCreneau() {
		return this.box_days.getSelectedItem().toString();
	}
	
	/**
	 * retourne le mois d'un créneau
	 * @return un entier représentant le mois d'un créneau
	 */
	public String getMonthCreneau() {
		return this.box_months.getSelectedItem().toString();
	}
	
	/**
	 * retourne l'année d'un créneau
	 * @return un String représentant l'année d'un créneau
	 */
	public String getYearCreneau() {
		return this.spinner_years.getValue().toString();
	}
	
	/**
	 * retourne l'heure de départ d'un créneau
	 * @return un String représentant l'heure de départ d'un créneau
	 */
	public String getHourBeginCreneau() {
		return this.box_hour_begin.getSelectedItem().toString();
	}
	
	/**
	 * retourne l'année d'un créneau
	 * @return un String représentant l'année d'un créneau
	 */
	public String getHourEndCreneau() {
		return this.box_hour_end.getSelectedItem().toString();
	}
	
	/**
	 * retourne la minute de départ d'un créneau
	 * @return un String représentant la minute de départ d'un créneau
	 */
	public String getMinuteBeginCreneau() {
		return this.box_minute_begin.getSelectedItem().toString();
	}
	
	/**
	 * retourne la minute de fin d'un créneau
	 * @return un String représentant la minute de fin d'un créneau
	 */
	public String getMinuteEndCreneau() {
		return this.box_minute_end.getSelectedItem().toString();
	}

	/**
	 * retourne la liste des créneaux
	 * @return un ArrayList représentant la liste des créneaux
	 */
	public ArrayList<Creneau> getDataCreneauList() {
		return this.creneau;
	}
	
	/**
	 * retourne le bouton ajouter créneau
	 * @return un JButton représentant le bouton ajouter
	 */
	public JButton addCreneau() {
		return this.ajouter;
	}
	
	/**
	 * retourne le bouton supprimer créneau
	 * @return un JButton représentant le bouton supprimer
	 */
	public JButton deleteCreneau() {
		return this.supprimer;
	}
	
	/**
	 * retourne l'index selectionné dans la liste des créneaux
	 * @return un entier contenant l'index sélectionné par l'utilisateur dans 
	 * la liste des créneaux
	 */
	public int getIndexListCreneau() {
		return listCreneau.getSelectedIndex();
	}
}
