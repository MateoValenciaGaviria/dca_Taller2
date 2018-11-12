package valenciamateo;

import java.util.ArrayList;

import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;

public class Pacman extends Personaje {

	private PImage pacman;

	public Pacman(Main app, Logica log) {
		super(app, log);
		this.pacman = app.loadImage("pacman.png");
		this.tam = 90;
		this.vivo = true;
		this.atacado = false;
		this.mareado = false;
		this.nivel = 0;
		this.recolectables = new ArrayList<Recolectable>();
		this.pos = new PVector(app.width / 2, app.height / 2);
		this.vel = new PVector(9,9);
		this.fresa = false;
		this.cereza = false;
		this.melon = false;
		this.pera = false;
	}

	public void pintar() {
		app.textAlign(app.CENTER);
		app.text(nivel, pos.x, pos.y - 50);
		app.imageMode(app.CENTER);
		app.image(pacman, pos.x, pos.y, pacman.width / 4, pacman.height / 4);
	}

	public void mover() {
		switch (app.keyCode) {
		case PConstants.UP:
			if(pera){
				pos.y += vel.y;
			}else{
				pos.y -= vel.y;
			}
			break;
		case PConstants.DOWN:
			if(pera){
				pos.y -= vel.y;
			}else {
				pos.y += vel.y;
			}
			break;
		case PConstants.LEFT:
			if(pera){
				pos.x += vel.x;
			}else {
				pos.x -= vel.x;
			}
			break;
		case PConstants.RIGHT:
			if(pera){
				pos.x -= vel.x;
			}else {
				pos.x += vel.x;
			}
			break;
		}
	}

	public void run() {

		while (vivo) {
			
			if(cereza){
				vel = new PVector(11,11);
				cereza = false;
			}
			
			if(melon){
				vel = new PVector(5,5);
			}
			
			aplicarRecolectables();
			recogerComida();
			recogerRecolectables();
			try {
				sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
