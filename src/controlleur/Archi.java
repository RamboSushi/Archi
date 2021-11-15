package controlleur;

import vue.*;

public class Archi {
	public static void main(String[] args) {

		Parser parser = new Parser();
		Fenetre fenetre = new Fenetre();
		
		@SuppressWarnings("unused")
		Controlleur controlleur = new Controlleur(fenetre, parser);
	}
}
