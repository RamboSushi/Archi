package controlleur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Parser {
	private String path = new String();
	
	public Parser() {
		String OS = new String(System.getProperty("os.name").toLowerCase().toLowerCase());
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
	}
	
	public void write(String str, Class<?> c) {
		FileWriter writer = null;
		File file = null;
		switch(c.getSimpleName()) {
			case "Classe":
				file = new File(path+"classe.txt");;
				break;
			case "Ue":
				file = new File(path+"ue.txt");;
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
	
	public void remove(String str, Class<?> c) {
		String allstr = new String();
		BufferedReader reader = null;
		FileWriter writer = null;
		File file = null;
		switch(c.getSimpleName()) {
			case "Classe":
				file = new File(path+"classe.txt");;
				break;
			case "Ue":
				file = new File(path+"ue.txt");;
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
			System.out.println("Erreur ecriture fichier");
			e.printStackTrace();
		}
	}

	public String getPath() {
		return path;
	}
}
