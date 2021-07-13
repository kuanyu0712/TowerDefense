package Enemy;

public class Coordinate
{
    // Every object will have an x, y integer.
	
	public int x, y;

	public Coordinate(int x, int y)
	{
		this.x = x;//-35
		this.y = y;//-25
	}
	public int getX()
	{
		return this.x-35; 
	}
	
	public int getY()
	{
		return this.y-25; 
	}
	
	public String toString()
	{
		return ("" + x + " " + y);
	}

}
