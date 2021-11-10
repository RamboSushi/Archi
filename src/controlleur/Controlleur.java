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
}
