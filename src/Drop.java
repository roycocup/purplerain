import processing.core.PVector;

public class Drop {
	PurpleRain g;
	PVector pos; 
	float length;
	float speed; 
	int[] color = new int[4];
	int thickness = 2;

	public Drop(PurpleRain p, float speed, int length, int[] color, int thick){
		this.g = p;
		this.speed = speed;
		pos = new PVector();
		pos.y = g.random(g.height-1);
		pos.x = g.random(g.width-1);
		this.length = length;
		setupColor(color);
		this.thickness = thick;
	}
	
	void setupColor(int[] color){
		this.color[0] = color[0];
		this.color[1] = color[1];
		this.color[2] = color[2];
		this.color[3] = color[3];
	}

	void update(){
		pos.y += speed;
		if (pos.y > g.height){
			pos.y = g.random(-10);
		}
	}

	void draw(){
		g.strokeWeight(thickness);
		g.stroke(color[0],color[1],color[2],color[3]);
		g.line(pos.x, pos.y, pos.x, pos.y + length);
	}

}
