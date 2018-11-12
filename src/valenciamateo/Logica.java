package valenciamateo;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Logica extends Thread {

	private Main app;
	private Pacman jugador;
	private PImage[] pantallas;
	private ArrayList<Fantasma> fantasmas;
	private ArrayList<Recolectable> recolectables;
	private ArrayList<Recolectable> comida;
	private int pantalla, tiempo0, tiempo1, tiempo2, contador1, contador2, contadorFinal;
	private boolean vivo, creo, cuentaTiempo;

	public Logica(Main app) {
		this.app = app;
		this.pantalla = 0;
		this.vivo = true;
		this.tiempo1 = app.millis();
		this.tiempo2 = app.millis() + 5000;
		this.contador1 = 0;
		this.contador2 = 0;
		this.contadorFinal = 0;
		this.recolectables = new ArrayList<Recolectable>();
		this.comida = new ArrayList<Recolectable>();
		this.jugador = new Pacman(app, this);
		this.jugador.start();
		this.fantasmas = new ArrayList<Fantasma>();
		this.creo = true;
		this.cuentaTiempo = true;

		pantallas = new PImage[4];
		pantallas[0] = app.loadImage("p1.jpg");
		pantallas[1] = app.loadImage("p2.jpg");
		pantallas[2] = app.loadImage("p3.jpg");
		pantallas[3] = app.loadImage("p4.jpg");
	}

	public void run() {
		while (vivo) {
			if (pantalla == 2) {
				if (cuentaTiempo) {
					tiempo0 = app.millis() + 30000;
					cuentaTiempo = false;
				}
				if (tiempo0 < app.millis()) {
					for (int i = 0; i < fantasmas.size(); i++) {
						if (fantasmas.get(i).getNivel() < jugador.getNivel()) {
							contadorFinal++;
						}
						if (contadorFinal == 5) {
							pantalla = 3;
						}else if(contadorFinal < 5){
							pantalla = 4;
						}
					}
				}

				if (tiempo1 + 1000 < app.millis()) {
					comida.add(new Recolectable(app, 0));
					if (contador1 < 29) {
						contador1++;
					}
					tiempo1 = app.millis();
				}

				if (tiempo2 + 2500 < app.millis()) {
					recolectables.add(new Recolectable(app, (int) app.random(1, 5)));
					if (contador2 < 9) {
						contador2++;
					}
					tiempo2 = app.millis();
				}
				if (creo) {
					crearFantasmas();
					creo = false;
				}
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void pintar() {
		switch (pantalla) {
		case 0:
			app.image(pantallas[0], 0, 0, pantallas[0].width / 4, pantallas[0].height / 4);
			break;
		case 1:
			app.image(pantallas[1], 0, 0, pantallas[1].width / 4, pantallas[1].height / 4);
			break;
		case 2:
			for (int i = 0; i < comida.size(); i++) {
				comida.get(i).pintar();
			}

			for (int i = 0; i < recolectables.size(); i++) {
				recolectables.get(i).pintar();
			}
			jugador.pintar();

			for (int i = 0; i < fantasmas.size(); i++) {
				fantasmas.get(i).pintar();
			}
			break;
		case 3:
			app.imageMode(PApplet.CORNER);
			app.image(pantallas[2], 0, 0, pantallas[2].width / 4, pantallas[2].height / 4);
			app.textSize(30);
			app.text(getJugador().getNivel(), 650, 580);
			break;
		case 4:
			app.imageMode(PApplet.CORNER);
			app.image(pantallas[3], 0, 0, pantallas[3].width / 4, pantallas[3].height / 4);
			app.textSize(30);
			app.text(getJugador().getNivel(), 650, 580);
			break;

		}

	}

	public void mousePressed() {
		switch (pantalla) {
		case 0:
			if (app.mouseX > 890 && app.mouseX < 1142 && app.mouseY > 580 && app.mouseY < 642) {
				pantalla = 1;
			}
			break;
		case 1:
			if (app.mouseX > 514 && app.mouseX < 768 && app.mouseY > 589 && app.mouseY < 648) {
				pantalla = 2;
			}
			break;
		}

	}

	public void keyPressed() {
		jugador.mover();
	}

	public void crearFantasmas() {
		for (int i = 0; i < 5; i++) {
			Fantasma elFantasma = new Fantasma(app, this);
			fantasmas.add(elFantasma);
			elFantasma.start();
		}
	}

	public Pacman getJugador() {
		return jugador;
	}

	public ArrayList<Recolectable> getRecolectables() {
		return recolectables;
	}

	public ArrayList<Recolectable> getComida() {
		return comida;
	}

	public void removerRecolectables(int i) {
		recolectables.remove(i);
	}

	public void removerComida(int i) {
		comida.remove(i);
	}

}
