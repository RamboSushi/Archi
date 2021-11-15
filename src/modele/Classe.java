package modele; 

public class Classe {
	private String nomination;
	private AnneeScolaire anneeScolaire;
	
	/**
	 * Constructeur de la classe Classe qui met la 
	 * valeur du parametre nomination dans l'attribut nomination
	 * et met la valeur d'anneeDepart dans l'attribut 
	 * correpondant
	 * @param nomination
	 * @param anneeDepart
	 */
	public Classe(String nomination, int anneeDepart) {
		this.nomination = nomination;
		this.anneeScolaire = new AnneeScolaire(anneeDepart);
	}
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
	 * Met la valeur de nomination dans l'attribut nomination
	 * @param nomination
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
	 * Met la valeur d'anneScolaire dans l'attribut anneeScolaire
	 * @param anneeScolaire
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
	 * 
	 * @param classe
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
