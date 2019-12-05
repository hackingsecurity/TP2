//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;

public abstract class Weapon extends GameObject{

	public Weapon(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live);
	
	}

	public Weapon() {
		super();
		
	}
	public void move() {
		
	}

}
