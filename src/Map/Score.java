package Map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Score {
	public int player = 0;
	public int health = 3;
	public int money = 100;
	Image heart;
	public java.net.URL img = getClass().getResource("/picture/heart.png");
	public Score(){
		heart = new ImageIcon(img).getImage();
	}
	public void draw(Graphics g) {
		Font font = new Font("arial",Font.BOLD,40);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Score: "+player,1000,60);
		g.setColor(Color.YELLOW);
		g.drawString("Money: "+money,460,60);
		g.setColor(Color.BLUE);
		for(int i=0;i<health;i++) {
			g.drawImage(heart,100+i*60,20,50,50,null);
		}
	}
}
