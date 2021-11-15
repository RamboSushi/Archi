package modele;

public class AnneeScolaire {
	private int anneeDepart;
	
	/**
	 * Verifie si anneeDepart est valide , si oui il l'affecte a l'atribut
	 * Depart
	 * @param anneeDepart : un entier
	 * @throws IllegalArgumentException : si le format annee est non conforme
	 */
	public AnneeScolaire (int anneeDepart) throws IllegalArgumentException {
		if (!this.isValid(anneeDepart)) {
			throw new IllegalArgumentException("Format anneeDepart non conforme");
		} else {
			this.anneeDepart = anneeDepart;
		}
	}
	/**
	 * Constructeur de la classe AnneeScolaire , verifie is 
	 * l'entree est valide si oui il met ca valeur dans l'attribut 
	 * anneeDepart
	 * @param anneeDepart : un entier
	 * @throws IllegalArgumentException : si le format annee est non conforme
	 */
	public AnneeScolaire (String anneeDepart) throws IllegalArgumentException {
		int anneeDepartInt = Integer.parseInt(anneeDepart);
		if (!this.isValid(anneeDepartInt)) {
			throw new IllegalArgumentException("Format anneeDepart non conforme");
		} else {
			this.anneeDepart = anneeDepartInt;
		}
	}

	/**
	 * Getter d'annee Depart
	 * @return un entier qui represente anneeDepart
	 */
	public int getAnneeDepart() {
		return anneeDepart;
	}
	
	/**
	 * Met la valeur de annee depart dans l'attribut annee depart
	 * @param anneeDepart : un entier
	 */
	public void setAnneeDepart(int anneeDepart) {
		this.anneeDepart = anneeDepart;
	}
	
	/**
	 * Validite de l'annee de depart 
	 * @param anneeDepart
	 * @return un booleen dependament de la validite de l'annee depart
	 */
	private boolean isValid(int anneeDepart) {
		if (anneeDepart < 0) return false;
		return true;
	}

	
	@Override
	/**
	 * override de la methode toString qui affiche 
	 * les attributs de la forme anneeDepart Anneedefin
	 */
	public String toString() {
		return anneeDepart + "-" + (anneeDepart+1);
	}
	
	/**
	 * Verifier si annee depart est egal a l'annee de depart du 
	 * parametre
	 * @param anneeScolaire : une AnneeScolaire
	 * @return un booleen
	 */
	public boolean equals(AnneeScolaire anneeScolaire) {
		if (anneeDepart == anneeScolaire.getAnneeDepart()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retourne la valeur de l'anneeDepart 
	 * @return une chaine de charactere 
	 */
	public String parse() {
        return String.valueOf(anneeDepart);
    }
}
