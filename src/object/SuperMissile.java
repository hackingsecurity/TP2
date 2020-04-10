package object;

import logic.FileContentsVerifier;
import logic.Game;


/**
 * Creamos un SuperMissile
 *
 */
public class SuperMissile extends Weapon {
	

	//-----------------CONTRUCTOR---------------
	
	public SuperMissile(Game game, int posX, int posY) {
		super(game, posX, posY, 1,2);
	}

	//--------------METHODS IMPLEMENTS IAttack-----------
	
	public SuperMissile() {
		// TODO Auto-generated constructor stub
		
	}

	public boolean performAttack(GameObject other) {
		
		boolean performAttack = false;
		
		if(other.receiveSuperMissileAttack(damage)) {
			this.live = 0;
			performAttack = true;
		}
		
		return performAttack;
	}
	
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
	public void onDelete() {}
	
	public void move() {
		posX -= 1;
		if(this.isOut()) {
			this.live = 0;
		}
	}
	
		//--------------OBJECT FORMAT OUTPUT-----------

	@Override
	public String toString() {
		return "ss";
	}
	
	public String stringifed() {
		return "X" + ";" + this.posX +","+ this.posY + "\n";
	}

	@Override
	protected GameObject parse(String stringFromFile, Game game2, FileContentsVerifier verifier) {
		if(stringFromFile.split(";")[0].equalsIgnoreCase("X")) {
			if(!verifier.verifyWeaponString(stringFromFile, game2)) return null;

			String coordenadas = stringFromFile.split(";")[1]; // recoge las coordenadas
			
			return new SuperMissile(game,Integer.parseInt(coordenadas.split(",")[0]),
					Integer.parseInt(coordenadas.split(",")[1]));
		}
		return null;
	}
}

