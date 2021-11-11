package controlleur;

import modele.*;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import vue.*;

public class Controlleur {	
	
	private Fenetre view;
	
	
	public Controlleur(Classe classe, UE ue, Creneau creneau, Fenetre fenetre) {
		//fenetre.affiche(classe, ue, creneau)
		this.view = fenetre;
		
		this.view.getUETab().getCreateUE().addActionListener(new createUEListener()); 
		
		
		this.view.setVisible(true);
	}
	
	
	
	
	/**
	 * 
	 * Check if str is correct 
	 * 
	 * @return boolean 
	 * @param str : value of UE write by the user
	 */
	public boolean checkNewUE(String sigle, String nomination) {
		if (sigle.isEmpty() || nomination.isEmpty()) return false;
		return true;
	}
	
	
	class createUEListener implements ActionListener {
		 public void actionPerformed(ActionEvent e){
			 
			 String sigle = view.getUETab().getUEsigle();
			 String nomination = view.getUETab().getUEnomination();

			 if(checkNewUE(sigle, nomination)) {
				 UE ue = new UE(sigle, nomination);
				 view.getUETab().addNewUE(ue);
				 view.getUETab().displayUE();
			 }
			 else {
				 view.getUETab().writeErrorMessage();
			 }
		}
	 }
}
