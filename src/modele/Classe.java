package modele; 

import java.util.UUID;

public class Classe {
	private String id = UUID.randomUUID().toString(), nomination;
	private AnneeScolaire anneeScolaire;
	
	public Classe(String nomination, int anneeDepart, int anneeFin) {
		this.nomination = nomination;
		this.anneeScolaire = new AnneeScolaire(anneeDepart, anneeFin);
	}
	public Classe(String nomination, String anneeDepart, String anneeFin) {
		this.nomination = nomination;
		this.anneeScolaire = new AnneeScolaire(anneeDepart, anneeFin);
	}
	
	public String getId() {
		return id;
	}
	
	public String getNomination() {
		return nomination;
	}
	public void setNomination(String nomination) {
		this.nomination = nomination;
	}
	
	public AnneeScolaire getAnneeScolaire() {
		return anneeScolaire;
	}
	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}
	
	@Override
	public String toString() {
		return nomination + " " + anneeScolaire;
	}
}
