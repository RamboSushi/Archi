package controlleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import modele.*;

public class Parser {
	private String path = new String();
	
	public Parser() {
		String OS = new String(System.getProperty("os.name").toLowerCase()); //detection OS
		if ((OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0)) {
			path = Paths.get("").toAbsolutePath().toString() + "/data/";
		} else if (OS.indexOf("win") >= 0) {
			path = Paths.get("").toAbsolutePath().toString() + "\\data\\";
		} else if (OS.indexOf("mac") >= 0) {
			path = Paths.get("").toAbsolutePath().toString() + "/data/";
		} else if (OS.indexOf("sunos") >= 0) {
			path = Paths.get("").toAbsolutePath().toString() + "/data/";
		} else {
			path = Paths.get("").toAbsolutePath().toString();
		}

		Path pathdir = Paths.get(path);
		try {
			Files.createDirectories(pathdir); //creation repertoire /data/ si besoin
		} catch (IOException e) {
			System.out.println("Erreur creation repertoire data");
			e.printStackTrace();
		}
	}
	
	public void write(String str, Class<?> c) { // str=string à ecrire (xxx.parse()) - c=classe de l'objet (xxx.class)
		FileWriter writer = null;
		File file = null;
		switch(c.getSimpleName()) {
			case "Classe":
				file = new File(path+"classe.txt");
				break;
			case "Ue":
				file = new File(path+"ue.txt");
				break;
			case "Creneau":
				file = new File(path+"creneau.txt");
				break;
			case "Session":
				file = new File(path+"session.txt");
				break;
			default:
				System.out.println("default");
		}
		try {
			writer = new FileWriter(file.getPath(), true);
			writer.append(str + "\r\n");
			writer.close();
		} catch (IOException e) {
			System.out.println("Erreur ecriture fichier");
			e.printStackTrace();
		}
	}
	
	public void remove(String str, Class<?> c) { // str=string à retirer (xxx.parse()) - c=classe de l'objet (xxx.class)
		String allstr = new String();
		BufferedReader reader = null;
		FileWriter writer = null;
		File file = null;
		switch(c.getSimpleName()) {
			case "Classe":
				file = new File(path+"classe.txt");
				break;
			case "Ue":
				file = new File(path+"ue.txt");
				break;
			case "Creneau":
				file = new File(path+"creneau.txt");
				break;
			case "Session":
				file = new File(path+"session.txt");
				break;
			default:
				System.out.println("default");
		}
		try {
			file.createNewFile();
			reader = new BufferedReader(new FileReader(file.getPath()));
			while(true) {
				String line = reader.readLine();
				if (line == null) break;
				if (!line.equals(str)) {
					allstr += line + "\r\n";
				} else {
					while(true) {
						line = reader.readLine();
						if (line == null) break;
						allstr += line + "\r\n";
					}
				}
			}
			writer = new FileWriter(file.getPath());
			writer.write(allstr);
			writer.close();
		} catch (IOException e) {
			System.out.println("Erreur suppression fichier");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Object> read(Class<?> c) {// c=classe de l'objet (xxx.class)
		BufferedReader reader = null;
		File file = null;
		ArrayList<Object> obj = new ArrayList<Object>();
		switch(c.getSimpleName()) {
			case "Classe":
				file = new File(path+"classe.txt");
				break;
			case "Ue":
				file = new File(path+"ue.txt");
				break;
			case "Creneau":
				file = new File(path+"creneau.txt");
				break;
			case "Session":
				file = new File(path+"session.txt");
				break;
			default:
				System.out.println("default");
				break;
		}
		try {
			file.createNewFile();
			reader = new BufferedReader(new FileReader(file.getPath()));
			String[] tokens = null;
			while(true) {
				String line = reader.readLine();
				if (line == null) break;
				tokens = line.split(";");
				switch(c.getSimpleName()) {
					case "Classe":
						Classe classe = new Classe(tokens[0],tokens[1]);
						obj.add(classe);
						continue;
					case "Ue":
						Ue ue = new Ue(tokens[0],tokens[1]);
						obj.add(ue);
						continue;
					case "Creneau":
						Creneau creneau = new Creneau(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]);
						obj.add(creneau);
						continue;
					case "Session":
						Ue ueS = new Ue(tokens[0],tokens[1]);
						Classe classeS = new Classe(tokens[2],tokens[3]);
						ArrayList<Creneau> creneauxS = new ArrayList<>();
						for(int i=4; i<tokens.length; i+=7) {
							Creneau creneauS = new Creneau(tokens[i],tokens[i+1],tokens[i+2],tokens[i+3],tokens[i+4],tokens[i+5],tokens[i+6]);
							creneauxS.add(creneauS);
						}
						Session session = new Session(ueS,classeS,creneauxS);
						obj.add(session);
						continue;
					default:
						System.out.println("default");
						continue;
				}
			}
		} catch (IOException e) {
			System.out.println("Erreur lecture fichier");
			e.printStackTrace();
		}
		return obj;
	}

	public String getPath() {
		return path;
	}
}
