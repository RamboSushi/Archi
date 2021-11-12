package modele;

public class AnneeScolaire {
	private int anneeDepart;
	
	public AnneeScolaire (int anneeDepart) throws IllegalArgumentException {
		if (!this.isValid(anneeDepart)) {
			throw new IllegalArgumentException("Format anneeDepart non conforme");
		} else {
			this.anneeDepart = anneeDepart;
		}
	}
	public AnneeScolaire (String anneeDepart) throws IllegalArgumentException {
		int anneeDepartInt = Integer.parseInt(anneeDepart);
		if (!this.isValid(anneeDepartInt)) {
			throw new IllegalArgumentException("Format anneeDepart non conforme");
		} else {
			this.anneeDepart = anneeDepartInt;
		}
	}

	public int getAnneeDepart() {
		return anneeDepart;
	}
	public void setAnneeDepart(int anneeDepart) {
		this.anneeDepart = anneeDepart;
	}
	
	private boolean isValid(int anneeDepart) {
		if (anneeDepart < 0) return false;
		return true;
	}

	@Override
	public String toString() {
		return anneeDepart + "-" + (anneeDepart+1);
	}
	
	public boolean equals(AnneeScolaire anneeScolaire) {
		if (anneeDepart == anneeScolaire.getAnneeDepart()) {
			return true;
		}
		return false;
	}
	
	public String parse() {
        return String.valueOf(anneeDepart);
    }
}
