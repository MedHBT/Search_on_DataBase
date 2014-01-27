package dbProject;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class IntroPanel extends JPanel{

	private static final long serialVersionUID = -2042554525128454706L;
	
	private static Image imgIntro;
	
	public void paintComponent(Graphics g){
		try{
			imgIntro = ImageIO.read(new File("img/Intro.png"));
			//g.drawImage(imgIntro, 0, 0, this);
			//Pour une image de fond
			g.drawImage(imgIntro, 0, 0, this.getWidth(), this.getHeight(), this);			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
