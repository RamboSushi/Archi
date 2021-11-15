package vue;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.ArrayList;

import modele.*;

public class UETab {

	private JPanel uePanel;

	private JLabel sigle = new JLabel("Sigle : ");
	private JLabel nomination = new JLabel("Nomination : ");
	
	private JTextField sigleText = new JTextField();
	private JTextField nominationText = new JTextField();

	private JButton createButton = new JButton("ajouter une ue");
	private JButton deleteButton = new JButton("supprimer une ue");
	
	private JScrollPane scrollListUE= new JScrollPane();

	private ArrayList<Ue> ue = new ArrayList<Ue>();
	private DefaultListModel<Ue> listModel = new DefaultListModel<Ue>();
	private JList<Ue> listeUE = new JList<Ue>(listModel);

	private GridBagConstraints c = new GridBagConstraints();
	
	
	/**
	 * créer un onglet Ue
	 * @param panel : un JPanel sur lequel afficher l'onglet Ue
	 */
	public UETab(JPanel panel) {
		this.uePanel=panel;
		this.uePanel.setLayout(new GridBagLayout());
		
		initComponent();
	}

	/**
	 * initialise les composants de l'onglet ue
	 */
	private void initComponent() {
		
		//disable character ";" from JTextField
		sigleText.getInputMap(JComponent.WHEN_FOCUSED).put(
		        KeyStroke.getKeyStroke("typed ;"), "none");
		
		nominationText.getInputMap(JComponent.WHEN_FOCUSED).put(
		        KeyStroke.getKeyStroke("typed ;"), "none");
	
		//position the elements
		c.fill = GridBagConstraints.HORIZONTAL;

		c.gridx = 0;
		c.gridy = 1;
		uePanel.add(sigle, c);

		c.gridy = 2;
		uePanel.add(sigleText, c);

		c.gridy = 3;
		uePanel.add(nomination, c);

		c.gridy = 4;
		uePanel.add(nominationText, c);

		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 5;
		uePanel.add(createButton, c);

		c.gridx = 1;
		c.gridy = 5;
		uePanel.add(deleteButton, c);

		scrollListUE.setViewportView(listeUE);
		listeUE.setLayoutOrientation(JList.VERTICAL);
		listeUE.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.gridx = 0;
		c.gridy = 8;
		uePanel.add(scrollListUE, c);

		displayUE();

	}
	
	/**
	 * rafraichit l'affichage des ue
	 */
	public void displayUE() {
		listModel.clear();
		
		for(int i = 0; i<ue.size();i++) {
			listModel.addElement(ue.get(i));
		}
		uePanel.repaint();
	}
	
	/**
	 * Affiche un message pop-up 
	 * @param str : information sur le message à afficher
	 */
	public void writeMessage(String str) {
		if( str.equals("errorCreateUE") )
			JOptionPane.showMessageDialog(uePanel, "Impossible de creer une ue", "erreur", JOptionPane.ERROR_MESSAGE);
		else if( str.equals("errorDeleteUE") )
			JOptionPane.showMessageDialog(uePanel, "Impossible de supprimer une ue", "erreur", JOptionPane.ERROR_MESSAGE);
		else if( str.equals("successfullycreateUE") ) 
			JOptionPane.showMessageDialog(uePanel, "ue ajoutee", "succes", JOptionPane.INFORMATION_MESSAGE);
	}
	

	/**************/
	/*** Setter ***/
	/**************/
	
	/**
	 * ajoute une ue 
	 * @param une Ue contenant l'ue à ajouter
	 */
	public void setNewUE(Ue ue) {
		this.ue.add(ue);
	}
	
	/**
	 * supprime une ue 
	 * @param index : un entier permettant de récupérer l'ue à supprimer
	 */
	public void setDeleteUE(int index) {
		this.ue.remove(index);
	}

	/**************/
	/*** Getter ***/
	/**************/

	/**
	 * retourne le bouton ajouter ue
	 * @return un JButton représentant le bouton ajouter 
	 */
	public JButton getAddUE() {
		return this.createButton;
	}

	/**
	 * retourne le bouton supprimer ue
	 * @return un JButton représentant le bouton supprimer
	 */
	public JButton getDeleteUE() {
		return this.deleteButton;
	}
	
	/**
	 * retourne le sigle d'une ue 
	 * @return un entier contenant le sigle
	 */
	public String getUEsigle() {
		return sigleText.getText();
	}

	/**
	 * retourne la nomination d'une ue 
	 * @return un entier contenant la nomination
	 */
	public String getUEnomination() {
		return nominationText.getText();
	}
	
	/**
	 * retourne l'index selectionné dans la liste des ue
	 * @return un entier contenant l'index sélectionné par l'utilisateur dans 
	 * la liste des ue
	 */
	public int getIndexListUE() {
		return listeUE.getSelectedIndex();
	}
	
	/**
	 * retourne la liste des ue
	 * @return un ArrayList représentant la liste des ue
	 */
	public ArrayList<Ue> getDataUEList() {
		return this.ue;
	}
	
}
