package valenciamateo;

import java.util.ArrayList;

import processing.core.PVector;

public abstract class Personaje extends Thread{
	
	protected Main app;
	protected Logica log;
	protected PVector pos, velocidad, aceleracion;
	protected float tam, maxForce, maxVel;
	protected int nivel;
	protected boolean atacado, mareado, vivo;
	protected ArrayList<Recolectable> recolectables;
	
	public Personaje(Main app, Logica log){
		this.app = app;
		this.log = log;
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
	
	

}
