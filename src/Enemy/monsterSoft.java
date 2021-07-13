package Enemy;

import java.awt.Image;

import javax.swing.ImageIcon;

	public class monsterSoft extends Enemy  {
		public Image monsterSoft;
		public java.net.URL img = getClass().getResource("/picture/drop_2.gif");
		public monsterSoft(PathPosition p)
			{
			monsterSoft = new ImageIcon(img).getImage();
				this.enemy = monsterSoft;
				this.position = p;
				this.anchorX = -20;
				this.anchorY = -20;
				this.velocity = 40;
			}

		}