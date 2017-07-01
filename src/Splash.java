import processing.core.PVector;

public class Splash {
	
	PurpleRain g;
	
	PVector pos = new PVector();
	int numDropplets = 5;
	SplashDropplet[] dropplets = new SplashDropplet[numDropplets];
	
	public boolean running = true;
	
	
	public Splash(PurpleRain g){
		this.g = g;
	}
	
	public void run(PVector pos){
		this.pos = pos;
		createDropplets();
	}
	
	void createDropplets(){
		for(int i = 0; i < dropplets.length; i++){	
			dropplets[i] = new SplashDropplet(g);
			dropplets[i].pos = pos.copy();
			dropplets[i].applyForce(new PVector(g.random(-1,1), g.random(-0.8f, -1)));
		}
	}
	
	
	void update(){
		byte[] belowGround = new byte[dropplets.length];
		int i = 0;
		for(SplashDropplet dropplet : dropplets){
			dropplet.update();
			
			if (dropplet.pos.y > g.ground.get(1)){
				belowGround[i] = 1; 
			} 
			i++;
		}
		//There should be a way faster way to do this... unless I change data structs
		byte t = 0;
		for (byte j = 0; j < belowGround.length; j++){
			t += belowGround[j];
		}	
		if (t == numDropplets){
			running = false;
		}
			
	}
	
	void draw(){
		if (running){
			for(SplashDropplet dropplet : dropplets){
				dropplet.draw();
			}
		}
	}
}
