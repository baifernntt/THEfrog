package thefrog;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class tree {
	private Image image;
	public static final int WIDTH = 120;
	public static final int HEIGHT = 60;
	private int x;
	private int y;
	private int vx;
	
	public tree(int a,int b, int vx) throws SlickException {
		
		this.x =a;
		this.y =b;
		this.vx = vx;
		image = new Image("res/tree.png");
		
	}
	
	

	public  void render(){
		image.draw(Thefrog.GAME_WIDTH - x,Thefrog.GAME_HEIGHT-y);
	}

	public void update() {
	    x -= vx;
	    if(x > 640){
	    	x =130;
	    	//x -= vx;
	    }
	    
	}
	

	
}
