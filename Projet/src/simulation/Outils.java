package simulation;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Outils {

	// Permet de centrer la fenêtre
	public static Rectangle getFrameCoordinates() {
		Toolkit aTk = Toolkit.getDefaultToolkit();
		Dimension screenSize = aTk.getScreenSize();
		return new Rectangle((int) (screenSize.getWidth() - Constantes.FRAME_WIDTH) / 2, (int) (screenSize.getHeight() - Constantes.FRAME_HEIGHT) / 2, Constantes.FRAME_WIDTH, Constantes.FRAME_HEIGHT);
	}
}
