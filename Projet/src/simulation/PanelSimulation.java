package simulation;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;

import javax.swing.JPanel;


public class PanelSimulation extends JPanel{
	private Hexagone[][] terrain;
	final static int cote=15; // Ceci définit la taille du côté d'un polygone
	Polygon pol;
	
	public PanelSimulation(Hexagone[][] terrain){
		this.terrain = terrain;
	}

	public Hexagone[][] getTerrain() {
		return terrain;
	}

	public void setTerrain(Hexagone[][] terrain) {
		this.terrain = terrain;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		Polygon p2=getPolygon(0, 0, cote); // Crée un hexagone
		Rectangle r=p2.getBounds(); // Récupère le plus petit rectangle // aux bord de la fenêtre dans lequel l'hexagone peut s'inscrire
		Point hovered=null;
		g.setColor(Color.black);
		super.paint(g);
		Graphics2D g2d;
		
		
		
		g2d=(Graphics2D) g;
		BasicStroke bs1=new BasicStroke(1);// Permet de fixer l'épaisseur du trait dans la suite
		BasicStroke bs3=new BasicStroke(3);// Idem
		
		g2d.setStroke(bs1);

		
		for(int l=0;l<20;l=l+2){// Remarquer le "+2" car la grille est constituée de 2 sous grilles (les lignes impaires sont décallées)
			for(int c=0;c<20;c++){
				//Point p;
				//p=getMousePosition();
				Hexagone caseCourante = this.terrain[l][c];
				Polygon poly=caseCourante.getPolygon(c*r.width, (int)(l*cote*1.5),cote);
				/*if(p!=null && poly.contains(p)){
					hovered=new Point(c*r.width, (int)(l*cote*1.5));
					//numero=l*10+c;
					pol=poly;
				}*/
				//new Color(60,60,255)
				g2d.setColor(caseCourante.getCouleur());
				g2d.draw(poly);
			}
		}
		for(int l=1;l<20;l=l+2){
			for(int c=0;c<20;c++)
			{
				//Point p;
				//p=getMousePosition();
				Hexagone caseCourante = this.terrain[l][c];
				Polygon poly=caseCourante.getPolygon(c*r.width+r.width/2,  (int)(l*cote*1.5+0.5),cote);
				//arg0.setColor(Color.black);
				/*if(p!=null && poly.contains(p)){
					hovered=new Point(c*r.width+r.width/2,  (int)(l*cote*1.5+0.5));
					//numero=l*10+c;
					pol=poly;
				}*/
				g2d.setColor(caseCourante.getCouleur());
				g2d.draw(poly);
			}
		}
		
		/*for(int i=0; i< this.terrain.length; i++){
			for(int j=0; j< this.terrain[i].length; j++){
				Hexagone caseCourante = this.terrain[i][j];
				g.setColor(caseCourante.getCouleur());
				int x = caseCourante.getPosition().getX();
				int y = caseCourante.getPosition().getY();
				int w = (int) caseCourante.getDimension().getWidth();
				int h = (int) caseCourante.getDimension().getHeight();
				
				g.drawRect(x, y, w, h);
				//g.fillRect(x, y, w, h);
			}
		}*/
		
	}
	
	public Polygon getPolHover(){
		return pol;
	}

	public static Polygon getPolygon(int x,int y,int cote){// Forme le polygone
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
