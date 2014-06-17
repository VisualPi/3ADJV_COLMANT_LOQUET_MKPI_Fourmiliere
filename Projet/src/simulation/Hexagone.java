package simulation;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Polygon;

import javax.swing.text.Position;


public class Hexagone {

	private boolean estOccupee;
	private Color couleur;
	
	public Hexagone(boolean estOccupee, Color couleur){
		this.estOccupee = estOccupee;
		this.couleur = couleur;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public boolean isEstOccupee() {
		return estOccupee;
	}

	public void setEstOccupee(boolean estOccupee) {
		this.estOccupee = estOccupee;
	}
	
	public Polygon getPolygon(int x,int y,int cote){// Forme le polygone
		int haut=cote/2;
		int larg=(int)(cote*(Math.sqrt(3)/2));
		Polygon p=new Polygon();
		p.addPoint(x,y+haut);// /
		p.addPoint(x+larg,y); // \
		p.addPoint(x+2*larg,y+haut);// |
		p.addPoint(x+2*larg,y+(int)(1.5*cote)); // /
		p.addPoint(x+larg,y+2*cote);// \
		p.addPoint(x,y+(int)(1.5*cote));// |
		return p;
	}
}
