package object;
import interfaces.IAttack;
import logic.FileContentsVerifier;
import logic.Game;


//-----------------VARIABLES----------------
//-----------------CONTRUCTOR---------------
//--------------GETTER AND SETTER-----------
//---------------OWNER METHODS--------------
//--------------ABSTRACT METHODS------------
//--------------METHODS IMPLEMENTS IAttack-----------
//--------------OBJECT FORMAT OUTPUT-----------



/**
 * Pantilla cero que dependen todos lo objetos del juego
 * 
 */

public abstract class GameObject implements IAttack {
	
	public static final String labelRefSeparator= " _ ";
	protected int label = 0;
	protected String st;
	
	/*-----------------VARIABLES----------------
				ALL object need to use this
	*/
	protected int posX, posY;
	protected int live;
	protected Game game;
	
	//-----------------CONTRUCTOR---------------
	public GameObject( ) {
		
	}
	public GameObject( Game game, int posX , int posY, int live, String st) {
		this.posX = posX; this.posY = posY; this.game = game; this.live = live;
		this.st = st;
	}
	
	//--------------GETTER AND SETTER-----------
	
	public int getPosX() { return this.posX;}
	public int getPosY() { return this.posY;}
	public int getLive() { return this.live;}
	
	
	//---------------OWNER METHODS--------------
	
	public boolean isAlive() { return this.live > 0;}
	
	/**
	 * Posicion de un Objecto 
	 * 
	 * @see {@linkplain Game }
	 * 
	 * @param posX
	 * @param posY
	 * @return Devuelvo true si x y e corresponde con este objeto
	 */
	public boolean isOnPosition(int posX, int posY) { return this.posX == posX && this.posY == posY;}
	public boolean isOut() {return !game.isOnBoard(this.posX, this.posY);}
	
	/**
	 * Si esta vivo el objeto le hacemos daño:
	 * 	-si el daño es igual a la vida actual su vida pasará a ser 0
	 * 	-sino, le restamos el daño a la vida.
	 * 
	 * @param damage
	 */
	public void receiveDamageFromOtherObject (int damage) {
		
		this.live = damage >= this.live ? 0 : (this.live - damage); 
	}

	//--------------ABSTRACT METHODS------------
	
	
	/**
	 * Los objetos del juego realizan una acción
	 */
	public abstract void computerAction();
	
	/**
	 * Comprobamos si el objeto este su vida > 0 y si no
	 * vemos si podemos añadir los puntos por destroirlo y restar 1
	 * a las naves enemigas.
	 */
	public abstract void onDelete();
	
	/**
	 * Movemos nuestro objetos
	 */
	public abstract void move();
	
	public boolean isOwner(int ref) {
		return label == ref;
	}
	public int getLabel() {return label;}
		//--------------OBJECT FORMAT OUTPUT-----------
	
	public abstract String toString();
	
	public String stringifed() {
		return this.st + ";" + this.posX + "," + this.posY;
	}
	protected abstract GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier);
	
}
