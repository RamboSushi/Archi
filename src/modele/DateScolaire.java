package modele;

class DateScolaire {
	private int jour, mois, annee;
	
	public DateScolaire(int jour, int mois, int annee) throws IllegalArgumentException {
		if (!this.isValid(jour, mois, annee)) {
			throw new IllegalArgumentException("Format jour/mois/annee non conforme");
		} else {
			this.jour = jour;
			this.mois = mois;
			this.annee = annee;
		}
	}
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
	
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
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

	public boolean compateTo(DateScolaire dateScolaire) {
		return (jour <= dateScolaire.getJour()) && (mois <= dateScolaire.getMois()) && (annee <= dateScolaire.getAnnee());
	}

	@Override
	public String toString() {
		return jour + "/" + mois + "/" + annee;
	}
	
	public boolean equals(DateScolaire dateScolaire) {
		if (jour == dateScolaire.getJour() &&
			mois == dateScolaire.getMois() &&
			annee == dateScolaire.getAnnee()) {
			return true;
		}
		return false;
	}
	
	public String parse() {
		return jour + ";" + mois + ";" + annee;
	}
}
