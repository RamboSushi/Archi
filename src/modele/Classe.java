package modele; 

public class Classe {
	private String nomination;
	private AnneeScolaire anneeScolaire;
	
	/**
	 * creer une classe avec avec des noms spécifiques
	 * @param nomination : un String contenant la nomination spécifique
	 * @param anneeDepart : un entier contentant l'année de départ spécifique
	 */
	public Classe(String nomination, int anneeDepart) {
		this.nomination = nomination;
		this.anneeScolaire = new AnneeScolaire(anneeDepart);
	}

	/**
	 * creer une classe avec avec des noms spécifiques
	 * @param nomination : un String contenant la nomination spécifique
	 * @param anneeDepart : un String contentant l'année de départ spécifique
	 */
	
	public Classe(String nomination, String anneeDepart) {
		this.nomination = nomination;
		this.anneeScolaire = new AnneeScolaire(anneeDepart);
	}
	
	/**
	 * retourne l'attribut nomination
	 * @return une chaine de caractere representant la nomination
	 */
	public String getNomination() {
		return nomination;
	}
	
	/**
	 * modifie dans l'attribut nomination
	 * @param nomination : un String
	 */
	public void setNomination(String nomination) {
		this.nomination = nomination;
	}
	
	/**
	 * Retourne l'attribut anneeScolaire
	 * @return une AnnneScolaire representant l'attribut anneeScolaire
	 */
	public AnneeScolaire getAnneeScolaire() {
		return anneeScolaire;
	}
	
	/**
	 * modifie l'attribut anneeScolaire
	 * @param anneeScolaire : une AnneeScolaire
	 */
	public void setAnneeScolaire(AnneeScolaire anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}
	
	@Override
	/**
	 * Affiche les attribut de la forme nomination anneeScolaire
	 */
	public String toString() {
		return nomination + ":" + anneeScolaire;
	}
	
	/**
	 *  compare deux Classes
	 * @param classe : une Classe
	 * @return un booleen 
	 */
	public boolean equals(Classe classe) {
		if (nomination.equals(classe.getNomination()) &&
			anneeScolaire.equals(anneeScolaire)) {
			return true;
		}
		return false;
	}
	
	/**
	 * retourne l'attribut nomination avec l'appel de la 
	 * methode parse sur l'attribut anneeScolaire
	 * @return String
	 */
	public String parse() {
		return nomination + ";" + anneeScolaire.parse();
	}
}
