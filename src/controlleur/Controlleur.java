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
	private ArrayList<Object> classe_read_parser;
	
	public Controlleur(Fenetre fenetre, Parser parser) {
		this.parser = parser;
		this.view = fenetre;
		
		creneau_read_parser = parser.read(Creneau.class);
		ue_read_parser = parser.read(Ue.class);
		classe_read_parser = parser.read(Classe.class);
		
		//Load data from files
		for(int i=0;i<creneau_read_parser.size();i++) {
			view.getCreneauTab().getDataCreneauList().add(((Creneau) creneau_read_parser.get(i)));
			}
		for(int i=0;i<ue_read_parser.size();i++) {
			view.getUETab().getDataUEList().add(((Ue) ue_read_parser.get(i)));
		}
		for(int i=0;i<classe_read_parser.size();i++) {
			view.getClasseTab().getDataClasseList().add(((Classe) classe_read_parser.get(i)));
		}
		
		//add Listener to Button
		view.getCreneauTab().addCreneau().addActionListener(new addCreneauListener());
		view.getCreneauTab().deleteCreneau().addActionListener(new deleteCreneauListener());
		view.getUETab().getAddUE().addActionListener(new createUEListener());
		view.getUETab().getDeleteUE().addActionListener(new deleteUEListener());
		view.getClasseTab().getAddClasse().addActionListener(new createClasseListener());
		view.getClasseTab().getDeleteClasse().addActionListener(new deleteClasseListener());
		view.getSessionTab().getAddSession().addActionListener(new addSessionListener());
		view.getSessionTab().getDeleteSession().addActionListener(new deleteSessionListener());
		
		
		//Display existing data
		view.getCreneauTab().displayCreneau();
		view.getUETab().displayUE();
		view.getClasseTab().displayClasse();
		
		view.setVisible(true);
	}	

	/**********************/
	/*** Listener UETab ***/
	/**********************/
	
	class createUEListener implements ActionListener {
		public void actionPerformed(ActionEvent e){

			String sigle = view.getUETab().getUEsigle();
			String nomination = view.getUETab().getUEnomination();

			if(sigle.isEmpty() || nomination.isEmpty()) {
				Ue ue = new Ue(sigle, nomination);
				view.getUETab().setNewUE(ue);
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
				view.getUETab().setDeleteUE(selected);
				view.getUETab().displayUE();
			}
			else {
				view.getUETab().writeErrorMessage("errorDeleteUE");
			}
		}
	 }

	/***************************/
	/*** Listener CreneauTab ***/
	/***************************/
	
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

			view.getCreneauTab().setNewCreneau(creneau);
			view.getCreneauTab().displayCreneau();
			parser.write(creneau.parse(), Creneau.class);
			
			view.getCreneauTab().printCreneau(creneau);
			
		}
	}

	class deleteCreneauListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int selected = view.getCreneauTab().getIndexListCreneau();
			
			if (selected >= 0) {
				Creneau creneau = view.getCreneauTab().getDataCreneauList().get(selected);
				parser.remove(creneau.parse(), Creneau.class);
				view.getCreneauTab().setDeleteCreneau(selected);
				view.getCreneauTab().displayCreneau();
			}
			else {
				view.getCreneauTab().printError("Impossible de supprimer un creneau");
			}
		}
	 }
	
	/**************************/
	/*** Listener ClasseTab ***/
	/**************************/

	class createClasseListener implements ActionListener {
		public void actionPerformed(ActionEvent e){

			String formation = view.getClasseTab().getClasseFormation();
			String year = view.getClasseTab().getClasseYear();
			
			if(!formation.isEmpty()) {
				Classe classe = new Classe(formation, year);
				view.getClasseTab().setNewClasse(classe);
				view.getClasseTab().displayClasse();
				parser.write(classe.parse(), Classe.class);
			}
			else {
				view.getClasseTab().writeErrorMessage("errorCreateClasse");  
			}
		}
	 }

	class deleteClasseListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int selected = view.getClasseTab().getIndexListClasse();
			
			if (selected >= 0) {
				Classe classe = view.getClasseTab().getDataClasseList().get(selected);
				parser.remove(classe.parse(), Classe.class);
				view.getClasseTab().setDeleteClasse(selected);
				view.getClasseTab().displayClasse();
			}
			else {
				view.getClasseTab().writeErrorMessage("errorDeleteClasse");
			}
		}
	 }
	
	/***************************/
	/*** Listener SessionTab ***/
	/***************************/
	
	class addSessionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	class deleteSessionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
