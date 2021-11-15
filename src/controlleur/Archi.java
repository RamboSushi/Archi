package controlleur;

import java.util.ArrayList;

import modele.*;
import vue.*;

public class Archi {
	public static void main(String[] args) {
		/*
		Classe classe = new Classe("IATIC5", 2020);
		Ue ue = new Ue("ARC", "UE-Archi");
		Creneau creneau1 = new Creneau(9, 11, 2021, 8, 5, 12, 30);
		Creneau creneau2 = new Creneau(9, 11, 2021, 14, 00, 17, 00);
		Session session = new Session(ue, classe);
		session.ajoutCreneau(creneau1);
		session.ajoutCreneau(creneau2);
		*/

		Parser parser = new Parser();
		/*
		parser.write(classe.parse(), Classe.class);
		parser.write(ue.parse(), Ue.class);
		parser.write(creneau1.parse(), Creneau.class);
		parser.write(creneau2.parse(), Creneau.class);
		parser.write(session.parse(), Session.class);
		*/
		Fenetre fenetre = new Fenetre();
		Controlleur controlleur = new Controlleur(fenetre, parser);
	}
}
