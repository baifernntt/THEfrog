package thefrog;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class tree {
	
	private Image image;
	public static final int WIDTH = 120;
	public static final int HEIGHT = 30;
	private int x;
	private int y;
	private int vy;
	private Image tree1;
	private Image tree2;
	private Image tree3;
	public static int randomx;
	
	public float getX() { return x; }
	public float getY() { return y; }
	public float getVy() { return vy; }
	
	public tree(int a,int b, int vy) throws SlickException {
		
		this.x =a;
		this.y =b;
		this.vy = vy;
		tree1 = new Image("res/tree.png");
		tree2 = new Image("res/tree.png");
		tree3 = new Image("res/tree.png");
	}
	
	public  void render(){
		tree1.draw(0,Thefrog.GAME_HEIGHT-y);
		tree2.draw(x,Thefrog.GAME_HEIGHT-y);
		tree3.draw(520,Thefrog.GAME_HEIGHT-y);
	}
	
	public void update() {
		y += vy; 
	    
		   if( y < -60 ){
				y = 550;
				randomx();
				 x = Thefrog.GAME_WIDTH/2+20-randomx;
			}
	}
	public void randomx() {
		Random random = new Random();
		 tree.randomx = random.nextInt(220);
		
	}
	
	
}
	

	

