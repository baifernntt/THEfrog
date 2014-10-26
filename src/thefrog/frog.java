package thefrog;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class frog {

	public float x;
	public float y;
	private float vjump;
	public float vy;
	public float vx;
	int score = -1;
	private float xfrog;
	private float yfrog;
	private static Image image;
	public static final int WIDTH = 60;
	public static final int HEIGHT = 60;
	private float g;
	

	public frog(float x, float y, float vjump) throws SlickException {
		this.x = x;
		this.y = y;
		this.vy = 0;
		this.vjump = vjump;
		this.vx = 0;
		g = Thefrog.G;
		image = new Image("res/cut.png");
	}

	public void render() {
		image.draw(x - WIDTH / 2, Thefrog.GAME_HEIGHT - y - (HEIGHT / 2));

	}

	public void update() {
		y += vy;
		vy -= g;
		if (x > 640 - WIDTH) {
			vx *= -1;

		} else if (x < 60)
			vx *= -1;
		x -= this.vx;
		if (y < 20) {
			y = 20;
		}
		
	}

	public void jump() {
		vy = vjump;
		g = Thefrog.G;
	}

	public boolean isCollide(tree t) {
		if (Math.abs(y - t.getY()) <= HEIGHT) {
			if (Math.abs((x + WIDTH / 2) - (t.getX() + tree.WIDTH / 2)) <= tree.WIDTH) {
				this.vy = 0;
				x = t.getX() + tree.WIDTH / 2;
				y = t.getY() + tree.HEIGHT / 2 - tree.HEIGHT / 2;
				this.g = 0;
				this.vx = t.getVx();
				score++;
				return true;

			}
		}
		return false;
	}
}
