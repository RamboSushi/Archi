package modele;

class AnneeScolaire {
	private int anneeDepart, anneeFin;
	
	public AnneeScolaire (int anneeDepart, int anneeFin) throws IllegalArgumentException {
		if (!this.isValid(anneeDepart, anneeFin)) {
			throw new IllegalArgumentException("Format anneeDepart-anneeFin non conforme");
		} else {
			this.anneeDepart = anneeDepart;
			this.anneeFin = anneeFin;
		}
	}
	public AnneeScolaire (String anneeDepart, String anneeFin) throws IllegalArgumentException {
		int anneeDepartInt = Integer.parseInt(anneeDepart);
		int anneeFinInt = Integer.parseInt(anneeFin);
		if (!this.isValid(anneeDepartInt, anneeFinInt)) {
			throw new IllegalArgumentException("Format anneeDepart-anneeFin non conforme");
		} else {
			this.anneeDepart = anneeDepartInt;
			this.anneeFin = anneeFinInt;
		}
	}

	public int getAnneeDepart() {
		return anneeDepart;
	}
	public void setAnneeDepart(int anneeDepart) {
		this.anneeDepart = anneeDepart;
	}

	public int getAnneeFin() {
		return anneeFin;
	}
	public void setAnneeFin(int anneeFin) {
		this.anneeFin = anneeFin;
	}
	
	private boolean isValid(int anneeDepart, int anneeFin) {
		if (anneeDepart < 0) return false;
		if (anneeFin < 0) return false;
		if (anneeDepart >= anneeFin) return false;
		if (anneeFin-anneeDepart != 1) return false;
		return true;
	}

	@Override
	public String toString() {
		return this.anneeDepart + "-" + this.anneeFin;
	}
}
