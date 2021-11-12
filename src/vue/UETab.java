package vue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuKeyListener;
import javax.swing.JList;
import javax.swing.DefaultListModel;

import javax.swing.BoxLayout;
import controlleur.Controlleur;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

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
	

	public UETab(JPanel panel) {
		this.uePanel=panel;
		this.uePanel.setLayout(new GridBagLayout());
		
		initComponent();
	}

	private void initComponent() {
	
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
	
	/*** Display list of Ue ***/
	public void displayUE() {
		listModel.clear();
		
		for(int i = 0; i<ue.size();i++) {
			listModel.addElement(ue.get(i));
		}
		uePanel.repaint();
	}

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
	
	public void setNewUE(Ue ue) {
		this.ue.add(ue);
	}

	public void setDeleteUE(int index) {
		this.ue.remove(index);
	}

	/**************/
	/*** Getter ***/
	/**************/

	public JButton getAddUE() {
		return this.createButton;
	}

	public JButton getDeleteUE() {
		return this.deleteButton;
	}

	public String getUEsigle() {
		return sigleText.getText();
	}

	public String getUEnomination() {
		return nominationText.getText();
	}

	public int getIndexListUE() {
		return listeUE.getSelectedIndex();
	}
	
	public ArrayList<Ue> getDataUEList() {
		return this.ue;
	}
	
}
