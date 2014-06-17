package simulation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rendu extends JFrame{
	
	private PanelSimulation panel;
	private Hexagone[][] terrain;
	
	public Rendu(String name){
		this.setSize(400, 400);//dimensions 
		this.setTitle(name);//titre
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fermeture de la fenetre -> arret du programme
	    //Position de la fenetre 
	    this.setLayout(new BorderLayout());
	    this.setBounds(Outils.getFrameCoordinates());
	    this.init();
	}
	
	public void init(){
		this.terrain = new Hexagone[Constantes.NB_CASES][Constantes.NB_CASES];
		this.panel = new PanelSimulation(terrain);
		this.panel.setPreferredSize(this.getPreferredSize());
		for(int i=0; i<Constantes.NB_CASES; i++){
			for(int j=0; j<Constantes.NB_CASES; j++){
				Color couleur = new Color(122,255,122);
				Dimension dimension = new Dimension(20, 20);
				simulation.Position position = new Position(i*20,j*20);
				this.terrain[i][j] = new Hexagone(false, couleur);
			}
		}
		
		this.add(panel, BorderLayout.CENTER);
	}
}
