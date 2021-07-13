package Factory;
import Enemy.*;
import Game.Game;

import java.awt.Graphics;
import java.awt.Image;

abstract public class Tower 
{
	/* instance variables */
	protected Coordinate position;	// holds position of tower
	protected Image tower; 			// holds tower image
	protected int anchorX;			// shifts X coordinate
	protected int anchorY;			// shifts Y coordinate
	protected double timeSinceLastFire;// time since last effect was fired
	public void draw(Graphics g)
	{
		g.drawImage(tower, position.getX() + anchorX, position.getY() + anchorY, null);
	}
	public void setPosition(Coordinate c)
	{
		position = c;
	}
	
	public abstract void interact(Game game, double deltaTime);
}
