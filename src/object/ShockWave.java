//PAQUETE QUE LO CONTIENE
package object;

import logic.FileContentsVerifier;
import logic.Game;

/**
 * Cramos un ShocWave
 * 
 *
 */
public class ShockWave extends Weapon{
	
	
	//-----------------CONTRUCTOR---------------
	
	public ShockWave(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live,1,"SW");
	}
	
	//--------------METHODS IMPLEMENTS IAttack-----------
	

	public ShockWave() {
		// TODO Auto-generated constructor stub
	}

	public boolean performAttack(GameObject other) {
		
		boolean performAttack = false;
		
		/*
		if(other.receiveShockWaveAttack(damage)) { 
			this.live = 0;
			performAttack = true;
		}
		*/
		if (this.game.getShockWave()) {
			if(other.receiveShockWaveAttack(damage)) {
				performAttack = true;
			}
		}
		

		return performAttack;
	}
	
	//--------------ABSTRACT METHODS------------

	@Override
	public void computerAction() {}
	public void onDelete() {
		if(game.getShockWave()) {
			game.setShowkWave(false);
			this.live = 0;
		}
	}
	public void move() {}

		//--------------OBJECT FORMAT OUTPUT-----------
	
	@Override
	public String toString() {return null;}


	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) {
		if(stringFromFile.split(";")[0].equalsIgnoreCase("sw")) {
			if(!verifier.verifyWeaponString(stringFromFile, game)) return null;

			String coordenadas = stringFromFile.split(";")[1]; // recoge las coordenadas
			
			return new ShockWave(game,Integer.parseInt(coordenadas.split(",")[0]),
					Integer.parseInt(coordenadas.split(",")[1]),1);
		}
		return null;
	}

}
