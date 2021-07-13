package Enemy;

import java.awt.Image;

import javax.swing.ImageIcon;

public class monsterMush extends Enemy  {
	public Image monsterMush;
	public java.net.URL img = getClass().getResource("/picture/й╟кл3.gif");
	public monsterMush(PathPosition p)
		{
			monsterMush = new ImageIcon(img).getImage();
			this.enemy = monsterMush;
			this.position = p;
			this.anchorX = -20;
			this.anchorY = -20;
			this.velocity = 10;
		}

	}

/*ImageLoader loader = ImageLoader.getLoader();
			this.enemy = loader.getImage("picture/й╟кл2.gif");
			this.position = p;
			this.anchorX = -20;
			this.anchorY = -20;
			this.velocity = 0.5;*/
