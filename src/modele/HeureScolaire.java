package modele;

public class HeureScolaire {
	private int heure, minute;
	
	/**
	 * creer une heure scolaire avec des informations spécifiques
	 * @param heure : un entier
	 * @param minute : un entier
	 * @throws IllegalArgumentException
	 */
	public HeureScolaire(int heure, int minute) throws IllegalArgumentException {
		if (!this.isValid(heure, minute)) {
			throw new IllegalArgumentException("Format heure:minute non conforme");
		} else {
			this.heure = heure;
			this.minute = minute;
		}
	}
	
	/**
	 * creer une heure scolaire avec des informations spécifiques
	 * @param heure : un entier
	 * @param minute : un entier
	 * @throws IllegalArgumentException
	 */
	public HeureScolaire(String heure, String minute) throws IllegalArgumentException {
		int heureInt = Integer.parseInt(heure);
		int minuteInt = Integer.parseInt(minute);
		if (!this.isValid(heureInt, minuteInt)) {
			throw new IllegalArgumentException("Format heure:minute non conforme");
		} else {
			this.heure = heureInt;
			this.minute = minuteInt;
		}
	}

	/**
	 * retourne l'attribut heure
	 * @return un entier
	 */
	public int getHeure() {
		return heure;
	}
	
	/**
	 * modifie l'attribut heure
	 * @param heure : un entier
	 */
	public void setHeure(int heure) {
		this.heure = heure;
	}

	/**
	 * retourne l'attribut minute
	 * @return un entier
	 */
	public int getMinute() {
		return minute;
	}
	
	/**
	 * modifie l'attribut minute
	 * @param minute : un entier
	 */
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	/**
	 * verifie si une heure est valide
	 * @param heure
	 * @param minute
	 * @return un booleen
	 */
	private boolean isValid(int heure, int minute) {
		if ((heure<0) || (heure>23)) return false;
		if ((minute<0) || (minute>59)) return false;
		return true;
	}
	
	/**
	 * 
	 * @param heureScolaire
	 * @return
	 */
	public boolean compateTo(HeureScolaire heureScolaire) {
		return (heure <= heureScolaire.getHeure()) && (minute <= heureScolaire.getMinute());
	}
	
	@Override
	/**
	 * Override de la methode toString qui affiche les attributs
	 */
	public String toString() {
		return String.format("%02d", heure) + ":" + String.format("%02d", minute);
	}
	
	/**
	 * Compare deux heureScolaires
	 * @param heureScolaire
	 * @return un booleen
	 */
	public boolean equals(HeureScolaire heureScolaire) {
		if (heure == heureScolaire.getHeure() &&
			minute == heureScolaire.getMinute()) {
			return true;
		}
		return false;
	}
	
	/**
	 * retourne les attributs separe d'un point virgule pour enregistrer
	 * les données dans la BD
	 * @return un String
	 */
	public String parse() {
		return heure + ";" + minute;
	}
}
