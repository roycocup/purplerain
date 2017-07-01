import java.util.Dictionary;
import java.util.HashMap;
import java.util.Vector;

import processing.core.PApplet;

public class PurpleRain extends PApplet {

	final float gravity = 9.80f;
	Drop[] rainDrops; 
	Vector<Integer> ground = new Vector<Integer>(); 
	
	int numType1 = 50;
	int numType2 = 50;
	int numType3 = 50;


	public void settings(){
		size(400, 400);
	}

	public void setup(){
		buildRain();
		buildTerrain();
	}
	
	void buildTerrain(){
		ground.add(-5);
		ground.add(height-10);
		ground.add(width+5);
		ground.add(height+1);
	}

	
	void buildRain(){
		rainDrops = new Drop[numType1+numType2+numType3];

		int i = 0;

		while(i < numType1){
			int[] color = {0,0,0,255};
			rainDrops[i] = new Drop(this, 2f, 10, color, 2);
			i++;
		}

		while(i < numType1 + numType2){
			int[] color = {255,255,255,200};
			rainDrops[i] = new Drop(this, 1.5f, 5, color, 2);
			i++;
		}

		while(i < numType1 + numType2 + numType3){
			int[] color = {0,255,255,100};
			rainDrops[i] = new Drop(this, 1, 3, color, 1);
			i++;
		}

	}
	
	void drawScenery(){
		
		fill(13, 193, 67); //green / grass
		rect(ground.get(0), ground.get(1), ground.get(2), ground.get(3));
		fill(152,97,15); // brown / dirt
		rect(ground.get(0), ground.get(1)+3, ground.get(2), ground.get(3));
	}
	
	public void draw(){
		background(125,0,124);
		for(Drop drop : rainDrops){
			if (drop == null)
				continue;
			drop.update();
			drop.draw();
		}
		drawScenery();
	}




	public static void main(String[] args) {
		PApplet.main("PurpleRain");
	}

}
