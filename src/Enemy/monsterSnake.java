package Enemy;

import java.awt.Image;

import javax.swing.ImageIcon;

public class monsterSnake extends Enemy  {
	public Image monsterSnake;
	public java.net.URL img = getClass().getResource("/picture/й╟кл5.gif");
	public monsterSnake(PathPosition p)
		{
			monsterSnake = new ImageIcon(img).getImage();
			this.enemy = monsterSnake;
			this.position = p;
			this.anchorX = -20;
			this.anchorY = -20;
			this.velocity = 13;
		}

	}