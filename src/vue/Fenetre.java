package vue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Color;

import modele.*;

public class Fenetre extends JFrame{
	
	private static final int WIDTH = 500;
	private static final int HEIGHT =500;
	
	
	private JTabbedPane tab = new JTabbedPane();
	private JPanel classePanel = new JPanel();			
	private JPanel uePanel= new JPanel();				
	private JPanel creneauPanel = new JPanel();		
	private JPanel sessionPanel = new JPanel();		
	
	
	
	/*** Constructor ***/
	public Fenetre(){
	    this.setTitle("Archi");
	    this.setSize(WIDTH, HEIGHT);
	    this.setLocationRelativeTo(null);
	    this.setResizable(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    this.getContentPane().setBackground(Color.white);
	    initComponent();
	    //init_creneau_Component();
	}
	
	private void initComponent() {
		UETab ueTab = new UETab(uePanel);
		CreneauTab creneauTab = new CreneauTab(creneauPanel);

		tab.add("UE", uePanel);
	    tab.add("Créneaux", creneauPanel);
	    tab.add("Classes", classePanel);
	    tab.add("Session", sessionPanel);
	    tab.setForeground(new Color(100,100,100));
	    tab.setBackground(Color.white);
	    
	    this.getContentPane().add(tab);
	}
	
	
	public void affiche(Classe classe, UE ue, Creneau creneau) {
		System.out.println(classe);
		System.out.println(ue);
		System.out.println(creneau);
	}
	
}
