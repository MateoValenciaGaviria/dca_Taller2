package valenciamateo;

import java.awt.Image;
import java.util.ArrayList;

import processing.core.PImage;
import processing.core.PVector;

public class Recolectable {

	private Main app;
	private PImage[] recolectables;
	private PVector pos;
	private int tam, tipo;
	private boolean visible;

	public Recolectable(Main app, int tipo) {
		this.app = app;
		this.tipo = tipo;
		this.tam = 90;
		this.visible = false;
		this.pos = new PVector(app.random(90, 1100), app.random(90, 600));

		recolectables = new PImage[5];
		recolectables[0] = app.loadImage("comida.png");
		recolectables[1] = app.loadImage("fresa.png");
		recolectables[2] = app.loadImage("cereza.png");
		recolectables[3] = app.loadImage("melon.png");
		recolectables[4] = app.loadImage("pera.png");
	}

	public void pintar() {
		app.imageMode(app.CENTER);
		if (visible) {
			switch (tipo) {
			case 0:
				app.image(recolectables[0], pos.x, pos.y, recolectables[0].width / 4, recolectables[0].height / 4);
				break;
			case 1:
				app.image(recolectables[1], pos.x, pos.y, recolectables[1].width / 4, recolectables[1].height / 4);
				break;
			case 2:
				app.image(recolectables[2], pos.x, pos.y, recolectables[2].width / 4, recolectables[2].height / 4);
				break;
			case 3:
				app.image(recolectables[3], pos.x, pos.y, recolectables[3].width / 4, recolectables[3].height / 4);
				break;
			case 4:
				app.image(recolectables[4], pos.x, pos.y, recolectables[4].width / 4, recolectables[4].height / 4);
				break;
			}
		}
		app.imageMode(app.CORNER);
	}

	public PVector getPos() {
		return pos;
	}

	public void setVisible(boolean visibilidad) {
		visible = visibilidad;
	}

}
