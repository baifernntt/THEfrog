package thefrog;

import java.awt.Font;

import org.lwjgl.Sys;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Thefrog extends BasicGame {

	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	public static final float G = (float) 0.5;
	public static final float Frog_JUMP_VY = 11;
	public static final int Tree_VX = -2;
	private frog Frog;
	private tree Tree;
	private boolean isStarted;
	private boolean isGameOver;
	private tree[] trees;
	private boolean[] useTree = new boolean[] { false, false, false };
	private Image land;
	public static final float bg_Vy = -3;
	public int treeCurrent = 0;
	private int times = 30;
	public static int checkTrees = 0;
	private int time = 30;
	private Image started;
	private Image overgame;

	public Thefrog(String title) {
		super(title);

	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		if (isStarted == true) {
			g.drawImage(land, 0, 0);

			for (tree Trees : trees) {
				Trees.render();
			}

			Frog.render();
			g.setColor(Color.darkGray);
			g.drawString("score = " + Frog.score, 280, 20);
			g.drawString("Time : " + time, 500, 20);
		}
		if (isStarted == false) {
			g.drawImage(started, 0, 0);
		} else if (isGameOver == true) {
			g.drawImage(overgame, 0, 0);
		}

	}

	@Override
	public void init(GameContainer container) throws SlickException {

		land = new Image("res/bg1.png");
		Frog = new frog(GAME_WIDTH / 2, 40, Frog_JUMP_VY);
		inittrees();
		isStarted = false;
		started = new Image("res/start.png");
		overgame = new Image("res/gameover.png");
	}

	private void inittrees() throws SlickException {
		trees = new tree[3];
		for (int i = 0; i < 3; i++) {
			trees[i] = new tree(80 + 100 * i, 120 * i + 150, Tree_VX - i);
		}
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {

		Input input = container.getInput();

		if (!isGameOver) {
			newgame(input);
			if (isStarted == true) {
				Frog.update();
				time();
				if (treeCurrent != 0 && Frog.y == 40) {
					isGameOver = true;
					System.out.println("Game Over");

				}
				for (int i = 0; i < 3; i++) {
					trees[i].update();
					if (treeCurrent < 3)
						if (Frog.isCollide(trees[treeCurrent])) {
							System.out.println("Collision");
							treeCurrent++;
						}
				}
			}
		}

		if (isGameOver) {
			Input input1 = container.getInput();
			if (input1.isKeyDown(Input.KEY_ENTER)) {
				init(container);
				isGameOver = false;
				restart(input);
				// newgame(input);
			}
		}
	}

	private void time() {
		times--;
		if (times == 0) {
			times = 30;
			time--;
		}
		if (time == 0) {
			isGameOver = true;

		}

	}

	private void restart(Input input) {
		if (input.isKeyDown(Input.KEY_ENTER) && isGameOver) {

			treeCurrent = 0;
			Frog.vx = 0;
			//Frog.update();
			isGameOver = false;
			isStarted = true;

		}

	}

	private void newgame(Input input) {
		if (input.isKeyDown(Input.KEY_ENTER) && !isStarted) {
			isStarted = true;
			//Frog.render();
			treeCurrent =0;
			//Frog.update();
			time = 30;
			Frog.score = 0;

		}

	}

	public void keyPressed(int key, char c) {
		if (key == Input.KEY_SPACE) {
			Frog.jump();
		}
	}

	public static void main(String[] args) {
		try {
			Thefrog game = new Thefrog("THE FROG");
			AppGameContainer appgc = new AppGameContainer(game);
			appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
			appgc.setMinimumLogicUpdateInterval(1000 / 60);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
