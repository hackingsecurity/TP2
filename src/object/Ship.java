package object;
import logic.Game;

public abstract class Ship extends GameObject{
	
	//-----------------CONTRUCTOR---------------
	
	public Ship(Game game, int posX, int posY, int live ){super(game, posX, posY, live);}

	//--------------ABSTRACT METHODS------------
	
	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
	public abstract String stringifed();
}
