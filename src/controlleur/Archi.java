package controlleur;


import modele.*;
import vue.*;

public class Archi {
	public static void main(String[] args) {
		Classe classe = new Classe("IATIC5", 2020, 2021);
		UE ue = new UE("ARC", "EU-Archi");
		Creneau creneau = new Creneau(9, 11, 2021, 20, 22);
		
		Fenetre fenetre = new Fenetre();
		
		
		
		Controlleur controlleur = new Controlleur(classe, ue, creneau, fenetre);
    }
}