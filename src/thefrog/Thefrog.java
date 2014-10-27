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
	public static final int Tree_VY = -3;
	private frog Frog;
	private tree Tree;
	private boolean isStarted;
	private boolean isGameOver;
	private tree[] trees;
	private Image land;
	public int treeCurrent = 0;
	private int times = 60;
	public static int checkTrees = 0;
	private int time = 60;
	private Image started;
	private Image overgame;
	private int treecount = 4;
	static int x;
	

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
			g.setColor(Color.white);
			g.drawString("score = " + Frog.score/100, 280, 20);
			g.drawString("Time : " + time, 500, 20);
		}
		if (isStarted == false) {
			g.drawImage(started, 0, 0);
		} else if (isGameOver == true) {
			g.drawImage(overgame, 0, 0);
			g.drawString(" " + Frog.score/100, 280, 350);
		}

	}

	@Override
	public void init(GameContainer container) throws SlickException {

		land = new Image("res/bg1.png");
		Frog = new frog(GAME_WIDTH / 2, 40);
		inittrees();
		isStarted = false;
		started = new Image("res/start.png");
		overgame = new Image("res/gameover.png");
	}

	private void inittrees() throws SlickException {
		trees = new tree[treecount];
		
		for (int i = 0; i < treecount; i++) {
			trees[i] = new tree(1, 1, 1);
			trees[i].randomx();
			x = GAME_WIDTH / 2 - 90 + tree.randomx;
			trees[i] = new tree(x, 150 * i + 50, Tree_VY);
		}
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {

		Input input = container.getInput();

		if (!isGameOver) {
			newgame(input);
			System.out.println(isGameOver+" \\ "+isStarted);
			if (isStarted) {
				time();
				updateMovement(input);
				for (tree t : trees) {
					t.update();

					if (frog.isCollide(t)) {
						System.out.println("Collision!");
						isGameOver=true;
						
						frog.render();
					}

					if (frog.x < 0 || frog.y < 0) {
						System.out.println("Collision!");
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
				}
			}
		}
	
	

	private void time() {
		times--;
		if (times == 0) {
			times = 60;
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
			isGameOver = false;
			isStarted = true;
		}
	}

	private void newgame(Input input) {
		if (input.isKeyDown(Input.KEY_ENTER) && !isStarted) {
			isStarted = true;
			treeCurrent = 0;
			time = 60;
			Frog.score = 0;
		}
	}

	public void updateMovement(Input input) {
		if (Frog.x >= 640) {
			Frog.x = 0;
		}
		if (Frog.x < 0) {
			Frog.x = 640;
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			Frog.moveright();
		}
		if (input.isKeyDown(Input.KEY_LEFT)) {
			Frog.moveleft();
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
