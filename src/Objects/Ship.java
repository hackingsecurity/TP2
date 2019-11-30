//PAQUETE QUE LO CONTIENE
package Objects;
import Logic.Game;

public abstract class Ship extends GameObject{

	public Ship(Game game, int posX, int posY, int live )
	{
		super(game, posX, posY, live);
	}
	
	
}
