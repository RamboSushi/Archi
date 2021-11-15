package modele;

public class DateScolaire {
	private int jour, mois, annee;
	
	/**
	 * Initialise les attributs de DateScolaire 
	 * @param jour : un entier
	 * @param mois : un entier
	 * @param annee : un entier
	 * @throws IllegalArgumentException : si le format dateScolaire est non conforme
	 */
	public DateScolaire(int jour, int mois, int annee) throws IllegalArgumentException {
		if (!this.isValid(jour, mois, annee)) {
			throw new IllegalArgumentException("Format jour/mois/annee non conforme");
		} else {
			this.jour = jour;
			this.mois = mois;
			this.annee = annee;
		}
	}
	/**
	 * Initialise les attributs de DateScolaire
	 * @param jour : un String
	 * @param mois : un String
	 * @param annee : un String
	 * @throws IllegalArgumentException : si le format DateScolaire est non conforme
	 */
	public DateScolaire(String jour, String mois, String annee) throws IllegalArgumentException {
		int jourInt = Integer.parseInt(jour);
		int moisInt = Integer.parseInt(mois);
		int anneeInt = Integer.parseInt(annee);
		if (!this.isValid(jourInt, moisInt, anneeInt)) {
			throw new IllegalArgumentException("Format jour/mois/annee non conforme");
		} else {
			this.jour = jourInt;
			this.mois = moisInt;
			this.annee = anneeInt;
		}
	}
	
	/**
	 * Retourne l'attribut jour
	 * @return un int
	 */
	public int getJour() {
		return jour;
	}
	
	/**
	 * Met la valeur jour dans l'attribut jour
	 * @param jour : un int
	 */
	public void setJour(int jour) {
		this.jour = jour;
	}

	/**
	 * Retourne l'attribut mois
	 * @return un int
	 */
	public int getMois() {
		return mois;
	}
	
	/**
	 * Met la valeur du parametre dans l'attribut mois
	 * @param mois : un int
	 */
	public void setMois(int mois) {
		this.mois = mois;
	}
	
	/**
	 * Retourne l'attribut annee
	 * @return un int
	 */
	public int getAnnee() {
		return annee;
	}
	
	/**
	 * Met la valeur du parametre dans l'attribut annee
	 * @param annee : un int
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	/**
	 * Verifie si les jours , mois et annee sont valides 
	 * @param jour : un int
	 * @param mois : un int
	 * @param annee : un int
	 * @return un booleen
	 */
	private boolean isValid(int jour, int mois, int annee) {
		if (annee < 0) return false;
        if ((mois < 1) || (mois > 12)) return false;
        if ((jour < 1) || (jour > 31)) return false;
        switch (mois) {
            case 1: return true;
            case 2: return (verifAnnee(annee) ? jour <= 29 : jour <= 28);
            case 3: return true;
            case 4: return jour < 31;
            case 5: return true;
            case 6: return jour < 31;
            case 7: return true;
            case 8: return true;
            case 9: return jour < 31;
            case 10: return true;
            case 11: return jour < 31;
            default: return true;
        }
	}
	
	/**
	 * Verifie si l'annee est valide 
	 * @param annee : un int
	 * @return un booleen 
	 */
	private static boolean verifAnnee(int annee) {
		if (annee % 4 != 0) {
			return false;
		} else if (annee % 400 == 0) {
			return true;
		} else if (annee % 100 == 0) {
			return false;
		} else {
			return true;
		}        
	} 

	/**
	 * Verifie si le les attributs du parametres sont egals
	 * a ceux de l'objet
	 * @param dateScolaire : DateScolaire
	 * @return booleen
	 */
	public boolean compateTo(DateScolaire dateScolaire) {
		return (jour <= dateScolaire.getJour()) && (mois <= dateScolaire.getMois()) && (annee <= dateScolaire.getAnnee());
	}

	@Override
	/**
	 * Override de la methode toString qui affiche les attributs
	 */
	public String toString() {
		return jour + "/" + mois + "/" + annee;
	}
	
	/**
	 * Verifie si les attributs du parametre sont egaux
	 * a ceux de l'objet
	 * @param dateScolaire : DateScolaire
	 * @return un boolean 
	 */
	public boolean equals(DateScolaire dateScolaire) {
		if (jour == dateScolaire.getJour() &&
			mois == dateScolaire.getMois() &&
			annee == dateScolaire.getAnnee()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retourne les attributs separe par un point virgule
	 * pour enregistrer les donnees dans la BD
	 * @return string
	 */
	public String parse() {
		return jour + ";" + mois + ";" + annee;
	}
}
