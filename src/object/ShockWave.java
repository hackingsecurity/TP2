//PAQUETE QUE LO CONTIENE
package object;

import logic.Game;

/**
 * Cramos un ShocWave
 * 
 *
 */
public class ShockWave extends Weapon{
	

	//-----------------CONTRUCTOR---------------
	
	public ShockWave(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live,1);
	}
	
	//--------------METHODS IMPLEMENTS IAttack-----------
	

	public boolean performAttack(GameObject other) {
		
		boolean hit = false;
		
		if(other.receiveShockWaveAttack(damage)) { hit = true;}

		return hit;
	}
	
	//--------------ABSTRACT METHODS------------

	@Override
	public void computerAction() {}
	public void onDelete() {}
	public void move() {}

		//--------------OBJECT FORMAT OUTPUT-----------
	
	@Override
	public String toString() {return null;}
	public String stringifed() {return null;}

}
