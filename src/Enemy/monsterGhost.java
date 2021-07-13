package Enemy;

	import java.awt.Image;

	import javax.swing.ImageIcon;

	public class monsterGhost extends Enemy  {
		public Image monsterGhost;
		public java.net.URL img = getClass().getResource("/picture/drop.gif");
		public monsterGhost(PathPosition p)
			{
				monsterGhost = new ImageIcon(img).getImage();
				this.enemy = monsterGhost;
				this.position = p;
				this.anchorX = -20;
				this.anchorY = -20;
				this.velocity = 55;
			}

		}
