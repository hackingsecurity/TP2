//PAQUETE QUE LO CONTIENE
package object;

import logic.Game;

public abstract class Weapon extends GameObject{

	public Weapon(Game game, int posX, int posY, int live,int damage) {
		super(game, posX, posY, live, damage);
	
	}

	public void move() {
		
	}

}
