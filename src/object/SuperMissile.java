package object;

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
		return "Supermissile: " + "X" + ";" + this.posX +","+ this.posY + "\n";
	}
}

