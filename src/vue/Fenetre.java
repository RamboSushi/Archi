package vue;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modele.*;

public class Fenetre extends JFrame{
	
	private static final int WIDTH = 500;
	private static final int HEIGHT =500;
	
	
	private JTabbedPane tab = new JTabbedPane();			
	private JPanel classePanel = new JPanel();			
	private JPanel uePanel= new JPanel();				
	private JPanel creneauPanel = new JPanel();		
	private JPanel sessionPanel = new JPanel();		
	
	private UE [] ue = {new UE("a","a"),
						new UE("b","b")
		
	};
	
	private Button[] ueButton = new Button[ue.length];
	
	/*** Constructor ***/
	public Fenetre(){
	    this.setTitle("Archi");
	    this.setSize(WIDTH, HEIGHT);
	    this.setLocationRelativeTo(null);
	    this.setResizable(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    this.getContentPane().setBackground(Color.white);
	    initComponent();
	}
	
	private void initComponent() {
		uePanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		uePanel.setLayout(new GridLayout(1, 1));

		tab.add("UE", uePanel);
	    tab.add("Créneaux", creneauPanel);
	    tab.add("Classes", classePanel);
	    tab.add("Session", sessionPanel);
	    tab.setForeground(new Color(100,100,100));
	    tab.setBackground(Color.white);
	    
	    for(int i = 0; i < ue.length; i++){
			ueButton[i] = new Button(ue[i]);
			ueButton[i].addActionListener(new ueListener());
			uePanel.add(ueButton[i]);
			//tab_button[i].setPreferredSize(dim);
		} 
	    
	    uePanel.add(new JButton("ajouter ue"));
//	    uePanel.add(new JButton("2"));
//	    uePanel.add(new JButton("3"));
//	    uePanel.add(new JButton("4"));
	     
	    
	    this.getContentPane().add(tab);
	}
	
	public void affiche(Classe classe, UE ue, Creneau creneau) {
		System.out.println(classe);
		System.out.println(ue);
		System.out.println(creneau);
	}
	
	class ueListener implements ActionListener {
		 public void actionPerformed(ActionEvent e){
	
		 }
	}
}
