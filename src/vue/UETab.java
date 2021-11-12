package vue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import modele.*;

public class UETab {

	private ArrayList<Ue> ue = new ArrayList<Ue>();

	private JPanel panel;

	private JLabel sigle = new JLabel("Sigle");
	private JLabel nomination = new JLabel("Nomination");

	private JTextArea sigleText = new JTextArea();
	private JTextArea nominationText = new JTextArea();

	JSplitPane splitPane;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();

	private JScrollPane scrollListUE= new JScrollPane();

	DefaultListModel<Ue> listModel = new DefaultListModel<Ue>();
	JList<Ue> listeUE = new JList<Ue>(listModel);

	JButton createButton = new JButton("ajouter ue");
	JButton deleteButton = new JButton("supprimer ue");

	GridBagConstraints c = new GridBagConstraints();

	public UETab(JPanel panel) {
		this.panel=panel;
		//this.panel.setLayout(new GridLayout());
		this.panel.setLayout(new GridBagLayout());


		//panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));

		//this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		initComponent();
	}

	private void initComponent() {
//		ue.add(new Ue("a","b"));
//		ue.add(new Ue("b","b"));
//		ue.add(new Ue("c","c"));
//		ue.add(new Ue("d","d"));

		;
		//GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;



		c.gridx = 1;
		c.gridy = 1;
		panel.add(sigle, c);

		c.gridy = 2;
		panel.add(sigleText, c);

		c.gridy = 3;
		panel.add(nomination, c);

		c.gridy = 4;
		panel.add(nominationText, c);

		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 5;
		panel.add(createButton, c);

		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 6;
		panel.add(deleteButton, c);

		scrollListUE.setViewportView(listeUE);
		listeUE.setLayoutOrientation(JList.VERTICAL);
		listeUE.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.gridx = 1;
		c.gridy = 8;
		panel.add(scrollListUE, c);

//		c.gridx = 1;
//		c.gridy = 6;
//		c.weighty = 0.1;
//		panel.add(listeUE, c);

		displayUE();

	}

	public void displayUE() {
		int a = 0;
		c.gridx = 0;
		c.gridy = a;

		listModel.clear();
		//ArrayList<JButton> ueButton = new ArrayList<JButton>();
		System.out.println(ue.size());
		for(int i = 0; i<ue.size();i++) {
			listModel.addElement(ue.get(i));
			//gc.gridy +=1;
		}
		panel1.repaint();
		//panel1.updateUI();
	}

	public void writeErrorMessage(String str) {
		if( str.equals("errorCreateUE") )
			JOptionPane.showMessageDialog(panel1, "Impossible de cr�er une UE", "Erreur", JOptionPane.ERROR_MESSAGE);
		else if( str.equals("errorDeleteUE") )
			JOptionPane.showMessageDialog(panel1, "Impossible de supprimer une UE", "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	public void addNewUE(Ue ue) {
		this.ue.add(ue);
	}

	public void deleteUE(int index) {
		ue.remove(index);
	}

	/**************/
	/*** Getter ***/
	/**************/

	public JButton getCreateUE() {
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
