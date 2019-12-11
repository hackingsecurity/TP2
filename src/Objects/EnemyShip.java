//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;


public abstract class EnemyShip extends Ship {

	
	public EnemyShip(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live);
	}

	public EnemyShip() {
		super();
		// TODO Auto-generated constructor stub
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
