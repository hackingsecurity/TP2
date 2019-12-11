package Objects;
import Logic.Game;
import Logic.IAttack;


public abstract class GameObject implements IAttack {
	
	protected int posX, posY;
	protected int live;
	protected Game game;
<<<<<<< HEAD
	protected int dagame ;		//no todos hacen daño
	protected int id;			//No todos deben tener un identificador
								//s
=======
	protected int damage ;
>>>>>>> branch 'master' of https://github.com/HackingSecurity/TP2.git
	


	public GameObject( Game game, int posX , int posY, int live) {
		this.posX = posX;
		this.posY = posY;
		this.game = game;
		this.live = live;
<<<<<<< HEAD
		
=======
		this.damage = 1;

>>>>>>> branch 'master' of https://github.com/HackingSecurity/TP2.git
	}
	
	public GameObject() {
		
	}
	
	//PEDIR COORDENADAS DE UN OBJETO
	public int getPosX() { return this.posX;}
	public int getPosY() { return this.posY;}
	public int getDamage() {return this.damage;}
	
	// métodos que devuelven el valor de las coordinadas 
	public boolean isAlive() { return this.live > 0;}

	public int getLive() { return this.live;}

	public boolean isOnPosition(int posX, int posY) {	
		return this.posX == posX && this.posY == posY; 
	}
	
	public void getDamage (int damage) {
		this.live = (damage >= this.live) ? 0 : (this.live - damage);
	}
	
	public boolean isOut() {
		return !game.isOnBoard(this.posX, this.posY);
	}
	
	//METODOS 
	public abstract void computerAction();
	public abstract void onDelete();
	
	public abstract void move();
	public abstract String toString();

}
