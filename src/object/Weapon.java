//PAQUETE QUE LO CONTIENE
package object;

import Logic.Game;

public abstract class Weapon extends GameObject{

	public Weapon(Game game, int posX, int posY, int live,int damage) {
		super(game, posX, posY, live, damage);
	
	}

	public Weapon() {
		super();
		
	}
	public void move() {
		
	}

}
