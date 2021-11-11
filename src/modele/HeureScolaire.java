package modele;

class HeureScolaire {
	private int heure, minute;
	
	public HeureScolaire(int heure, int minute) throws IllegalArgumentException {
		if (!this.isValid(heure, minute)) {
			throw new IllegalArgumentException("Format heure:minute non conforme");
		} else {
			this.heure = heure;
			this.minute = minute;
		}
	}
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

	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}

	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	private boolean isValid(int heure, int minute) {
		if ((heure<0) || (heure>23)) return false;
		if ((minute<0) || (minute>59)) return false;
		return true;
	}

	public boolean compateTo(HeureScolaire heureScolaire) {
		return (heure <= heureScolaire.getHeure()) && (minute <= heureScolaire.getMinute());
	}
	
	@Override
	public String toString() {
		return String.format("%02d", heure) + ":" + String.format("%02d", minute);
	}
	
	public boolean equals(HeureScolaire heureScolaire) {
		if (heure == heureScolaire.getHeure() &&
			minute == heureScolaire.getMinute()) {
			return true;
		}
		return false;
	}
	
	public String parse() {
		return heure + ";" + minute;
	}
}
