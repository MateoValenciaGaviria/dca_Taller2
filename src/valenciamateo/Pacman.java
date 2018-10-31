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
		// ----------------------------------------------------------
		this.pos = new PVector(app.width / 2, app.height / 2);
		// this.velocidad = new PVector(0, 0);
		// this.aceleracion = new PVector(0, 0);
		// this.maxVel = 4;
		// this.maxForce = 0.1f;
		// ----------------------------------------------------------
	}

	public void pintar() {
		app.imageMode(app.CENTER);
		app.image(pacman, pos.x, pos.y, pacman.width / 4, pacman.height / 4);

		// ----------------------------------------------------------
		// float angulo = velocidad.heading() + app.PI / 2;
		// app.pushMatrix();
		// app.translate(1,1);
		// app.rotate(angulo);
		// app.image(pacman, app.width / 2, app.height / 2, pacman.width / 4,
		// pacman.height / 4);
		// app.popMatrix();
		// ----------------------------------------------------------
	}

	public void mover() {
		// ----------------------------------------------------------
		// PVector objetivo = new PVector(app.mouseX, app.mouseY);
		// buscar(objetivo);
		// ----------------------------------------------------------
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

			// mover();

			// ------------------------------------
			// velocidad.add(aceleracion);
			// velocidad.limit(maxVel);
			// pos.add(velocidad);
			// aceleracion.mult(0);
			// ------------------------------------

			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// ----------------------------------------------------------

	public void aplicarFuerza(PVector fuerza) {
		aceleracion.add(fuerza);
	}

	public void buscar(PVector objetivo) {
		PVector desired = PVector.sub(objetivo, pos);
		desired.normalize();
		desired.mult(maxVel);
		PVector steer = PVector.sub(desired, velocidad);
		steer.limit(maxForce);
		aplicarFuerza(steer);
	}

	// ----------------------------------------------------------
}
