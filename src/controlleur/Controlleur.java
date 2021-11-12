package controlleur;

import modele.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import vue.*;

public class Controlleur {
	private Fenetre view;
	private Parser parser = new Parser();
	
	private ArrayList<Object> creneau_read_parser;
	private ArrayList<Object> ue_read_parser;
	
	public Controlleur(Fenetre fenetre, Parser parser) {
		this.parser = parser;
		view = fenetre;
		
		creneau_read_parser = parser.read(Creneau.class);
		//classe_read_parser = parser.read(Classe.class);
		ue_read_parser = parser.read(Ue.class);
		
		view.getUETab().getCreateUE().addActionListener(new createUEListener());
		
		for(int i=0;i<creneau_read_parser.size();i++) {
			view.getCreneauTab().getDataCreneauList().add(((Creneau) creneau_read_parser.get(i)).toString());
			view.getCreneauTab().getDBCreneauList().add(((Creneau) creneau_read_parser.get(i)));
		}
		for(int i=0;i<ue_read_parser.size();i++) {
			view.getUETab().getDataUEList().add(((Ue) ue_read_parser.get(i)));
			//view.getUETab().getDBCreneauList().add(((Creneau) creneau_read_parser.get(i)));
		}
		
		view.getCreneauTab().addCreneau().addActionListener(new addCreneauListener());
		view.getCreneauTab().deleteCreneau().addActionListener(new deleteCreneauListener());

		view.getUETab().getDeleteUE().addActionListener(new deleteUEListener());
		
		view.getCreneauTab().initComponentJList();
		view.getUETab().displayUE();
		view.setVisible(true);
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
				parser.write(ue.parse(), Ue.class);
			}
			else {
				view.getUETab().writeErrorMessage("errorCreateUE");  
			}
		}
	 }

	class deleteUEListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int selected = view.getUETab().getIndexListUE();

			if (selected >= 0) {
				Ue ue = view.getUETab().getDataUEList().get(selected);
				parser.remove(ue.parse(), Ue.class);
				view.getUETab().deleteUE(selected);
				view.getUETab().displayUE();
			}
			else {
				view.getUETab().writeErrorMessage("errorDeleteUE");
			}
		}
	 }

	class addCreneauListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
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
			view.getCreneauTab().getDBCreneauList().add(creneau);
			view.getCreneauTab().initComponentJList();
			parser.write(creneau.parse(), Creneau.class);
		}
	}

	class deleteCreneauListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (view.getCreneauTab().getCreneauLenght() == 0) {
				view.getCreneauTab().printError("Liste Vide");
			}
			else {
				String selected = view.getCreneauTab().getCreneau();
				for (int i=0;i<view.getCreneauTab().getCreneauLenght();i++) {
					if (view.getCreneauTab().getDataCreneauList().get(i) == selected){
						view.getCreneauTab().getDataCreneauList().remove(i);
						view.getCreneauTab().initComponentJList();
						Creneau c = view.getCreneauTab().getDBCreneauList().get(i);
						parser.remove(c.parse(), Creneau.class);
						break;
					}
		         }
			}
		}
	 }
}
