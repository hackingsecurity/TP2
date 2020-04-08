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
		super(game, posX, posY, live,1);
	}
	
	//--------------METHODS IMPLEMENTS IAttack-----------
	

	public ShockWave() {
		// TODO Auto-generated constructor stub
	}

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
	public String stringifed() {return "SW" + ";" + this.posX+","+this.posY + ";" 
			+ this.live + ";";}

	@Override
	protected GameObject parse(String stringFromFile, Game game2, FileContentsVerifier verifier) {
		if(stringFromFile.split(";")[1].equalsIgnoreCase("sw")) {
			if(!verifier.verifyWeaponString(stringFromFile, game)) return null;

			String coordenadas = stringFromFile.split(";")[1]; // recoge las coordenadas
			
			return new ShockWave(game,Integer.parseInt(coordenadas.split(",")[0]),
					Integer.parseInt(coordenadas.split(",")[1]),1);
		}
		return null;
	}

}
