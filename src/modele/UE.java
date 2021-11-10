package modele;

import java.util.UUID;

public class UE {
	private String id = UUID.randomUUID().toString(), sigle, nomination;

	public UE(String sigle, String nomination) {
		this.sigle = sigle;
		this.nomination = nomination;
	}

	public String getId() {
		return id;
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
		return sigle + " " + nomination;
	}
}
