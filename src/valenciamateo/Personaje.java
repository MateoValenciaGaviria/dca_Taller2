package valenciamateo;

import java.util.ArrayList;

import processing.core.PFont;
import processing.core.PVector;

public abstract class Personaje extends Thread{
	
	protected Main app;
	protected Logica log;
	protected PVector pos, vel;
	protected float tam;
	protected int nivel;
	protected boolean atacado, mareado, vivo;
	protected ArrayList<Recolectable> recolectables;
	protected PFont fuente;
	
	public Personaje(Main app, Logica log){
		this.app = app;
		this.log = log;
	//	this.fuente = app.loadFont("PixelDigivolve.otf");
	}
	
	public abstract void pintar();
	public abstract void run();
	public abstract void mover();
	public PVector getPos(){
		return pos;
	}
	public float getTam(){
		return tam;
	}
	public int getNivel(){
		return nivel;
	}
	public boolean isAtacado(){
		return atacado;
	}
	public boolean isMareado(){
		return mareado;
	}
	public ArrayList<Recolectable> getRecolectables(){
		return recolectables;
	}
	public void recogerRecolectables() {

		for (int i = 0; i < log.getRecolectables().size(); i++) {
			if ((pos.dist(log.getRecolectables().get(i).getPos()) < tam)) {
				recolectables.add(log.getRecolectables().get(i));
				log.getRecolectables().remove(i);
			}
		}
	}

	public void recogerComida() {

		for (int i = 0; i < log.getComida().size(); i++) {
			if ((pos.dist(log.getComida().get(i).getPos()) < tam/2)) {
				nivel++;
				log.getComida().remove(i);
			}
		}
	}
	
	

}
