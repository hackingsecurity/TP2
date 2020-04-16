package object;
import logic.Game;

public abstract class Ship extends GameObject{
	
	//-----------------CONTRUCTOR---------------
	public Ship() {super();};
	public Ship(Game game, int posX, int posY, int live,  String st ){super(game, posX, posY, live,st);}

	//--------------ABSTRACT METHODS------------
	
	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();
	public  String stringifed() {
		return super.stringifed() + ";" + this.live;
	};
}
