package valenciamateo;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Fantasma extends Personaje {

	private PImage[] fantasmas;
	private int color;

	public Fantasma(Main app, Logica log) {
		super(app, log);

		fantasmas = new PImage[10];
		fantasmas[0] = app.loadImage("azul1.png");
		fantasmas[1] = app.loadImage("azul2.png");
		fantasmas[2] = app.loadImage("rojo1.png");
		fantasmas[3] = app.loadImage("rojo2.png");
		fantasmas[4] = app.loadImage("rosa1.png");
		fantasmas[5] = app.loadImage("rosa2.png");
		fantasmas[6] = app.loadImage("verde1.png");
		fantasmas[7] = app.loadImage("verde2.png");
		fantasmas[8] = app.loadImage("naranja1.png");
		fantasmas[9] = app.loadImage("naranja2.png");

		this.pos = new PVector(app.random(90, 1100), app.random(90, 600));
		this.vel = new PVector(2, 2);
		this.tam = 90;
		this.vivo = true;
		this.atacado = false;
		this.mareado = false;
		this.nivel = 0;
		this.recolectables = new ArrayList<Recolectable>();
		this.color = (int) app.random(0, 9);
	}

	public void pintar() {
		// pintar fantasma a escala
		// app.image(fantasma, x, y, fantasma.width/4, fantasma.height/4);
		app.textAlign(app.CENTER);
		app.text(nivel, pos.x, pos.y - 50);
		app.imageMode(app.CENTER);
		app.image(fantasmas[color], pos.x, pos.y, fantasmas[color].width / 4, fantasmas[color].height / 4);
	}

	public void mover() {

		for (int i = 0; i < log.getComida().size(); i++) {

			if (log.getJugador().getNivel() > nivel) {

				if ((PApplet.dist(pos.x, pos.y, log.getJugador().getPos().x, log.getJugador().getPos().y)) < 200) {
					vel = PVector.sub(log.getJugador().getPos(), pos);
					vel.rotate(180);
					vel.mult(0.5f);
					vel.normalize();
					pos.add(vel);
				} else if (log.getJugador().getNivel() > nivel) {
					vel = PVector.sub(log.getComida().get(i).getPos(), pos);
					vel.normalize();
					pos.add(vel);
				}
			}

			else if (PApplet.dist(pos.x, pos.y, log.getComida().get(i).getPos().x,
					log.getComida().get(i).getPos().y) < PApplet.dist(pos.x, pos.y, log.getJugador().getPos().x,
							log.getJugador().getPos().y)) {
				vel = PVector.sub(log.getComida().get(i).getPos(), pos);
				vel.normalize();
				pos.add(vel);

			} else {
				vel = PVector.sub(log.getJugador().getPos(), pos);
				vel.normalize();
				pos.add(vel);
			}

		}

	}

	public void run() {

		while (vivo) {

			mover();
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
