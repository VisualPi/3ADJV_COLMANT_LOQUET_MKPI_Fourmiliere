package simulation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.Context;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FenetreSaisie extends JFrame{
	
	private JPanel panelNord;
	private JPanel panelSud;
	private JPanel panelCentre;
	
	private JTextField valueNbFourmis;
	private JTextField valueNbNourriture;
	private JTextField valuePheromone;
	private JTextField valueSimulation;
	
	private Rendu rendu;
	
	/*La fenêtre elle-même*/
	private final FenetreSaisie context = this;
	
	public FenetreSaisie(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fermeture de la fenetre -> arret du programme
		this.setTitle (Constantes.FRAME_TITLE);
		this.setBounds(Outils.getFrameCoordinates());
		this.init();
		this.setVisible(true);
	}
	
	public void init(){
		this.add(this.getPanelNord(), BorderLayout.NORTH);
		this.add(this.getPanelSud(), BorderLayout.SOUTH);
		this.add(this.getPanelCentre(), BorderLayout.CENTER);
		this.rendu = new Rendu("Simulation");
		pack();
	}
	
	public JPanel getPanelNord(){
		this.panelNord = new JPanel();
		this.panelNord.setBackground(Color.WHITE);
		this.panelNord.setBorder(BorderFactory.createEtchedBorder());
		JLabel parametres = new JLabel("Paramètres");
		this.panelNord.add(parametres);
		return this.panelNord;
	}
	
	public JPanel getPanelSud(){
		this.panelSud = new JPanel();
		this.panelSud.setBackground(Color.WHITE);
		this.panelSud.setBorder(BorderFactory.createEtchedBorder());
		JButton sauvegarder = new JButton("Sauvegarder");
		JButton charger = new JButton("Charger");
		JButton simulation = new JButton("Lancer");
		sauvegarder.addActionListener(new EcouteurSimulation());
		charger.addActionListener(new EcouteurSimulation());
		simulation.addActionListener(new EcouteurSimulation());
		this.panelSud.add(sauvegarder);
		this.panelSud.add(charger);
		this.panelSud.add(simulation);
		return this.panelSud;
	}
	
	public JPanel getPanelCentre(){
		this.panelCentre = new JPanel();
		this.panelCentre.setBackground(Color.WHITE);
		this.panelCentre.setLayout(new GridLayout(4, 1));
		
		JLabel nbFourmis = new JLabel("    Nombre de fourmis :");
		JLabel nbNourriture = new JLabel("    Quantité de nourriture :");
		JLabel vitessePheromone = new JLabel("    Vitesse de disparition des phéromones :");
		JLabel vitesseSimulation = new JLabel("    Vitesse de simulation :");
		
		this.valueNbFourmis = new JTextField("5");
		this.valueNbNourriture = new JTextField("5");
		this.valuePheromone = new JTextField("5");
		this.valueSimulation = new JTextField("5");

		this.panelCentre.add(nbFourmis);
		this.panelCentre.add(this.valueNbFourmis);
		this.panelCentre.add(nbNourriture);
		this.panelCentre.add(this.valueNbNourriture);
		this.panelCentre.add(vitessePheromone);
		this.panelCentre.add(this.valuePheromone);
		this.panelCentre.add(vitesseSimulation);
		this.panelCentre.add(this.valueSimulation);
		
		return this.panelCentre;
	}
	
	public void sauvegarder(){
		
	}
	
	public void charger(){
		
	}
	
	class EcouteurSimulation implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String label = e.getActionCommand();
			if(label.equals("Lancer")){
				context.dispose();
				rendu.setVisible(true);
			}
			if(label.equals("Sauvegarder")){
				sauvegarder();
			}
			if(label.equals("Charger")){
				charger();
			}
			
		}
		
	}

}
