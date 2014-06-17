package simulation;

import java.awt.Dimension;
import java.awt.Polygon;

public class Polygone extends Polygon{

	private Dimension dimension;
	private simulation.Position position;
	private int cote;
	
	public Polygone(simulation.Position position, int cote){
		this.position = position;
		this.cote = cote;
		int largeur = (int)(cote*(Math.sqrt(3)/2));
		int hauteur = this.cote/2;
		this.dimension = new Dimension(largeur, hauteur);
		int x = this.position.getX();
		int y = this.position.getY();
		super.addPoint(x,y+hauteur);// /
		super.addPoint(x+largeur,y); // \
		super.addPoint(x+2*largeur,y+hauteur);// |
		super.addPoint(x+2*largeur,y+(int)(1.5*this.cote)); // /
		super.addPoint(x+largeur,y+2*this.cote);// \
		super.addPoint(x,y+(int)(1.5*this.cote));
	}
}
