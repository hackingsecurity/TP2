//PAQUETE QUE LO CONTIENE
package object;

import logic.Game;

/**
 * Las armas son las que realmente hacen Daño
 * 	-UCMMissile
 * 	-SuperMisile
 * 	-ShockWave
 * 	-
 */
public abstract class Weapon extends GameObject{

	//-----------------VARIABLES----------------
	protected int damage;
	
	//-----------------CONTRUCTOR---------------
	public Weapon() {super();}
	public Weapon(Game game, int posX, int posY, int live,int damage,String st) {
		super(game, posX, posY, live, st);
		this.damage = damage;
	}

	
	//--------------ABSTRACT METHODS------------
	
	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
	public String stringifed() {
		return super.stringifed();
	}

}
