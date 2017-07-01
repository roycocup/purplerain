import processing.core.PVector;

public class SplashDropplet {
	
	PurpleRain g;
	PVector gravity = new PVector(0, 0.1f);
	PVector pos = new PVector();
	PVector vel = new PVector();
	PVector acc = new PVector();
	
	public SplashDropplet(PurpleRain g){
		this.g = g;
		applyForce(new PVector(g.random(-1,1), g.random(-0.8f, -1)));
	}
	
	void applyForce(PVector force){
		acc.add(force);
	}
	
	public void update(){
		applyForce(gravity);
		vel.add(acc);
		pos.add(vel);
		acc.setMag(0);
	}
	
	public void draw(){
		g.pushMatrix();
		g.noStroke();
		g.fill(255);
		float w = 2f;
		g.rect(pos.x, pos.y, w, w);
		g.popMatrix();
	}
}
