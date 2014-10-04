package thefrog;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class tree {
	private Image image;
	public static final int WIDTH = 120;
	public static final int HEIGHT = 60;
	private int a;
	private int b;
	
	public tree(int a,int b) throws SlickException {
		
		this.a =a;
		this.b =b;
		image = new Image("res/tree.png");
		
	}
	
	public  void render(){
		image.draw(Thefrog.GAME_WIDTH - a,Thefrog.GAME_HEIGHT-b);
	}

	

	
}
