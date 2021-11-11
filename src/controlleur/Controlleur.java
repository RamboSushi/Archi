package controlleur;

import modele.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import vue.*;

public class Controlleur {
	private Fenetre view;


	public Controlleur(Classe classe, Ue ue, Creneau creneau,Session session, Fenetre fenetre) {
		//fenetre.affiche(classe, ue, creneau)
		this.view = fenetre;
		this.view.getUETab().getCreateUE().addActionListener(new createUEListener());
		this.view.getCreneauTab().AddCreneau().addActionListener(new addCreneauListener());
		this.view.getCreneauTab().DeleteCreneau().addActionListener(new deleteCreneauListener());
		this.view.getUETab().getDeleteUE().addActionListener(new deleteUEListener());
		this.view.setVisible(true);
	}



	public boolean checkNewUE(String sigle, String nomination) {
		if (sigle.isEmpty() || nomination.isEmpty()) return false;
		return true;
	}


	class createUEListener implements ActionListener {
		 public void actionPerformed(ActionEvent e){

			 String sigle = view.getUETab().getUEsigle();
			 String nomination = view.getUETab().getUEnomination();

			 if(checkNewUE(sigle, nomination)) {
				 Ue ue = new Ue(sigle, nomination);
				 view.getUETab().addNewUE(ue);
				 view.getUETab().displayUE();
			 }
			 else {
				 view.getUETab().writeErrorMessage("errorCreateUE");
			 }
		}
	 }

	class deleteUEListener implements ActionListener {
		 public void actionPerformed(ActionEvent e){
			 int selected = view.getUETab().getIndexListUE();

			 if (selected < 0) view.getUETab().writeErrorMessage("errorDeleteUE");
			 else view.getUETab().deleteUE(selected);
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
			 Creneau creneau = new Creneau(day, month, year, hour_begin, minute_begin,hour_end, minute_end);
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
