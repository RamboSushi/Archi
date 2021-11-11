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

	private ArrayList<UE> ue = new ArrayList<UE>();

	private JPanel panel;

	private JLabel sigle = new JLabel("Sigle");
	private JLabel nomination = new JLabel("Nomination");
	
	private JTextArea sigleText = new JTextArea();
	private JTextArea nominationText = new JTextArea();
	
	JSplitPane splitPane;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	private JScrollPane scrollListUE= new JScrollPane();
	
	DefaultListModel listModel = new DefaultListModel();
	JList listeUE = new JList(listModel);
	
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
		ue.add(new UE("a","b"));
		ue.add(new UE("b","b"));
		ue.add(new UE("c","c"));
		ue.add(new UE("d","d"));
		
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
//	private void initComponent() {
//		
//		ue.add(new UE("a","b"));
//		ue.add(new UE("b","b"));
//		ue.add(new UE("c","c"));
//		ue.add(new UE("d","d"));
//		
//		this.panel.setLayout(new GridLayout(1,1));
//		
//		this.panel1.setLayout(new GridBagLayout());
//		this.panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
//		
//		
//		this.panel2.setLayout(new BoxLayout(this.panel2, 1));
//		//this.panel2.setLayout(new GridLayout(3, 1));
//		/* le parametre fill sert à définir comment le composant sera rempli GridBagConstraints.BOTH permet d'occuper tout l'espace disponible
//		 * horizontalement et verticalement GridBagConstraints.HORIZONTAL maximise horizontalement GridBagConstraints.VERTICAL maximise verticalement
//		 */
//		//gc.fill = GridBagConstraints.HORIZONTAL;
//		/* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
//		gc.insets = new Insets(5, 5, 5, 5);
//		
//		/* ipady permet de savoir où on place le composant s'il n'occupe pas la totalité de l'espace disponnible */
//		//gc.ipady = gc.anchor = GridBagConstraints.CENTER;
//
//		/* weightx définit le nombre de cases en abscisse */
//		gc.weightx = 2;
//		
//		/* weightx définit le nombre de cases en ordonnée */
//		gc.weighty = 4;
//		
//		
//		panel1.add(liste);
//		displayUE();
//		//displayUE();
////		gc.gridx = 1;
////		gc.gridy = 0;
//		panel2.add(sigle);
//		
////		gc.gridx = 1;
////		gc.gridy = 1;
//		panel2.add(sigleText);
//	
////		gc.gridx = 1;
////		gc.gridy = 2;
//		panel2.add(nomination);
//		
////		gc.gridx = 1;
////		gc.gridy = 3;
//		panel2.add(nominationText);
//
////		gc.gridx = 1;
////		gc.gridy = 4;
//		panel2.add(createButton);
////		gc.gridx = 1;
////		gc.gridy = 4;
//		panel2.add(deleteButton);
//		
//		
//		splitPane = new JSplitPane(SwingConstants.VERTICAL, panel1, panel2);
//		splitPane.setDividerSize(0);
//		splitPane.setResizeWeight(0.5);  
//		
//		panel.add(splitPane);
//	}
//	
//	
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
			JOptionPane.showMessageDialog(panel1, "Impossible de créer une UE", "Erreur", JOptionPane.ERROR_MESSAGE);
		else if( str.equals("errorDeleteUE") )
			JOptionPane.showMessageDialog(panel1, "Impossible de supprimer une UE", "Erreur", JOptionPane.ERROR_MESSAGE);
	}
	
	public void addNewUE(UE ue) {
		this.ue.add(ue);
	}
	
	public void deleteUE(int index) {
		ue.remove(index);
		displayUE();
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
	
}