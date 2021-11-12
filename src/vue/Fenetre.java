package vue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Color;

public class Fenetre extends JFrame{

	private static final int WIDTH = 500;
	private static final int HEIGHT =500;


	private JTabbedPane tab = new JTabbedPane();
	private JPanel classePanel = new JPanel();
	private JPanel uePanel= new JPanel();
	private JPanel creneauPanel = new JPanel();
	private JPanel sessionPanel = new JPanel();

	private UETab ueTab = new UETab(uePanel);
	private CreneauTab creneauTab = new CreneauTab(creneauPanel);
	private ClasseTab classeTab = new ClasseTab(classePanel);
	private SessionTab sessionTab = new SessionTab(sessionPanel);

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

		tab.add("UE", uePanel);
	    tab.add("Cr�neaux", creneauPanel);
	    tab.add("Classes", classePanel);
	    tab.add("Session", sessionPanel);
	    tab.setForeground(new Color(100,100,100));
	    tab.setBackground(Color.white);

	    this.getContentPane().add(tab);
	}


	public UETab getUETab() {
		return this.ueTab;
	}
	public CreneauTab getCreneauTab() {
		return this.creneauTab;
	}
	
	public ClasseTab getClasseTab() {
		return this.classeTab;
	}
	
	public SessionTab getSessionTab() {
		return this.sessionTab;
	}
}
