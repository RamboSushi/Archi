package modele;

public class Ue {
	private String sigle;
	private String nomination;

	public Ue(String sigle, String nomination) {
		this.sigle = sigle;
		this.nomination = nomination;
	}

	public String getSigle() {
		return sigle;
	}
	public void setSigle(String sigle) {
		this.sigle = sigle;
	}


	public String getNomination() {
		return nomination;
	}

	public void setNomination(String nomination) {
		this.nomination = nomination;
	}

	@Override
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
