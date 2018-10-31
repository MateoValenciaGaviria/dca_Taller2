package valenciamateo;

import java.util.ArrayList;

import processing.core.PImage;
import processing.core.PVector;

public class Fantasma extends Personaje{
	
	private PImage[] fantasmas;

	public Fantasma(Main app, Logica log) {
		super(app, log);
		
		fantasmas = new PImage[10];
		fantasmas[0] = app.loadImage("azul1.png"); fantasmas[1] = app.loadImage("azul2.png");
		fantasmas[2] = app.loadImage("rojo1.png"); fantasmas[3] = app.loadImage("rojo2.png");
		fantasmas[4] = app.loadImage("rosa1.png"); fantasmas[5] = app.loadImage("rosa2.png");
		fantasmas[6] = app.loadImage("verde1.png"); fantasmas[7] = app.loadImage("verde2.png");
		fantasmas[8] = app.loadImage("naranja1.png"); fantasmas[9] = app.loadImage("naranja2.png");
		
		this.pos = new PVector(app.random(90,1100),app.random(90,600));
		this.tam = 90;
		this.vivo = true;
		this.atacado = false;
		this.mareado = false;
		this.nivel = 0;
		this.recolectables = new ArrayList<Recolectable>();
	}

	public void pintar() {
		//pintar fantasma a escala
		//app.image(fantasma, x, y, fantasma.width/4, fantasma.height/4);

	}

	public void mover() {

	}

	public void run() {

	}

}
