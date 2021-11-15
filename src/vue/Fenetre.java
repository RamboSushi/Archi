package vue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Color;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int WIDTH = 550;
	private static final int HEIGHT =550;


	private JTabbedPane tab = new JTabbedPane();
	private JPanel classePanel = new JPanel();
	private JPanel uePanel= new JPanel();
	private JPanel creneauPanel = new JPanel();
	private JPanel sessionPanel = new JPanel();

	private UETab ueTab = new UETab(uePanel);
	private CreneauTab creneauTab = new CreneauTab(creneauPanel);
	private ClasseTab classeTab = new ClasseTab(classePanel);
	private SessionTab sessionTab = new SessionTab(sessionPanel);

	/**
	 * Créer un nouvelle fenêtre d'affichage
	 */
	public Fenetre(){
	    this.setTitle("Archi");
	    this.setSize(WIDTH, HEIGHT);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.getContentPane().setBackground(Color.white);
	    initComponent();
	}

	/**
	 * initialise les composants de la fenetre
	 */
	private void initComponent() {

		tab.add("UE", uePanel);
		tab.add("Creneaux", creneauPanel);
		tab.add("Classes", classePanel);
		tab.add("Session", sessionPanel);
		tab.setForeground(new Color(100,100,100));
		tab.setBackground(Color.white);

	    this.getContentPane().add(tab);
	}

	/**
	 * retourne l'onglet Ue
	 * @return une Ue contenant l'onglet ue
	 */
	public UETab getUETab() {
		return this.ueTab;
	}
	
	/**
	 * retourne l'onglet creneau
	 * @return un Creneau contenant l'onglet creneau
	 */
	public CreneauTab getCreneauTab() {
		return this.creneauTab;
	}
	
	/**
	 * retourne l'onglet classe
	 * @return une Classe contenant l'onglet classe
	 */
	public ClasseTab getClasseTab() {
		return this.classeTab;
	}
	
	/**
	 * retourne l'onglet session
	 * @return un Session contenant l'onglet session
	 */
	public SessionTab getSessionTab() {
		return this.sessionTab;
	}
}
