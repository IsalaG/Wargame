package War;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Panneau extends JPanel{

	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 1000, 800);
		try{
			//Image de fond du menu 
		Image img = ImageIO.read(new File("index.png"));
		g.drawImage(img,0,0,this.getWidth(), this.getHeight() ,this);
		
		Font font = new Font("courrier",Font.BOLD,70);
		g.setFont(font);
		
		g.drawString(" WARGAMES ", this.getWidth()/4, this.getHeight()/4);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
