//PAQUETE QUE LO CONTIENE
package object;

import logic.FileContentsVerifier;
import logic.Game;


/**
 * Crear un misil 
 * 
 * 	Debemos crear un metodo que desabilite el misil si se sale,
 * 	si se da con algo etc.
 *
 *	
 */
public class UCMMissile extends Weapon{
	
	//-----------------CONTRUCTOR---------------
	
	public UCMMissile(Game game, int posX, int posY) {
		super(game, posX, posY, 1,1,"M");
	}

	//--------------METHODS IMPLEMENTS IAttack-----------
		
	public UCMMissile() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Dado un objecto vemos si podemos hacerle daño o no.
	 * 
	 * 									
	 */
	public boolean performAttack(GameObject other) {

		boolean performAttack = false;
		if(this.isAlive()) {
			if(other.isOnPosition(this.posX, this.posY)) {
				if(other.receiveMissileAttack(damage)) {
					this.live = 0;
					performAttack = true;
				}
			}
		}
			
		return performAttack;
	}
	
	@Override
	public boolean receiveBombAttack(int damage) {
		boolean hit = false;
		
		if(this.isAlive()) {	
			this.receiveDamageFromOtherObject(damage);
			hit = true;
		}	
		return hit;	
	}
	
	//--------------ABSTRACT METHODS------------
	
	@Override
	public void computerAction() {}
	public void onDelete() {
		
		if(!this.isAlive()) {
			game.disableMissile();
		}
	}
	
	@Override
	public void move() {
		posX -= 1;
		if(this.isOut()) {
			this.live = 0;
		}
	}
	
		//--------------OBJECT FORMAT OUTPUT-----------
	
	@Override
	public String toString() {
		return "oo";
	}
		
	
	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) {
		if(stringFromFile.split(";")[0].equalsIgnoreCase("M")) {
			if(!verifier.verifyWeaponString(stringFromFile, game)) return null;

			String coordenadas = stringFromFile.split(";")[1]; // recoge las coordenadas
			
			return new UCMMissile(game,Integer.parseInt(coordenadas.split(",")[0]),
					Integer.parseInt(coordenadas.split(",")[1]));
		}
		return null;
	}
}
