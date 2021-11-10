package modele; 

public class Classe {
	private String nomination;
	private AnneeScolaire anneeScolaire;
	
	public Classe(String nomination, int anneeDepart) {
		this.nomination = nomination;
		this.anneeScolaire = new AnneeScolaire(anneeDepart);
	}
	public Classe(String nomination, String anneeDepart) {
		this.nomination = nomination;
		this.anneeScolaire = new AnneeScolaire(anneeDepart);
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
		return nomination + ":" + anneeScolaire;
	}
	
	public boolean equals(Classe classe) {
		if (nomination.equals(classe.getNomination()) &&
			anneeScolaire.equals(anneeScolaire)) {
			return true;
		}
		return false;
	}
}
