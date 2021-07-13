package Game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements MouseListener, MouseMotionListener
{
    private static final long serialVersionUID = -266426690684141363L;
	public Thread gameThread;
    private Game enclosingGame;  	// A reference back to the Game object that created 'this' object.
    public int mouseX;				// Tracks X position of mouse events
    public int mouseY;				// Tracks Y position of mouse events
    public boolean mouseIsPressed;	// Determines if mouse has been clicked or not
    
    public GamePanel (Game enclosingGame)
    {
      
    	this.addMouseListener(this); 			// Listen to our own mouse events.
    	this.addMouseMotionListener(this);		// Listen to mouse movements
        this.enclosingGame = enclosingGame;
        this.setFocusable(true);
    }
    
    public void paintComponent (Graphics g)
    {
        enclosingGame.draw (g);
    }
    /* MouseListener methods */
    
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
		mouseIsPressed = true;
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
		mouseIsPressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
		mouseIsPressed = true;
		
	}

	/* MouseMotionListener methods */
	
	@Override
	public void mouseDragged(MouseEvent e) 
	{	
		mouseX = e.getX();
		mouseY = e.getY();
		mouseIsPressed = false;
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
		mouseIsPressed = false;

	}
}

