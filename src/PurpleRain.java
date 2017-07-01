import processing.core.PApplet;

public class PurpleRain extends PApplet {

	final float gravity = 9.80f;
	Drop[] rainDrops; 

	int numType1 = 50;
	int numType2 = 50;
	int numType3 = 50;


	public void settings(){
		size(400, 400);
	}

	public void setup(){
		build();

	}

	void build(){
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

	public void draw(){
		background(125,0,124);
		for(Drop drop : rainDrops){
			if (drop == null)
				continue;
			drop.update();
			drop.draw();
		}
	}




	public static void main(String[] args) {
		PApplet.main("PurpleRain");
	}

}
