package controlleur;

import modele.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import vue.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controlleur {
	private Fenetre view;
	private Parser parser = new Parser();
	
	private ArrayList<Object> creneau_read_parser;
	private ArrayList<Object> ue_read_parser;
	private ArrayList<Object> classe_read_parser;
	private ArrayList<Object> session_read_parser;
	
	public Controlleur(Fenetre fenetre, Parser parser) {
		this.parser = parser;
		this.view = fenetre;
		
		creneau_read_parser = parser.read(Creneau.class);
		ue_read_parser = parser.read(Ue.class);
		classe_read_parser = parser.read(Classe.class);
		session_read_parser = parser.read(Session.class);
		
		//Load data from files
		for(int i=0;i<creneau_read_parser.size();i++) {
			view.getCreneauTab().getDataCreneauList().add(((Creneau) creneau_read_parser.get(i)));
			view.getSessionTab().getDataCreneauList().add(((Creneau) creneau_read_parser.get(i)));
			}
		for(int i=0;i<ue_read_parser.size();i++) {
			view.getUETab().getDataUEList().add(((Ue) ue_read_parser.get(i)));
			view.getSessionTab().getDataUeList().add(((Ue) ue_read_parser.get(i)));
		}
		for(int i=0;i<classe_read_parser.size();i++) {
			view.getClasseTab().getDataClasseList().add(((Classe) classe_read_parser.get(i)));
			view.getSessionTab().getDataClasseList().add(((Classe) classe_read_parser.get(i)));
		}
		for(int i=0;i<session_read_parser.size();i++) {
			view.getSessionTab().getDataSessionList().add(((Session) session_read_parser.get(i)));
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
		view.getSessionTab().displayUe();
		view.getSessionTab().displayClasse();
		view.getSessionTab().displayCreneau();
		view.getSessionTab().displaySession();
		
		view.setVisible(true);
	}	

	/**********************/
	/*** Listener UETab ***/
	/**********************/
	
	class createUEListener implements ActionListener {
		public void actionPerformed(ActionEvent e){

			String sigle = view.getUETab().getUEsigle();
			String nomination = view.getUETab().getUEnomination();
			
			if(!(sigle.isEmpty() || nomination.isEmpty())){
				Ue ue = new Ue(sigle, nomination);
				
				//write in file
				parser.write(ue.parse(), Ue.class);
				
				//update display UETab
				view.getUETab().setNewUE(ue);
				view.getUETab().displayUE();
				
				//update display SessionTab
				view.getSessionTab().getDataUeList().add(ue);
				view.getSessionTab().displayUe();
				
				view.getUETab().writeMessage("successfullycreateUE");  
			}
			else {
				view.getUETab().writeMessage("errorCreateUE");  
			}
		}
	 }

	class deleteUEListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int selected = view.getUETab().getIndexListUE();

			if (selected >= 0) {
				Ue ue = view.getUETab().getDataUEList().get(selected);
				
				//write in file
				parser.remove(ue.parse(), Ue.class);
				
				//update display UETab
				view.getUETab().setDeleteUE(selected);
				view.getUETab().displayUE();
				
				//update display SessionTab
				view.getSessionTab().getDataUeList().remove(ue);
				view.getSessionTab().displayUe();
				
			}
			else {
				view.getUETab().writeMessage("errorDeleteUE");
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

			//write in file
			parser.write(creneau.parse(), Creneau.class);
			
			//update display CreneauTab
			view.getCreneauTab().setNewCreneau(creneau);
			view.getCreneauTab().displayCreneau();
			
			//update display SessionTab
			view.getSessionTab().getDataCreneauList().add(creneau);
			view.getSessionTab().displayCreneau();

			view.getCreneauTab().writeMessage("successfullycreateCreneau");
			
		}
	}

	class deleteCreneauListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int selected = view.getCreneauTab().getIndexListCreneau();
			
			if (selected >= 0) {
				Creneau creneau = view.getCreneauTab().getDataCreneauList().get(selected);
				
				//write in file
				parser.remove(creneau.parse(), Creneau.class);
				
				//update display CreneauTab
				view.getCreneauTab().setDeleteCreneau(selected);
				view.getCreneauTab().displayCreneau();
				
				//update display SessionTab
				view.getSessionTab().getDataCreneauList().remove(creneau);
				view.getSessionTab().displayCreneau();
			}
			else {
				view.getCreneauTab().writeMessage("errorDeleteCreneau");
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
				
				//write in file
				parser.write(classe.parse(), Classe.class);
				
				//update display ClasseTab
				view.getClasseTab().setNewClasse(classe);
				view.getClasseTab().displayClasse();
				
				//update display SessionTab
				view.getSessionTab().getDataClasseList().add(classe);
				view.getSessionTab().displayClasse();
				
				view.getClasseTab().writeMessage("successfullycreateClasse");;
			}
			else {
				view.getClasseTab().writeMessage("errorCreateClasse");  
			}
		}
	 }

	class deleteClasseListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int selected = view.getClasseTab().getIndexListClasse();
			
			if (selected >= 0) {
				Classe classe = view.getClasseTab().getDataClasseList().get(selected);
				
				//write in file
				parser.remove(classe.parse(), Classe.class);
				
				//update display ClasseTab
				view.getClasseTab().setDeleteClasse(selected);
				view.getClasseTab().displayClasse();
				
				//update display SessionTab
				view.getSessionTab().getDataClasseList().remove(classe);
				view.getSessionTab().displayClasse();
			}
			else {
				view.getClasseTab().writeMessage("errorDeleteClasse");
			}
		}
	 }
	
	/***************************/
	/*** Listener SessionTab ***/
	/***************************/
	
	class addSessionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int selectedUe = view.getSessionTab().getIndexListUE();
			int selectedClasse = view.getSessionTab().getIndexListClasse();
			int[] selectedCreneau = view.getSessionTab().getIndexListCreneau();
	
			if(selectedUe >= 0 && selectedClasse >= 0 && selectedCreneau.length != 0) {
				
				Ue ue = view.getSessionTab().getDataUeList().get(selectedUe);
				Classe classe = view.getSessionTab().getDataClasseList().get(selectedClasse);
				
				ArrayList<Creneau> creneau = new ArrayList<Creneau>();
				for (int i = 0 ; i < selectedCreneau.length ; i++) {
					creneau.add(view.getSessionTab().getDataCreneauList().get(i));
				}
				
				Session session= new Session(ue, classe, creneau);
				
				//write in file
				parser.write(session.parse(), Session.class);
				
				//update display ClasseTab
				view.getSessionTab().setNewSession(session);
				view.getSessionTab().displaySession();
			}	
			else {
				view.getSessionTab().writeErrorMessage("errorCreateSession");
			}
		}
	}
	
	class deleteSessionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int selected = view.getSessionTab().getIndexListSession();
			
			if (selected >= 0) {
				Session session = view.getSessionTab().getDataSessionList().get(selected);
				
				//write in file
				parser.remove(session.parse(), Session.class);
				
				//update display ClasseTab
				view.getSessionTab().setDeleteSession(selected);
				view.getSessionTab().displaySession();
				
			}
			else {
				view.getSessionTab().writeErrorMessage("errorDeleteSession");
			}
			
		}
	}
	
}
