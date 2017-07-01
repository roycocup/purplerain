import processing.core.PVector;

public class Drop {
	PurpleRain g;
	PVector pos; 
	float length;
	float speed; 
	int[] color = new int[4];
	int thickness = 2;
	Splash splash;
	Boolean splashActive = false;

	public Drop(PurpleRain p, float speed, int length, int[] color, int thick){
		this.g = p;
		this.speed = speed;
		pos = new PVector();
		pos.y = g.random(g.height-1);
		pos.x = g.random(g.width-1);
		this.length = length;
		setupColor(color);
		this.thickness = thick;
		splash = new Splash(g);
	}
	
	void setupColor(int[] color){
		this.color[0] = color[0];
		this.color[1] = color[1];
		this.color[2] = color[2];
		this.color[3] = color[3];
	}
	
	void setupSplash(){
		if(splash == null)
			splash = new Splash(g);
		splash.run(pos.copy());
		splashActive = true;
	}
	
	void reset(){
		pos.y = g.random(-10);
		pos.x = g.random(g.width-1);
	}

	void update(){
		pos.y += speed;
		if (pos.y+length-2 >= g.ground.get(1)){
			setupSplash();
			reset();
		}
		
		if (splashActive && splash.pos.y > g.ground.get(1)){
			splash = null;
			splashActive = false;
		}
		
		if(splashActive){
			splash.update();
		}
	}

	void draw(){
		g.pushMatrix();
		g.strokeWeight(thickness);
		g.stroke(color[0],color[1],color[2],color[3]);
		g.line(pos.x, pos.y, pos.x, pos.y + length);
		g.popMatrix();
		if(splashActive){
			splash.draw();
		}
	}

}
