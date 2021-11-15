package modele;

public class Creneau {
	private DateScolaire date;
	private HeureScolaire horaireDepart, horaireFin;
	
	/**
	 * Initialise les attributs de la classe creneau 
	 * @param jour : un entier
	 * @param mois : un entier
	 * @param annee : un entier
	 * @param heureDepart : un entier
	 * @param minuteDepart : un entier
	 * @param heureFin : un entier
	 * @param minuteFin : un entier
	 */
	public Creneau(int jour, int mois, int annee,
					int heureDepart, int minuteDepart,
					int heureFin, int minuteFin) {
		date = new DateScolaire(jour, mois, annee);
		horaireDepart = new HeureScolaire(heureDepart, minuteDepart);
		horaireFin = new HeureScolaire(heureFin, minuteFin);
	}
	/**
	 * Initialise les attributs de classe Creneau 
	 * @param jour : un entier
	 * @param mois : un entier
	 * @param annee : un entier
	 * @param heureDepart : un entier
	 * @param minuteDepart : un entier
	 * @param heureFin : un entier
	 * @param minuteFin : un entier
	 */
	public Creneau(String jour, String mois, String annee,
					String heureDepart, String minuteDepart,
					String heureFin, String minuteFin) {
		date = new DateScolaire(jour, mois, annee);
		horaireDepart = new HeureScolaire(heureDepart, minuteDepart);
		horaireFin = new HeureScolaire(heureFin, minuteFin);
	}
	
	/**
	 * retourne l'attribut date
	 * @return une DateScolaire reprentant l'attribut date
	 */
	public DateScolaire getDate() {
		return date;
	}
	
	/**
	 * met la valeur de date dans l'attribut date
	 * @param date
	 */
	public void setDate(DateScolaire date) {
		this.date = date;
	}
	
	/**
	 * retourne l'attribut horaireDepart
	 * @return une HeureScolaire
	 */
	public HeureScolaire getHoraireDepart() {
		return horaireDepart;
	}
	
	/**
	 * Met la valeur du parametre dans l'attribut horaireDepart
	 * @param horaireDepart
	 */
	public void setHoraireDepart(HeureScolaire horaireDepart) {
		this.horaireDepart = horaireDepart;
	}
	
	/**
	 * Retourne l'attribut horaireFin
	 * @return une HeureScolaire
	 */
	public HeureScolaire getHoraireFin() {
		return horaireFin;
	}
	
	/**
	 * met la valeur du parametre dans l'attribut horaireFIn
	 * @param horaireFin
	 */
	public void setHoraireFin(HeureScolaire horaireFin) {
		this.horaireFin = horaireFin;
	}
	
	@Override
	/**
	 * override de la methdoe toString qui affiche les attributs
	 */
	public String toString() {
		return date + " de " + horaireDepart + " à " + horaireFin;
	}
	
	/**
	 * compare deux Creneaux
	 * @param creneau : un creneau
	 * @return un booleen 
	 */
	public boolean equals(Creneau creneau) {
		if (date.equals(creneau.getDate()) &&
			horaireDepart.equals(creneau.getHoraireDepart()) &&
			horaireFin.equals(creneau.getHoraireFin())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retourne les attributs en appelant la methode parse dessus.
	 * @return un String
	 */
	public String parse() {
		return date.parse() + ";" + horaireDepart.parse() + ";" + horaireFin.parse();
	}
}
