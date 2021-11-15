package modele;

public class Ue {
	private String sigle;
	private String nomination;

	/**
	 * cr�er une ue avec des noms sp�cifiques
	 * @param sigle : un String contenant le sigle sp�cifique
	 * @param nomination : un String contenant la nomination sp�cifique
	 */
	public Ue(String sigle, String nomination) {
		this.sigle = sigle;
		this.nomination = nomination;
	}
	
	/**
	 * retourne le sigle d'une ue
	 * @return un String repr�sentant le sigle 
	 */
	public String getSigle() {
		return sigle;
	}
	
	/**
	 * edite le sigle d'une ue
	 * @param sigle : un String contenant le sigle sp�cifique
	 */
	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	/**
	 * retourne la nomination d'une ue
	 * @return un String repr�sentant la nomination
	 */
	public String getNomination() {
		return nomination;
	}

	/**
	 * edite la nomination d'une ue
	 * @param nomination : un String contenant la nomination sp�cifique
	 */
	public void setNomination(String nomination) {
		this.nomination = nomination;
	}


	@Override
	/**
	 * retourne une chaine de caracat�re contenant le sigle et la nomination
	 * @return un String d�crivant une ue
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