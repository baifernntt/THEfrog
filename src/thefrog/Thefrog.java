package thefrog;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Thefrog extends BasicGame {
	
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	private Image image;

	public Thefrog(String title) {
		super(title);
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.drawImage(image, 0, 0);
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		image = new Image("res/bg.png");
		
		
	}

	@Override
	public void update(GameContainer container, int g) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
	    try {
	      Thefrog game = new Thefrog("THE frog");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
	      appgc.setMinimumLogicUpdateInterval(1000 / 60);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }

}
