package controlleur;

import modele.*;
import vue.*;

public class Archi {
	public static void main(String[] args) {
		Classe classe = new Classe("IATIC5", 2020);
		Ue ue = new Ue("ARC", "UE-Archi");
		Creneau creneau1 = new Creneau(9, 11, 2021, 8, 5, 12, 30);
		Creneau creneau2 = new Creneau(9, 11, 2021, 14, 00, 17, 00);
		Session session = new Session(ue, classe);

		session.ajoutCreneau(creneau1);
		if (!session.existeCreneau(creneau2)) {
			session.ajoutCreneau(creneau2);
		}
		if (!session.existeCreneau(creneau2)) {
			session.ajoutCreneau(creneau2);
		}

		System.out.println(session.existeCreneau(creneau2));
		System.out.println(session.findCreneau(creneau2));
		Creneau creneau3 = new Creneau(10, 11, 2021, 14, 00, 17, 00);
		System.out.println(session.existeCreneau(creneau3));
		System.out.println(session.findCreneau(creneau3));

		Fenetre fenetre = new Fenetre();

		System.out.println();
		Controlleur controlleur = new Controlleur(classe, ue, creneau1, session, fenetre);
		System.out.println();

		System.out.println(ue.parse());
		System.out.println(classe.parse());
		System.out.println(creneau1.parse());
		System.out.println(session.parse());

		Parser parser = new Parser();
		parser.write(ue.parse(), Ue.class);
		parser.write(classe.parse(), Classe.class);
		parser.write(creneau1.parse(), Creneau.class);
		parser.write(creneau2.parse(), Creneau.class);
		parser.write(creneau2.parse(), Creneau.class);
		parser.write(creneau3.parse(), Creneau.class);
		parser.write(session.parse(), Session.class);

		parser.remove(creneau2.parse(), Creneau.class);
	}
}
