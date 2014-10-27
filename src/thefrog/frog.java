package thefrog;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class frog {

	public static float x;
	public static float y;
	public float vx;
	static int score = -1;
	private float xfrog;
	private float yfrog;
	private static Image image;
	public static final int WIDTH = 60;
	public static final int HEIGHT = 60;

	public frog(float x, float y) throws SlickException {
		this.x = x;
		this.y = y;
		image = new Image("res/cut.png");
	}

	public static void render() {
		image.draw(x + WIDTH / 2, Thefrog.GAME_HEIGHT - HEIGHT / 2 - y);

	}

	public static boolean isCollide(tree t) {
		if (Math.abs(x - t.getX()) <= WIDTH ) {
			if (Math.abs(y - t.getY()) <= HEIGHT) {	
				
				return true;
				
			} else {
				return false;
			}
		}
		if(x-WIDTH/2<0+tree.WIDTH/2 && Math.abs(y - t.getY()) <= HEIGHT){
			return true;
		}
		if(x+WIDTH/2>520-tree.WIDTH/2 && Math.abs(y - t.getY()) <= HEIGHT){
			return true;
			}
		score++;
		return false;
	}

	public void moveright() {
		this.x += 5;

	}

	public void moveleft() {
		this.x -= 5;

	}

}