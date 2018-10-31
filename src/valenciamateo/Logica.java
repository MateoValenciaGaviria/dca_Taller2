package valenciamateo;

import java.util.ArrayList;

import processing.core.PConstants;

public class Logica {
	
	private Main app;
	private Pacman jugador;
	private ArrayList<Fantasma> fantasmas;
	private ArrayList<Recolectable> recolectables;
	private ArrayList<Recolectable> comida;
	private int tiempo;
	
	public Logica(Main app){
		this.app = app;
		this.tiempo = app.millis();
		this.recolectables = new ArrayList<Recolectable>();
		this.comida = new ArrayList<Recolectable>();
		this.fantasmas = new ArrayList<Fantasma>();
		this.jugador = new Pacman(app, this);
		this.jugador.start();
		crearRecolectables();
	}
	
	public void pintar(){
		app.background(0);
		jugador.pintar();
	}
	
	public void mousePressed(){
		
	}
	
	public void keyPressed(){
		jugador.mover();
	}
	
	public void crearRecolectables(){
		for (int i = 0; i < 15; i++) {
			comida.add(new Recolectable(app, 0));
		}
		
		for (int i = 0; i < 10; i++) {
			recolectables.add(new Recolectable(app,(int)app.random(1,5)));
		}
		
	}
	
	public Pacman getJugador(){
		return jugador;
	}
	
	public ArrayList<Recolectable> getRecolectables(){
		return recolectables;
	}
	
	

}
