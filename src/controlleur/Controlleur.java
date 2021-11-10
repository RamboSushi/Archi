package controlleur;

import modele.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import vue.*;

public class Controlleur {	
	
	private Fenetre view;
	
	
	public Controlleur(Classe classe, UE ue, Creneau creneau, Fenetre fenetre) {
		//fenetre.affiche(classe, ue, creneau)
		this.view = fenetre;
		
		this.view.getUETab().getCreateUE().addActionListener(new createUEListener()); 
		
		this.view.getCreneauTab().AddCreneau().addActionListener(new addCreneauListener()); 
		this.view.getCreneauTab().DeleteCreneau().addActionListener(new deleteCreneauListener()); 
		
		
		this.view.setVisible(true);
	}
	
	
	
	
	/**
	 * 
	 * Check if str is correct 
	 * 
	 * @return 
	 * @param str value of UE write by the user
	 */
	public void checkUE(String str) {
		
	}
	
	
	class createUEListener implements ActionListener {
		 public void actionPerformed(ActionEvent e){
			 String str = view.getUETab().getUE();
			 System.out.println("aaaaaaaa");
		}
	 }
	class addCreneauListener implements ActionListener {
		 public void actionPerformed(ActionEvent e){
			 Creneau creneau = new Creneau(9, 11, 2021, 8, 5);
			 view.getCreneauTab().printCreneau(creneau);
		}
	 }
	
	class deleteCreneauListener implements ActionListener {
		 public void actionPerformed(ActionEvent e){
			 Creneau creneau = new Creneau(9, 11, 2021, 8, 5);
			 System.out.println(creneau);
		}
	 }
}
