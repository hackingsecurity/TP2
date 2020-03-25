package object;
import interfaces.IAttack;
import logic.Game;


//-----------------VARIABLES----------------
//-----------------CONTRUCTOR---------------
//--------------GETTER AND SETTER-----------
//---------------OWNER METHODS--------------
//--------------ABSTRACT METHODS------------



/**
 * 
 * 
 * 
 *
 */

public abstract class GameObject implements IAttack {
	
	/*-----------------VARIABLES----------------
				ALL object need to use this
	*/
	protected int posX, posY;
	protected int live;
	protected Game game;
	//Remember Ovni don´t have damage
	protected int damage ;
	
	
	protected int id;
	protected boolean lanzado;
	
	//-----------------CONTRUCTOR---------------
	
	public GameObject( Game game, int posX , int posY, int live, int damage) {
		this.posX = posX;
		this.posY = posY;
		this.game = game;
		this.live = live;
		this.damage = damage;

	}
	
	//ESTO NO ESTA ORIENTADO A OBJECTOS
	
	
	//PEDIR COORDENADAS DE UN OBJETO
	public int getPosX() { return this.posX;}
	public int getPosY() { return this.posY;}
	
	public int getDamage() {return this.damage;}
	public boolean getLanzado() {return this.lanzado;}
	public int getId() {return this.id;}
	
	public void setLanzado(boolean yes) {
		this.lanzado = yes;
	}
	
	// métodos que devuelven el valor de las coordinadas 
	public boolean isAlive() { return this.live > 0;}

	public int getLive() { return this.live;}

	public boolean isOnPosition(int posX, int posY) {	
		return this.posX == posX && this.posY == posY; 
	}
	
	public void getDamage (int damage) {
		this.live = (damage >= this.live) ? 0 : (this.live - damage);
	}
	
	public boolean isOut() {
		return !game.isOnBoard(this.posX, this.posY);
	}
	
	//--------------ABSTRACT METHODS------------
	
	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
	public String stringifed() {
		return this.posX + "," + this.posY;
	}
	
	public void hit(int damage2) {
		// TODO Auto-generated method stub
		this.live -= damage;
	}

}
