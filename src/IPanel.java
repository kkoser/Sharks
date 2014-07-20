import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class IPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image = null;

	public IPanel(String fileName) throws IOException {
	    image = ImageIO.read(new File(fileName));
	  }
	
	@Override
	public void paintComponent(final Graphics g) {
	    super.paintComponent(g);
	    if (image != null) {
	        g.drawImage(image, 0, 0, null);
	        System.out.println( "Drawing the bg image" );
	    }
	}
}