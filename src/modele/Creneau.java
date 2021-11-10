package modele;

import java.util.UUID;

public class Creneau {
	private String id = UUID.randomUUID().toString();
	private DateScolaire date;
	private HeureScolaire horaire;
	
	public Creneau(int jour, int mois, int annee, int heure, int minute) {
		date = new DateScolaire(jour, mois, annee);
		horaire = new HeureScolaire(heure, minute);
	}
	public Creneau(String jour, String mois, String annee, String heure, String minute) {
		date = new DateScolaire(jour, mois, annee);
		horaire = new HeureScolaire(heure, minute);
	}
	
	public String getId() {
		return id;
	}
	
	public DateScolaire getDate() {
		return date;
	}
	public void setDate(DateScolaire date) {
		this.date = date;
	}
	
	public HeureScolaire getHoraire() {
		return horaire;
	}
	public void setHoraire(HeureScolaire horaire) {
		this.horaire = horaire;
	}
	
	@Override
	public String toString() {
		return date + " " + horaire;
	}
}
