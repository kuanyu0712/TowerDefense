package Enemy;

import java.awt.Image;

import javax.swing.ImageIcon;

public class monsterCow extends Enemy  {
	public Image monsterCow;
	public java.net.URL img = getClass().getResource("/picture/�Ǫ�4.gif");
	public monsterCow(PathPosition p)
		{
			monsterCow = new ImageIcon(img).getImage();
			this.enemy = monsterCow;
			this.position = p;
			this.anchorX = -20;
			this.anchorY = -20;
			this.velocity = 15;
		}

	}