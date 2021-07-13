package Map;
//import picture.*;
import java.awt.Image;

import javax.swing.ImageIcon;

public class river {
	public Image river1;
	public Image soil2;
	public java.net.URL img = getClass().getResource("/picture/river_1.png");
	public river(){
		river1 = new ImageIcon(img).getImage();
	    }
}
