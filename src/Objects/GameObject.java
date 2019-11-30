package Objects;
import Logic.Game;
import Logic.IAttack;


public abstract class GameObject implements IAttack {
	
	protected int posX, posY;
	protected int live;
	protected Game game;
	protected int dagame ;
	
	public GameObject() {
		
	}
	
	public GameObject( Game game, int posX , int posY, int live) {
		this.posX = posX;
		this.posY = posY;
		this.game = game;
		this.live = live;
	}
	
	//PEDIR COORDENADAS DE UN OBJETO
	public int getPosX() { return this.posX;}
	public int getPosY() { return this.posY;}
	
	// métodos que devuelven el valor de las coordinadas 
	public boolean isAlive() { return this.live > 0;}
	
	public int getLive() { return this.live;}
	
	public boolean isOnPosition( /* otras coordinadas */ ) {
		return true;/* coordinadas = otras coordinadas */ 
	}
	
	/*
	public void getDamage (int damage) {
		this.live = damage >= this.live ? 0 : this.live − damage;
	}
	*/
	
	public boolean isOut() {
		return !game.isOnBoard( /*coordinadas */ );
	}
	
	//METODOS 
	public abstract void computerAction();
	public abstract void onDelete();
	
	public abstract void move();
	public abstract String toString();

}
