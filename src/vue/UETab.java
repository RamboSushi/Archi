package vue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import controlleur.Controlleur;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import modele.*;

public class UETab {

	private ArrayList<Ue> ue = new ArrayList<Ue>();

	private JPanel panel;

	//private ArrayList<Button> ueButton = new ArrayList<Button>();
	private JTextArea text = new JTextArea();
	
	JButton create = new JButton("ajouter ue");
	
	GridBagConstraints gc = new GridBagConstraints();
	
	public UETab(JPanel panel) {
		this.panel=panel;
		
		ue.add(new Ue("a","a"));
		ue.add(new Ue("b","b"));
		ue.add(new Ue("c","c"));
		ue.add(new Ue("d","d"));


		//panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.panel.setLayout(new GridBagLayout());
		
		initComponent();
	}
	
	private void initComponent() {
		
		
		
		/* le parametre fill sert à définir comment le composant sera rempli GridBagConstraints.BOTH permet d'occuper tout l'espace disponible
		 */
		gc.fill = GridBagConstraints.HORIZONTAL;
		
		/* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
		gc.insets = new Insets(5, 5, 5, 5);
		
		/* ipady permet de savoir où on place le composant s'il n'occupe pas la totalité de l'espace disponnible */
		gc.ipady = gc.anchor = GridBagConstraints.CENTER;

		/* weightx définit le nombre de cases en abscisse */
		gc.weightx = 2;
		
		/* weightx définit le nombre de cases en ordonnée */
		gc.weighty = 4;
		
		
		
//		displayUE();
		gc.gridx = 1;
		gc.gridy = 0;
		panel.add(text, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		panel.add(create, gc);

	}
	
	
	private void displayUE() {
		int a = 0;
		gc.gridx = 0;
		gc.gridy = a;
		
		ArrayList<JButton> ueButton = new ArrayList<JButton>();
		
		for(int i = 0; i<ue.size();i++) {
//			ueButton.add(new JButton(ue.get(i)));
			panel.add(ueButton.get(i),gc);
			gc.gridy +=1;
		} 
		panel.updateUI();
	}
	

	/**************/
	/*** Getter ***/
	/**************/
	
	public JButton getCreateUE() {
		return this.create;
	}
	
	public String getUE() {
		return text.getText();
	}
	
}