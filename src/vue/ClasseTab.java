package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
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

	private JScrollPane scrollListClasse = new JScrollPane();

	private ArrayList<Classe> classe = new ArrayList<Classe>();
	private DefaultListModel<Classe> listModel = new DefaultListModel<Classe>();
	private JList<Classe> listClasse = new JList<Classe>(listModel);

	private GridBagConstraints c = new GridBagConstraints();


	/**
	 * creer un onglet classe
	 * @param panel : un JPanel sur lequel afficher l'onglet Classe
	 */
	public ClasseTab(JPanel panel) {
		this.classePanel=panel;
		this.classePanel.setLayout(new GridBagLayout());

		initComponent();
	}
	/**
	 * initialise les composants de l'onglet Classe
	 */


	/**
	 * initialise les composants de l'onglet Classe
	 */
	private void initComponent() {

		//disable character ";" from JTextField
		name_classe.getInputMap(JComponent.WHEN_FOCUSED).put(
		        KeyStroke.getKeyStroke("typed ;"), "none");

		//position the elements
		c.fill = GridBagConstraints.HORIZONTAL;

		label = new JLabel("Annee scolaire (Debut) :");
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

		scrollListClasse.setViewportView(listClasse);
		listClasse.setLayoutOrientation(JList.VERTICAL);
		listClasse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.gridx = 0;
		c.gridy = 12;
		classePanel.add(scrollListClasse, c);

		displayClasse();
	}

	/**
	 * rafraichit l'affichage des classes
	 */
	public void displayClasse() {
		listModel.clear();

		for(int i = 0; i<classe.size();i++) {
			listModel.addElement(classe.get(i));
		}
		classePanel.repaint();
	}
	/**
	 * Affiche une message pop-up
	 * @param str : information sur le message a afficher
	 */

	/**
	 * Affiche une message pop-up
	 * @param str : information sur le message a afficher
	 */
	public void writeMessage(String str) {
		if( str.equals("errorCreateClasse") )
			JOptionPane.showMessageDialog(classePanel, "Impossible de creer une classe", "Erreur", JOptionPane.ERROR_MESSAGE);
		else if( str.equals("errorDeleteClasse") )
			JOptionPane.showMessageDialog(classePanel, "Impossible de supprimer une classe", "Erreur", JOptionPane.ERROR_MESSAGE);
		else if( str.equals("successfullycreateClasse") )
			JOptionPane.showMessageDialog(classePanel, "Classe ajoutee", "succes", JOptionPane.INFORMATION_MESSAGE);

	}

	/**************/
	/*** Setter ***/
	/**************/

	/**
	 * Ajoute une nouvelle classe
	 * @param classe : Une Classe contentant la classe a ajouter
	 */
	public void setNewClasse(Classe classe) {
		this.classe.add(classe);
	}

	/**
	 * Supprime une classe
	 * @param index : Un entier permettant de recuperer la classe a supprimer
	 */
	public void setDeleteClasse(int index) {
		this.classe.remove(index);
	}


	/**************/
	/*** Getter ***/
	/**************/

	/**
	 * Retourne l'attribut Classe
	 * @return une liste de classe
	 */
	public ArrayList<Classe> getDataClasseList() {
		return this.classe;
	}

	/**
	 * Retourne l'attribut ajouter
	 * @return un JButton representant l'attribut ajouter
	 */
	public JButton getAddClasse() {
		return this.ajouter;
	}

	/**
	 * Retourne l'attribut supprimer
	 * @return un bouton representant l'attribut supprimer
	 */
	public JButton getDeleteClasse() {
		return this.supprimer;
	}

	/**
	 * Retourne le text relative a une classe
	 * @return une chaine de caractere du texte relative a une classe
	 */
	public String getClasseFormation() {
		return name_classe.getText();
	}

	/**
	 * Retourne l'annee d'une classe
	 * @return un string representant l'annee d'une classe
	 */
	public String getClasseYear() {
		return spinner_years.getValue().toString();
	}

	/**
	 * Retourne l'index selectionne dans la liste des classes
	 * @return un entier contenant l'index selectionner par l'utilisateur dans
	 * la liste de classe
	 */
	public int getIndexListClasse() {
		return listClasse.getSelectedIndex();
	}

}
