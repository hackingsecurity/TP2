//PAQUETE QUE LO CONTIENE
package object;

import interfaces.IExecuteRandomActions;
import logic.Game;

/**
 * 
 * Creamos un EnemyShip
 * 
 * -Aqui debemos gestionar el movimiento de las naves
 * 		Incluimos el ovni
 * 
 * -[Además de los puntos que se obtienen al ser destruidos]
 * 	
 *
 */
public abstract class EnemyShip extends Ship implements IExecuteRandomActions{

	//-----------------VARIABLES----------------
	protected int points;
	
	//-----------------CONTRUCTOR---------------
	public EnemyShip() {super();}
	public EnemyShip(Game game, int posX, int posY, int live, int points, String st) {
		super(game, posX, posY, live,st);
		this.points = points;
	}

	
	//--------------GETTER AND SETTER-----------
	public int getPtos() { return this.points; }
	
	
	//--------------METHODS IMPLEMENTS IAttack-----------
	
	//hay que implementar en las clases que corresponda
	
	public boolean receiveMissileAttack(int damage) {
		boolean hit = false;
		if(this.isAlive()) {
			this.receiveDamageFromOtherObject(damage);
			hit = true;
		}
			return hit;
	};
		
	
	@Override
	public boolean receiveSuperMissileAttack(int damage) {
		boolean hit = false;
		if(this.isAlive()) {
			this.receiveDamageFromOtherObject(damage);
			hit = true;
			}
		return hit;
	}
	
	
	
	//--------------ABSTRACT METHODS------------
	
	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
	public  String stringifed() {
		return super.stringifed();
	};

}
