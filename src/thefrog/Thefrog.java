package thefrog;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
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
	//private BG Bg;
	//private BG[] bG = new BG[3];
	private Image land;
	public static final float bg_Vy = -3;

	public Thefrog(String title) {
		super(title);
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.drawImage(land, 0, 0);
		//for (BG Bg : bG) {
		      //Bg.render();
		//}
		for (tree Trees: trees){
			Trees.render();
		}
		//Tree.render();
		Frog.render();
		g.drawString("score = " + Frog.score, 320, 20);
		
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		
	    //bG[0] = new BG(0,0,bg_Vy);
	    //bG[1] = new BG(0,240,bg_Vy);
	    //bG[2] = new BG(0,480,bg_Vy);
	    land = new Image("res/bg1.png");
		Frog = new frog(GAME_WIDTH/2, 40,Frog_JUMP_VY);
		//Tree = new tree(GAME_WIDTH/2+40,170,Tree_VX);
		isStarted = false;
		inittrees();
	}

	private void inittrees() throws SlickException {
		trees = new tree[3];
	    for (int i = 0; i < 3; i++) {
	      trees[i] = new tree(GAME_WIDTH/2+40*i, 120*i+150 ,Tree_VX-i);
	    }
	}

	@Override
	public void update(GameContainer container, int g) throws SlickException {
		
		if (!isGameOver){	
			if(isStarted == true){
				Frog.update();
				//Tree.update();
			
				for(int i=0;i<3;i++){
					trees[i].update();
					
					if(Frog.isCollide(trees[i])){
						System.out.println("Collision! "+i);
					}
				}
			//for(BG Bg : bG){
				//Bg.update();
			//}
		
	}
		}
		
		if (isGameOver){
			Input input1 = container.getInput();
			if(input1.isKeyDown(Input.KEY_ENTER)){
				init(container);
				isGameOver = false ;
				
			}
		}
		
	}
	
	public void keyPressed(int key, char c) {
		
		if (key == Input.KEY_ENTER){
			isStarted = true;	
		}
			if (key == Input.KEY_SPACE) {	
				Frog.jump();
		}
			
			if (isGameOver){
				if(key == Input.KEY_ENTER){
					isGameOver = true;
				}
				
			}
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
