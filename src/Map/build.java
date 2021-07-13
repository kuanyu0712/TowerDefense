package Map;
import java.awt.Image;

import javax.swing.ImageIcon;

public class build{
	public Image Build;
	public java.net.URL img = getClass().getResource("/picture/build.png");
	public build(){
		Build = new ImageIcon(img).getImage();
	    }
}