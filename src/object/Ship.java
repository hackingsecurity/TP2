//PAQUETE QUE LO CONTIENE
package object;
import Logic.Game;

public abstract class Ship extends GameObject{
	
	public Ship(Game game, int posX, int posY, int live )
	{
		super(game, posX, posY, live, 1);
	}

	public Ship() {
		// TODO Auto-generated constructor stub
	}
	
	
}
