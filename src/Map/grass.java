package Map;
//import picture.*;
import java.awt.Image;

import javax.swing.ImageIcon;

public class grass{
	public Image grass1;
	public java.net.URL img = getClass().getResource("/picture/grass_1.png");
	public grass(){
		grass1 = new ImageIcon(img).getImage();
	    }
}