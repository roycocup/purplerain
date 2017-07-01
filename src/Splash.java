import processing.core.PVector;

public class Splash {
	
	PurpleRain g;
	
	PVector gravity = new PVector(0, 0.1f);
	PVector pos = new PVector();
	PVector vel = new PVector();
	PVector acc = new PVector();
	
	
	public Splash(PurpleRain g){
		this.g = g;
	}
	
	public void run(PVector pos){
		this.pos = pos;
		applyForce(new PVector(1,-1));
	}
	
	void applyForce(PVector force){
		acc.add(force);
	}
	
	void update(){
		applyForce(gravity);
		vel.add(acc);
		pos.add(vel);
		acc.setMag(0);
	}
	
	void draw(){
		g.pushMatrix();
		g.noStroke();
		g.fill(255);
		float w = 2f;
		g.rect(pos.x, pos.y, w, w);
		g.popMatrix();
	}
}
