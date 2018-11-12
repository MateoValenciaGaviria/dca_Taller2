package valenciamateo;

import java.util.ArrayList;

import processing.core.PConstants;

public class Logica extends Thread{
	
	private Main app;
	private Pacman jugador;
	private ArrayList<Fantasma> fantasmas;
	private ArrayList<Recolectable> recolectables;
	private ArrayList<Recolectable> comida;
	private int tiempo1, tiempo2, contador1, contador2;
	private boolean vivo;
	
	public Logica(Main app){
		this.app = app;
		this.vivo = true;
		this.tiempo1 = app.millis();
		this.tiempo2 = app.millis() + 5000;
		this.contador1 = 0;
		this.contador2 = 0;
		this.recolectables = new ArrayList<Recolectable>();
		this.comida = new ArrayList<Recolectable>();
		this.jugador = new Pacman(app, this);
		this.jugador.start();
		this.fantasmas = new ArrayList<Fantasma>();
		crearFantasmas();
	}
	
	public void run(){		
		while (vivo) {
			if(tiempo1 + 1000 < app.millis()){
				comida.add(new Recolectable(app, 0));
				if(contador1 < 29){					
					contador1++;
				}
				tiempo1 = app.millis();
			}
			
			if(tiempo2 + 2500 < app.millis()){
				recolectables.add(new Recolectable(app,(int)app.random(1,5)));
				if(contador2 < 9){					
					contador2++;
				}
				tiempo2 = app.millis();
			}
			
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	public void pintar(){
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
	}
	
	public void mousePressed(){
		
	}
	
	public void keyPressed(){
		jugador.mover();
	}
	
	public void crearFantasmas(){
		for (int i = 0; i < 5; i++) {
			Fantasma elFantasma = new Fantasma(app, this);
			fantasmas.add(elFantasma);
			elFantasma.start();
		}
	}
	
	public Pacman getJugador(){
		return jugador;
	}
	
	public ArrayList<Recolectable> getRecolectables(){
		return recolectables;
	}
	
	public ArrayList<Recolectable> getComida(){
		return comida;
	}
	
	public void removerRecolectables(int i){
		recolectables.remove(i);
	}
	
	public void removerComida(int i){
		comida.remove(i);
	}
	
	

}
