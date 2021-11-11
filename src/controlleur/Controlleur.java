package controlleur;

import modele.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
			 String day = view.getCreneauTab().getDayCreneau();
			 String month = view.getCreneauTab().getMonthCreneau();
			 String year = view.getCreneauTab().getYearCreneau();
			 String hour_begin = view.getCreneauTab().getHourBeginCreneau();
			 String hour_end = view.getCreneauTab().getHourEndCreneau();
			 String minute_begin = view.getCreneauTab().getMinuteBeginCreneau();
			 String minute_end = view.getCreneauTab().getMinuteEndCreneau();
			 Creneau creneau = new Creneau(day, month, year, hour_begin, minute_begin);
			 view.getCreneauTab().printCreneau(creneau);
			 view.getCreneauTab().getDataCreneauList().add(creneau.toString());
			 view.getCreneauTab().initComponentJList();
		 }
	 }
	
	class deleteCreneauListener implements ActionListener {
		 public void actionPerformed(ActionEvent e){
			 if (view.getCreneauTab().getCreneauLenght() == 0) {
				 view.getCreneauTab().printError("List Vide");
			 }
			 else {
				 int i = 0;
				 ArrayList<String> list = view.getCreneauTab().getDataCreneauList();
				 for (String string : list) {
					 if (list.contains(view.getCreneauTab().getCreneau())){
						
						view.getCreneauTab().getDataCreneauList().remove(i);
						view.getCreneauTab().initComponentJList();
						break;
					}
					i++;
		         }
				 
			 }
		}
	 }
}
