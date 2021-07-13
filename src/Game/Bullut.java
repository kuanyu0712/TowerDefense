package Game;

import Enemy.Coordinate;
import Enemy.ImageLoader;

public class Bullut extends Attack
	{
		public Bullut(Coordinate pos, Coordinate target)
		{
			ImageLoader loader = ImageLoader.getLoader();
			this.picture = loader.getImage("picture/coinGold.png");
			// X and Y position of Effect
			this.posX = pos.x;
			this.posY = pos.y;		
			
			// X and Y position of target enemy
			this.velocityX = (target.x - this.posX)*3;
			this.velocityY = (target.y - this.posY)*3;
			
			// Sets time to 0
			this.ageInSeconds = 0;
		}	
	}
