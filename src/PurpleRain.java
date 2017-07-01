import java.util.Dictionary;
import java.util.HashMap;
import java.util.Vector;

import processing.core.PApplet;

public class PurpleRain extends PApplet {

	Drop[] rainDrops; 
	Vector<Integer> ground = new Vector<Integer>(); 
	
	int numType1 = 1;
	int numType2 = 1;
	int numType3 = 1;


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
			int[] color = {139,2,135,255};
			rainDrops[i] = new Drop(this, 3f, 8, color, 2);
			i++;
		}

		while(i < numType1 + numType2){
			int[] color = {168,0,162,200};
			rainDrops[i] = new Drop(this, 2f, 5, color, 2);
			i++;
		}

		while(i < numType1 + numType2 + numType3){
			int[] color = {202,0,195,100};
			rainDrops[i] = new Drop(this, 1, 3, color, 1);
			i++;
		}

	}
	
	void drawScenery(){
		pushMatrix();
		fill(13, 193, 67); //green / grass
		rect(ground.get(0), ground.get(1), ground.get(2), ground.get(3));
		fill(152,97,15); // brown / dirt
		rect(ground.get(0), ground.get(1)+3, ground.get(2), ground.get(3));
		popMatrix();
	}
	
	public void draw(){
		background(255,155,253);
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
