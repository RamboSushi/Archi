package controlleur;

import com.thoughtworks.xstream.XStream;

import modele.*;
import vue.*;

public class Archi {
	public static void main(String[] args) {
		Classe classe = new Classe("IATIC5", 2020);
		UE ue = new UE("ARC", "EU-Archi");
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
		
//		XStream xstream = new XStream();
//		String xml = xstream.toXML(ue);
//		System.out.println(xml);
		
		System.out.println();
		Controlleur controlleur = new Controlleur(classe, ue, creneau1, session, fenetre);
    }
}