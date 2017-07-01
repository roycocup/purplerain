import java.util.Vector;

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
		
		Vector<Integer> belowGround = new Vector<Integer>();
		int i = 0;
		for(SplashDropplet dropplet : dropplets){
			dropplet.update();
			
			if (dropplet.pos.y > g.ground.get(1)){
				belowGround.add(1); 
			} 
			i++;
		}
			
		if (belowGround.size() == numDropplets){
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
