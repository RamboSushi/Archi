package modele;

import java.util.ArrayList;

public class Session {
	private Ue ue;
	private Classe classe;
	private ArrayList<Creneau> creneaux = new ArrayList<>();
	
	public Session(Ue ue, Classe classe) {
		this.ue = ue;
		this.classe = classe;
	}
	public Session(Ue ue, Classe classe, ArrayList<Creneau> creneaux) {
		this.ue = ue;
		this.classe = classe;
		this.creneaux = creneaux;
	}
	
	public void ajoutCreneau(Creneau creneau) {
		creneaux.add(creneau);
	}
	
	public void retirerCreneau(Creneau creneau) {
		creneaux.remove(creneau);
	}
	
	public boolean existeCreneau(Creneau creneau) {
		for (int i=0; i<creneaux.size(); i++) {
			if(creneau.equals(creneaux.get(i))){
				return true;
			}
		}
		return false;
	}
	
	public Creneau findCreneau(String jour, String mois,String annee, String heureDepart, String minuteDepart, String heureFin, String minuteFin) {
		Creneau creneau = new Creneau(jour, mois, annee, heureDepart, minuteDepart, heureFin, minuteFin);
		for (int i=0; i<creneaux.size(); i++) {
			if (creneau.equals(creneaux.get(i))) {
			return creneaux.get(i);
			}
		}
	return null;
		}
	public Creneau findCreneau(int jour, int mois, int annee, int heureDepart, int minuteDepart, int heureFin, int minuteFin) {
		Creneau creneau = new Creneau(jour, mois, annee, heureDepart, minuteDepart, heureFin, minuteFin);
		for (int i=0; i<creneaux.size(); i++) {
			if (creneau.equals(creneaux.get(i))) {
				return creneaux.get(i);
			}
		}
		return null;
	}
	public Creneau findCreneau(Creneau creneau) {
		for (int i=0; i<creneaux.size(); i++) {
			if (creneau.equals(creneaux.get(i))) {
				return creneaux.get(i);
			}
		}
		return null;
	}
	
	public Ue getUe() {
		return ue;
	}
	public void setUe(Ue ue) {
		this.ue = ue;
	}
	
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	public ArrayList<Creneau> getCreneaux() {
		return creneaux;
	}
	public void setCreneaux(ArrayList<Creneau> creneaux) {
		this.creneaux = creneaux;
	}
	
	@Override
	public String toString() {
		String str = new String(ue + " avec " + classe + " le : [");
		for (int i=0; i<creneaux.size(); i++) {
			str += "[" + creneaux.get(i) + "],";
		}
		str = str.substring(0, str.length()-1);
		str += "]";
		return str;
	}
	
	public boolean equals(Session session) {
		if (ue.equals(session.getUe()) &&
			classe.equals(session.getClasse()) &&
			creneaux.equals(session.getCreneaux())) {
			return true;
		}
		return false;
	}
	
	public String parse() {
		String str = new String(ue.parse() + ";" + classe.parse());
		for (int i=0; i<creneaux.size(); i++) {
			str += ";" + creneaux.get(i).parse();
		}
		return str;
	}
}
