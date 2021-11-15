package modele;

public class Ue {
	private String sigle;
	private String nomination;

	/**
	 * créer une ue avec des noms spécifiques
	 * @param sigle : un String contenant le sigle spécifique
	 * @param nomination : un String contenant la nomination spécifique
	 */
	public Ue(String sigle, String nomination) {
		this.sigle = sigle;
		this.nomination = nomination;
	}
	
	/**
	 * retourne le sigle d'une ue
	 * @return un String représentant le sigle 
	 */
	public String getSigle() {
		return sigle;
	}
	
	/**
	 * edite le sigle d'une ue
	 * @param sigle : un String contenant le sigle spécifique
	 */
	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	/**
	 * retourne la nomination d'une ue
	 * @return un String représentant la nomination
	 */
	public String getNomination() {
		return nomination;
	}

	/**
	 * edite la nomination d'une ue
	 * @param nomination : un String contenant la nomination spécifique
	 */
	public void setNomination(String nomination) {
		this.nomination = nomination;
	}


	@Override
	/**
	 * retourne une chaine de caracatère contenant le sigle et la nomination
	 * @return un String décrivant une ue
	 */
	public String toString() {
		return sigle + ":" + nomination;
	}
	
	
	public boolean equals(Ue ue) {
		if (nomination.equals(ue.getNomination()) &&
			sigle.equals(ue.getSigle())) {
			return true;
		}
		return false;
	}
	
	public String parse() {
		return sigle + ";" + nomination;
	}
}