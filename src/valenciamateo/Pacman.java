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
		this.vel = new PVector(3,3);
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
			pos.y -= 8;
			break;
		case PConstants.DOWN:
			pos.y += 8;
			break;
		case PConstants.LEFT:
			pos.x -= 8;
			break;
		case PConstants.RIGHT:
			pos.x += 8;
			break;
		}
	}

	public void run() {

		while (vivo) {
			
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
