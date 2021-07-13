package Game;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Map.*;
import Enemy.*;
import Factory.*;

enum GameState { SETUP, UPDATE, DRAW, WAIT, END }

public class Game implements Runnable{
public static void main (String[] args){
    new Game ();
}
/* Object fields and methods */
private GamePanel gamePanel;		// gamePanel object 
private GameState state;	  
private PathPoints line;	
private Tower buildHouse; 	
private boolean buildOrNot;
private boolean gameIsOver;	
private boolean gameIsWon;
private int frameCounter;	
private double elapsedTime;
private long lastTime;
public Score score;
int scoreCounter;	
Cursor cursor;
/* create enemies */
public List<Enemy> enemies;	
List<Tower> towers;		
public List<Attack> attack;
/*Constructor*/
public Game (){
	score = new Score();
	state = GameState.SETUP;
	gamePanel = new GamePanel(this);
	 Thread t = new Thread(this);
     t.start();
} public void run ()
{
    while (true)
    {
        if (state == GameState.SETUP)
        {
            doSetupStuff();
        }
        
        else if (state == GameState.UPDATE)
        {
            doUpdateTasks();
        }
        
        else if (state == GameState.DRAW)
        {
            gamePanel.repaint();  // redraw screen
            
            try { Thread.sleep(5); } catch (Exception e) {}
        }
        
        else if (state == GameState.WAIT)
        {
            try { Thread.sleep(100); } catch (Exception e) {}
            state = GameState.UPDATE;
        }
        
        else if (state == GameState.END)
        {
        }
    }
}
private void doSetupStuff ()
{
    // Do setup tasks
    // Create the JFrame and the JPanel
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    f.setTitle("Kuan's Tower Defense Game");
    f.setContentPane(gamePanel);
    f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    f.setUndecorated(true);
    f.setVisible(true);
    f.setVisible(true); 
    ClassLoader myLoader = this.getClass().getClassLoader();
    InputStream pointStream = myLoader.getResourceAsStream("picture/path_1.txt");
    Scanner s = new Scanner (pointStream);
    line  = new PathPoints(s);
    enemies = new LinkedList<Enemy>();
    towers = new LinkedList<Tower>();
    attack= new LinkedList<Attack>();
    lastTime = System.currentTimeMillis();
    gameIsOver = false;
    gameIsWon = false;
    state = GameState.UPDATE;
    frameCounter=0;
    buildOrNot = false;
    JOptionPane.showMessageDialog(null,  "Rules of the game:\n" +
    		"1. Place radars on the map to stop monsters from reaching the End.\n" +
    		"2. You need to pay 100 dollars to build a radar! \n" +
    		"3.Place your radars on green areas.\n"+
    		"4. You earn money from stopping monsters.\n" +
    		"5. If you stop 50 monsters you win, but if you lose 3 lives the game is over.");
}
public void doUpdateTasks(){
	if(gameIsOver)
	{	state = GameState.DRAW;
		return;
	}
	if(gameIsWon)
	{	state = GameState.DRAW;
		return;
	}
	long currentTime = System.currentTimeMillis();  // Integer number of milliseconds since 1/1/1970.
    elapsedTime = ((currentTime - lastTime) / 1000.0);  // Compute elapsed seconds
    lastTime = currentTime;
    for(Tower t: new LinkedList<Tower>(towers))
	{	
		t.interact(this, elapsedTime);
		
	}
	for(Enemy e: new LinkedList<Enemy>(enemies))
	{	
		e.advance();
		if(e.getPosition().isAtTheEnd())
		{
			enemies.remove(e);	// add to list that has reached the end
			score.health--;		// if they have reached the end, reduce lives
		}
	}
	for(Attack e: new LinkedList<Attack>(attack))
	{	
		e.interact(this, elapsedTime);
		if(e.isDone())
			attack.remove(e);	// add to list that has reached the end	
	}
	this.generateEnemies();
	this.placeBuilding();
	frameCounter++;
	state = GameState.DRAW;
}
public void draw(Graphics g){
	if (state != GameState.DRAW)
        return;
	Graphics2D g2d = (Graphics2D) g;
	int j=0;
	int k=0;
	int width = 81;
	for(String col: MapOne.map1){  //col是一行string 進入map1
		for(int i=0;i<col.length();i++){
			j++;
			if(col.charAt(i)=='1'){
				soil bound = new soil();
				g2d.drawImage(new ImageIcon(bound.soilBetween).getImage(), width*i, width*k, width, width, null);
			}else if(col.charAt(i)=='0'){
				grass bound = new grass();
				g2d.drawImage(new ImageIcon(bound.grass1).getImage(),  width*i, width*k, width, width, null);
			}else if(col.charAt(i)=='2'){
				river bound = new river();
				g2d.drawImage(new ImageIcon(bound.river1).getImage(), width*i, width*k, width, width, null);
			}else if(col.charAt(i)=='3'){
				soil bound = new soil();
				g2d.drawImage(new ImageIcon(bound.soilUpDown).getImage(), width*i, width*k, width, width, null);
			}else if(col.charAt(i)=='4'){
				soil bound = new soil();
				g2d.drawImage(new ImageIcon(bound.soilLeftUp).getImage(), width*i, width*k, width, width, null);
			}else if(col.charAt(i)=='5'){
				soil bound = new soil();
				g2d.drawImage(new ImageIcon(bound.soilLeftBelow).getImage(), width*i, width*k, width, width, null);
			}else if(col.charAt(i)=='6'){
				soil bound = new soil();
				g2d.drawImage(new ImageIcon(bound.soilRightBelow).getImage(), width*i, width*k, width, width, null);
			}else if(col.charAt(i)=='7'){
				soil bound = new soil();
				g2d.drawImage(new ImageIcon(bound.soilRightUp).getImage(), width*i, width*k, width, width, null);
			}else if(col.charAt(i)=='8'){
				build bound = new build();
				g2d.drawImage(new ImageIcon(bound.Build).getImage(), width*i, width*k, width, width, null);
			}
			if(j%19==0) {
				k++;
			}
		}
		for(Enemy e: new LinkedList<Enemy>(enemies)) {
    		e.draw(g);
		}
		for(Tower t: new LinkedList<Tower>(towers))
        	t.draw(g);
		for(Attack s: new LinkedList<Attack>(attack)) {
    		s.draw(g);
		}
		/*leadingRole buildH = new leadingRole(new Coordinate(0, 0));
		buildH.draw(g);*/
		if (buildOrNot) {
			buildHouse.draw(g2d);
		}
}
	ImageLoader loader = ImageLoader.getLoader();	
	Image endGame = loader.getImage("picture/game_over.png"); 
	if(score.health <= 0) {										// if game is lost
    	g.drawImage(endGame, 350, 40, 850,850,null);	
    	gameIsOver=true;
	}
	Image endGame2 = loader.getImage("picture/winner.png"); 
	if(score.player>=50) {
		g.drawImage(endGame2, 550, 200, 450,450,null);	
		gameIsWon=true;
	}
	score.draw(g);
	 state = GameState.WAIT;
}
public void generateEnemies()
{	
		if(frameCounter % 10 == 0)								// slow 
    	{
    		enemies.add(new monsterMush(line.getStart()));
    	}
 		if(frameCounter % 25 == 0 && frameCounter >= 50)	// slow
 		{
 			enemies.add(new monsterSnake(line.getStart()));
 		}
	 	if(frameCounter % 20 == 0)	// medium
	 	{
	 		enemies.add(new monsterCow(line.getStart()));
	 	}	
	 	if(frameCounter % 35 == 0&& frameCounter >= 10)	// medium
	 	{
	 		enemies.add(new monsterGhost(line.getStart()));
	 	}	
	 	if(frameCounter % 45 == 0&& frameCounter >= 20)	// medium
	 	{
	 		enemies.add(new monsterSoft(line.getStart()));
	 	}	
}
public void placeBuilding()
{
	Coordinate mouseLocation = new Coordinate(gamePanel.mouseX, gamePanel.mouseY);
	if(gamePanel.mouseX > 200 && gamePanel.mouseX < 1400 && 
		gamePanel.mouseY > 0 && gamePanel.mouseY < 700 && 
		gamePanel.mouseIsPressed && score.money>=100)
	{	
		buildHouse = new leadingRole(mouseLocation);
		towers.add(new leadingRole(mouseLocation));
		buildOrNot = true;
		score.money-=100;
	}    
	
}
public class Mouse extends MouseAdapter {
	public void mouseClicked(MouseEvent e) {
		gamePanel.mouseClicked(e);
	}
}
}