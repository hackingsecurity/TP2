package object;
import logic.FileContentsVerifier;
import logic.Game;

/**
 * Creamos un UCMShip
 * 	-Solo debe de existir uno en el juego.
 * 
 * Caracteristicas del UCMShip
 * 	-Dispara un misil que debe ser único en el juego
 * 	-Dispara un supermisil que debe ser único en el juego
 * 	-Detona el ShockWave que se consigue al derribar al Ovni
 * 		-quita 1 punto de vida a todas los Aliens
 */
public class UCMShip extends Ship{

	//-----------------VARIABLES----------------
	private boolean missile;
	private int numSuperMissiles;
	private boolean shockWave;
	private final int CostSM = 20; 
	
	//-----------------CONTRUCTOR---------------
	
	public UCMShip(Game game, int posX, int posY) {
							//LIVE
		super(game,posX, posY, 3,"P");
		this.missile = false;
		this.numSuperMissiles = 0;
		this.shockWave = false;
	}
	public UCMShip(Game game, int posX, int posY, int numSM) {
		super(game,posX, posY, 3,"P");
		this.missile = false;
		this.numSuperMissiles = numSM;
		this.shockWave = false;
	}
	
	//--------------GETTER AND SETTER-----------
	
	public UCMShip() {
		// TODO Auto-generated constructor stub
	}


	public boolean getMissile() { return this.missile; }
	public void setMissile(boolean missile) {this.missile = missile;}
	public int getNumSuperMissiles() {return numSuperMissiles;}
	
	public void setNumSuperMissiles(int numSuperMissiles) {
		
		if(numSuperMissiles < 0) {
			if(this.numSuperMissiles > 0) this.numSuperMissiles -= numSuperMissiles;	
		}else if (numSuperMissiles > 0) this.numSuperMissiles += numSuperMissiles;
		
	}
	public boolean getShockWave() {return shockWave;}
	public void setShockWave(boolean shockWave) {this.shockWave = shockWave;}
	public int getCostSM() {return CostSM;}
	
	//---------------OWNER METHODS--------------
	
	/**
	 * Comprobamos si podemos mover.
	 * 
	 * Actualizamos nuestra posicion y preguntamos si estamos en el tablero
	 * 	-si estamos  en el tablero retorna FALSE.
	 * 	-si retorna TRUE,  volvemos al estado anterior
	 *  - y devolvemos false;
	 * 
	 * @param numCells
	 * @return
	 */
	public boolean move(int numCells) {

		boolean move = false;
		int aux = this.posY;
		this.posY += numCells;
	
		if(!(this.isOut())) {
			move = true;
		}
		else this.posY = aux;
		
		return move;
	}
	
	
	//--------------METHODS IMPLEMENTS IAttack-----------
	
	public boolean receiveBombAttack(int damage) {
		boolean hit = false;
		
		if(this.isAlive()) {	
			this.receiveDamageFromOtherObject(damage);
			hit = true;
		}	
		return hit;	
	}
	
	
	//--------------ABSTRACT METHODS------------
	
	@Override
	public void computerAction() {}
	public void onDelete() {}
	public void move() {}


		//--------------OBJECT FORMAT OUTPUT-----------
	
	@Override
	public String toString() {
		
		if(this.live > 0) return "^__^";
		else return "!xx?";
	}
	
	public String stringifed() {
		return super.stringifed() + ";" + this.game.getPoints() +
				";" + this.shockWave + ";" + this.numSuperMissiles;  /* +
				this.numSuperMissiles + "\n";*/
	}


	@Override
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) {

		if(stringFromFile.split(";")[0].equalsIgnoreCase("p")) {
			if(!verifier.verifyPlayerString(stringFromFile, game, 3)) return null;

			String coordenadas = stringFromFile.split(";")[1];// recoge las coordenadas
			UCMShip ship = new UCMShip(game,Integer.parseInt(coordenadas.split(",")[0]),Integer.parseInt(coordenadas.split(",")[1]),
					Integer.parseInt(stringFromFile.split(";")[5])); 
			game.setPlayer(ship);
			return ship;
		}
		
		return null;
	}
}
