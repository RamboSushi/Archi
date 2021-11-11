package vue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.BoxLayout;
import controlleur.Controlleur;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
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
	
	
	JButton createButton = new JButton("ajouter ue");
	
	GridBagConstraints gc = new GridBagConstraints();
	
	public UETab(JPanel panel) {
		this.panel=panel;
		//this.panel.setLayout(new GridLayout());
		
		
		
		//panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		//this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		initComponent();
	}
	
	private void initComponent() {
		
		ue.add(new UE("a","b"));
		ue.add(new UE("b","b"));
		ue.add(new UE("c","c"));
		ue.add(new UE("d","d"));
		
		this.panel.setLayout(new GridLayout(1,1));
		
		this.panel1.setLayout(new GridBagLayout());
		this.panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		
		this.panel2.setLayout(new BoxLayout(this.panel2, 1));
		//this.panel2.setLayout(new GridLayout(3, 1));
		/* le parametre fill sert à définir comment le composant sera rempli GridBagConstraints.BOTH permet d'occuper tout l'espace disponible
		 * horizontalement et verticalement GridBagConstraints.HORIZONTAL maximise horizontalement GridBagConstraints.VERTICAL maximise verticalement
		 */
		//gc.fill = GridBagConstraints.HORIZONTAL;
		/* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
		gc.insets = new Insets(5, 5, 5, 5);
		
		/* ipady permet de savoir où on place le composant s'il n'occupe pas la totalité de l'espace disponnible */
		//gc.ipady = gc.anchor = GridBagConstraints.CENTER;

		/* weightx définit le nombre de cases en abscisse */
		gc.weightx = 2;
		
		/* weightx définit le nombre de cases en ordonnée */
		gc.weighty = 4;
		
		
		
		displayUE();
//		gc.gridx = 1;
//		gc.gridy = 0;
		panel2.add(sigle);
		
//		gc.gridx = 1;
//		gc.gridy = 1;
		panel2.add(sigleText);
	
//		gc.gridx = 1;
//		gc.gridy = 2;
		panel2.add(nomination);
		
//		gc.gridx = 1;
//		gc.gridy = 3;
		panel2.add(nominationText);

//		gc.gridx = 1;
//		gc.gridy = 4;
		panel2.add(createButton);
		
		
		splitPane = new JSplitPane(SwingConstants.VERTICAL, panel1, panel2);
		splitPane.setDividerSize(0);
		splitPane.setResizeWeight(0.5);  
		
		panel.add(splitPane);
	}
	
	
	public void displayUE() {
		int a = 0;
		gc.gridx = 0;
		gc.gridy = a;
		
		ArrayList<JButton> ueButton = new ArrayList<JButton>();
		
		for(int i = 0; i<ue.size();i++) {
			ueButton.add(new JButton(ue.get(i).toString()));
			panel1.add(ueButton.get(i),gc);
			gc.gridx = 1;
			panel1.add(new JButton("x"),gc);
			gc.gridx = 0;
			gc.gridy +=1;
		} 
		panel1.updateUI();
	}
	
	public void writeErrorMessage() {
		JOptionPane.showMessageDialog(panel1, "Impossible de créer une UE", "Erreur", JOptionPane.ERROR_MESSAGE);
	}
	
	public void addNewUE(UE ue) {
		this.ue.add(ue);
	}
	

	/**************/
	/*** Getter ***/
	/**************/
	
	public JButton getCreateUE() {
		return this.createButton;
	}
	
	public String getUEsigle() {
		return sigleText.getText();
	}
	
	public String getUEnomination() {
		return nominationText.getText();
	}
	
}