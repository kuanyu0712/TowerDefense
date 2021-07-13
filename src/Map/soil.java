package Map;
//import picture.*;
import java.awt.Image;

import javax.swing.ImageIcon;

public class soil {
	public Image soilBetween;
	public Image soilUpDown;
	public Image soilRightBelow;
	public Image soilLeftBelow;
	public Image soilRightUp;
	public Image soilLeftUp;
	public java.net.URL img_1 = getClass().getResource("/picture/soil_ri_up.png");
	public java.net.URL img_2 = getClass().getResource("/picture/soil_between.png");
	public java.net.URL img_3 = getClass().getResource("/picture/soil_ri_be.png");
	public java.net.URL img_4 = getClass().getResource("/picture/soil_up_down.png");
	public java.net.URL img_5 = getClass().getResource("/picture/soil_le_be.png");
	public java.net.URL img_6 = getClass().getResource("/picture/soil_le_up.png");
	public soil(){
		soilRightUp = new ImageIcon(img_1).getImage();
		soilBetween = new ImageIcon(img_2).getImage();
		soilRightBelow = new ImageIcon(img_3).getImage();
		soilUpDown= new ImageIcon(img_4).getImage();
		soilLeftBelow= new ImageIcon(img_5).getImage();
		soilLeftUp= new ImageIcon(img_6).getImage();
	    }
}
