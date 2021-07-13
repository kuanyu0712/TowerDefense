package Factory;

import java.util.List;
import Game.*;

import Enemy.*;
public class leadingRole extends Tower
{
	/**
	 * Constructor
	 */
	public leadingRole(Coordinate pos)
	{
		ImageLoader loader = ImageLoader.getLoader();
		this.tower = loader.getImage("picture/ladar.png");
		this.position = pos;
		this.anchorX = 0;
		this.anchorY = 0;
	}

	@Override
	public void interact(Game game, double deltaTime) {
		timeSinceLastFire += deltaTime;
		
		// if time less than 1.5 seconds, don't interact
		if(timeSinceLastFire < 1)
			return;
		
		List<Enemy> enemies = game.enemies; // new list of enemies
		
		// Gives position of an enemy in enemy list
		for(Enemy e: enemies)
		{	
			
			Coordinate enemyPos = e.getPosition().getCoordinate();

			// Compute distance of enemy to tower
			double dx, dy, dist;	// change in x, y, and total distance
			
			// calculates change in x and y position 
			dx = enemyPos.x - position.x; // x position of enemy - tower
			dy = enemyPos.y - position.y; // y position of enemy - tower
		
			dist = Math.sqrt((dx*dx) + (dy*dy));
			
			Coordinate pos = new Coordinate(position.x, position.y);	
			
			if(dist < 70)
			{	Bullut stardust = new Bullut(pos, enemyPos);
				game.attack.add(stardust);
				timeSinceLastFire = 0;
				return;
			}	
		} 
	}	



	
}
