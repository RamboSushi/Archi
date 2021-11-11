package controlleur;

import modele.*;
import vue.*;

public class Controlleur {	
	public Controlleur(Classe classe, Ue ue, Creneau creneau, Session session, Fenetre fenetre) {
		fenetre.affiche(classe, ue, creneau, session);
	}
}
