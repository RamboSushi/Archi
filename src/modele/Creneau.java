package modele;

public class Creneau {
	private DateScolaire date;
	private HeureScolaire horaireDepart, horaireFin;
	
	public Creneau(int jour, int mois, int annee,
					int heureDepart, int minuteDepart,
					int heureFin, int minuteFin) {
		date = new DateScolaire(jour, mois, annee);
		horaireDepart = new HeureScolaire(heureDepart, minuteDepart);
		horaireFin = new HeureScolaire(heureFin, minuteFin);
	}
	public Creneau(String jour, String mois, String annee,
					String heureDepart, String minuteDepart,
					String heureFin, String minuteFin) {
		date = new DateScolaire(jour, mois, annee);
		horaireDepart = new HeureScolaire(heureDepart, minuteDepart);
		horaireFin = new HeureScolaire(heureFin, minuteFin);
	}
	
	public DateScolaire getDate() {
		return date;
	}
	public void setDate(DateScolaire date) {
		this.date = date;
	}
	
	public HeureScolaire getHoraireDepart() {
		return horaireDepart;
	}
	public void setHoraireDepart(HeureScolaire horaireDepart) {
		this.horaireDepart = horaireDepart;
	}
	
	public HeureScolaire getHoraireFin() {
		return horaireFin;
	}
	public void setHoraireFin(HeureScolaire horaireFin) {
		this.horaireFin = horaireFin;
	}
	
	@Override
	public String toString() {
		return date + " " + horaireDepart + "->" + horaireFin;
	}
	
	public boolean equals(Creneau creneau) {
		if (date.equals(creneau.getDate()) &&
			horaireDepart.equals(creneau.getHoraireDepart()) &&
			horaireFin.equals(creneau.getHoraireFin())) {
			return true;
		}
		return false;
	}
}
