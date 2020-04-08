//PAQUETE QUE LO CONTIENE
package object;

import logic.Game;

/**
 * 
 * Clase abstracta para implementar un tipo AlienShip
 * 	-DestroyerAlien
 * 	-RegularAlien
 *	
 * Esta clase deberá gestionar el movimiento grupal de las
 * naves, (todas en la misma direccion)
 * 
 * 
 *
 */
public  abstract class AlienShip extends EnemyShip {
	
	//-----------------STATIC VARIABLES----------------
	
	protected static int contadorAlien = 0;
	protected static int sentido = -1;  		//empezamos por la izquierda
	protected static boolean bajar = false;
	protected static boolean haveLanded = false;
	
	
	
	
	public AlienShip(Game game, int posX, int posY, int live, int points) {
		super(game, posX, posY, live, points);
		//Se incrementa al añadir un nuevo AlienShip
		contadorAlien += 1;
	}
	
	//-----------------STATIC METHODS---------------
	
	public static boolean HaveLanded() {return haveLanded;}
	public static int getContadorAlien() {return contadorAlien;}
	public static boolean getBajar() {return bajar;}
	
	public static void setContadorAlien(int reset) { contadorAlien = reset;}
	public static void setBajarShips(boolean bajarShip) { bajar = bajarShip;}
	public static void setSentido(int sent) {sentido = sent;}
	
	public static boolean AllDeads() {
		boolean yes= false;
		if(contadorAlien == 0) {
			 yes = true;
		}
		return yes;
	}
	
	private boolean border() {
		return (this.posY == 0 || this.posY == Game.DIM_Y - 1);
	}
	
	private void cambiarSentido() {
		
		if(Game.DIM_Y -1 == this.posY) {
			sentido = -1;
		}
		else if (this.posY == 0) {
			sentido = 1;
		}
	}
	
	private boolean canMove() {
		return ((game.getCurrentCycle() > 0 ) &&
					(game.getCurrentCycle() % 
						game.getLevel().getNumCyclesToMoveOneCell()) == 0 );
	}
	
	/**
	 * si debo bajar o no las naves 
	 * 
	 * @return
	 */
	private boolean sentidoActual() {
		return ((posY == 0 && sentido == -1) || (posY == Game.DIM_Y -1 && sentido == 1));
	}
	
	//--------------METHODS IMPLEMENTS IAttack-----------
	
	
	public boolean receiveExplosionAttack(int damage) {
		boolean hit = false;
		if(this.isAlive()) {
			this.receiveDamageFromOtherObject(damage);
			hit = true;
			}
		return hit;
	};
	
	//este hay que cambiarlo
	public boolean receiveShockWaveAttack(int damage) {
		boolean hit = false;
		if(this.isAlive()) {
			this.receiveDamageFromOtherObject(damage);
			hit = true;
			}
		return hit;
	};
	
	//--------------ABSTRACT METHODS------------
	
	/**
	 * Hacemos la siguiente operacion:
	 * 
	 *  cicloActual % numeroCicloNivel == 0 
	 *  	-puedo mover
	 */
	public void computerAction() {
		
		if(canMove()) {
			if((border()) && (sentidoActual())) {
				bajar = true;
				cambiarSentido();  //hallamos el entido de nuestras naves
			}
		}
		
		
	}
	
	
	/**
	 * Comprobamos si bajamos, o si movemos nuestro objeto
	 */
	public void move(){
	
		if(canMove()) {
			if(bajar) {
				this.posX++;
				if(posX == Game.DIM_X -1) {
				   haveLanded = true;
				}
			}
			else
				this.posY += sentido;
		}		
	}
	
	
	public abstract void onDelete();
	public abstract String toString();
	public abstract String stringifed();


	

}
