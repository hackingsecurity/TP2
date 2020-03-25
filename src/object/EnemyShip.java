//PAQUETE QUE LO CONTIENE
package object;

import logic.Game;


public abstract class EnemyShip extends Ship {

	
	public EnemyShip(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live);
	}

	
	public boolean receiveMissileAttack(int damage) {
		boolean hit = false;
		if(this.isAlive()) {
			this.live -= damage;
			hit = true;
		}
			return hit;
		};
	public boolean receiveShockWaveAttack(int damage) {
		boolean hit = false;
		if(this.isAlive()) {
			this.live -= damage;
			hit = true;
			}
		return hit;
	};

}
