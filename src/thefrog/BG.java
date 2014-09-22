package thefrog;



import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public class BG {
		static int randomY;
		private  Image Background;
		private float x;
		private float y;
		private float vy;
		static public final int WIDTH = 640; 
		static public final int IMAGE_HEIGHT = 480;
		

		public BG (float x,float y,float vy) throws SlickException {
			this.x = x;
		    this.y = y;
		    this.vy = vy;
		    Background = new Image("res/bg.png");
		}
		
		public void render() {
			Background.draw(x,y);
			
		}
		
		public void update() {
		   this.y -= vy;   
		   if( y > 240){
		    	y = 0;
		   }
				//y = Thefrog.GAME_HEIGHT+randomY;
		   //}
		}

		//private void randomY() {
			//Random random = new Random();
			//BG.randomY = random.nextInt(100);
			
		//}
		
}
