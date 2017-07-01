import processing.core.PVector;

public class Splash {
	
	PurpleRain g;
	
	PVector pos = new PVector();
	SplashDropplet[] dropplets = new SplashDropplet[5]; 
	
	
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
			dropplets[i].pos = pos;
			//dropplets[i].applyForce(new PVector(g.random(-1,1), g.random(-0.8f, -1)));
		}
	}
	
	
	void update(){
		for(SplashDropplet dropplet : dropplets){
			dropplet.update();
		}
	}
	
	void draw(){
		for(SplashDropplet dropplet : dropplets){
			dropplet.draw();
		}
	}
}
