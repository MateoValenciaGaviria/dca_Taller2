package valenciamateo;

import processing.core.PApplet;

public class Main extends PApplet{
	
	private Logica log;

	public static void main(String[] args) {
		PApplet.main("valenciamateo.Main");
	}
	
	public void settings(){
		size(1200,700);
	}
	
	public void setup(){
		log = new Logica(this);
		log.start();
	}
	
	public void draw(){
		background(0);
		log.pintar();
		fill(255);
		text("X: "+mouseX+"Y: "+mouseY, mouseX, mouseY);
		noFill();
		//ellipse(mouseX, mouseY, 90, 90);
	}
	
	public void mousePressed(){
		
	}
	
	public void keyPressed(){
		log.keyPressed();
	}

}
