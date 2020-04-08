package logic;
import interfaces.IPlayerController;
import object.AlienShip;
import object.Bomb;
import object.ExplodeShip;
import object.GameObject;
import object.ShockWave;
import object.SuperMissile;
import object.UCMMissile;
import object.UCMShip;
import utils.CommandGenerator;
import utils.Level;

import java.util.Random;

import board.PrinterTypes;

/**
 * Delega responsabilidad a GameObjectBoard 
 * 	-GameObjectBoard delega la logica a cada una de sus objectos 
 *
 * @see IPlayerController
 */
public class Game implements IPlayerController{

	
	//-----------------CONSTANTES----------------
	public final static int DIM_X = 8; //filas
	public final static int DIM_Y = 9; //columnas
	
	private int currentCycle;
	private boolean doExit;

	//-----------------VARIABLES----------------
	
	private BoardInitializer initializer ;
	private Level level ;
	private GameObjectBoard board;  //Todos los objectos
	private UCMShip player;
	private Random rand;
	private int points ;

	
	//-----------------CONTRUCTOR---------------
	
	public Game (Level level, Random random){
		this.rand = random;
		this.level = level;
		initializer = new BoardInitializer();
		initGame();
	}
	
	//--------------GETTER AND SETTER-----------
	
		public int getCurrentCycle(){return this.currentCycle;}
		public Random getRandom() {return rand;}
		public Level getLevel() {return level;}
		public int getPoints() {return this.points;}
		public UCMShip getUCMShip() {return this.player;}
	

	
	//---------------OWNER METHODS--------------
	
	/**
	 * Inicializamos nuestro tablero, con todos los objectos 
	 * 
	 */
	public void initGame () {
		this.currentCycle = 0;
		this.points = 0;
		this.currentCycle = 0;
		AlienShip.setContadorAlien(0);
		AlienShip.setSentido(-1);
		this.board = initializer.initialize(this, level);
		this.player = new UCMShip(this, DIM_X - 1 , DIM_Y / 2);
		this.board.add(player);
	}
	
	/**
	 * Maquina GANA 
	 * 	-Si la vida del jugador es cero
	 * 	-Si los AlienShip han aterrizado
	 * 	
	 * @return true si se cumple una de estas opciones, false si no se cumple ninguna
	 */
	public boolean aliensWin() {
		return !player.isAlive () || AlienShip.HaveLanded();		
		
	}
	
	/**
	 * El jugador gana cuando los el total de los alienShip sea 0
	 * 
	 * @return true si gana false si no
	 */
	private boolean playerWin () {
		return  AlienShip.AllDeads();
	}

	/**
	 * Actualizamos el juego
	 * 	Llamamos a GameObjectBoard
	 */
	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}
	
	/**
	 * Finalizamos el juego
	 *  -Si hemos ganado ¡
	 *  -Gana la maquina
	 *  -Me salgo del juego
	 *  
	 * @return true si me salgo o false si no
	 */
	public boolean isFinished() {
		
		return playerWin() || aliensWin() || doExit;
	}
	
	/**
	 * Añado un nuevo objecto 
	 * 	-DestroyerAlien crea un bomba
	 * 	-UCMShip crea un misil
	 * 	-etc
	 * @param newObject
	 */
	public void addNewObject(GameObject newObject) {
		this.board.add(newObject);
	}
	
	/**
	 * Comprobamos si un objeto esta en el tablero
	 * @param posX
	 * @param posY
	 * @return
	 */
	
	public boolean isOnBoard(int posX, int posY) {
		//  X son las filas e Y son las columnas
		return ((posX >= 0 && posX < DIM_X ) && ( posY >= 0 && posY < DIM_Y));
	}
	
	//---------------OWNER METHODS COMMANDS--------------
	
	/**
	 * Sumamos un superMissile a la variable de UCMShip
	 * 
	 * @return
	 */
	public boolean buySuperMissile() {
		
		boolean canBuy = false;
		if(this.points >= this.player.getCostSM()) {
			this.player.setNumSuperMissiles(1);
			this.points -= this.player.getCostSM();
			canBuy = true;
		}
		
		return canBuy;
	}
	
	/**
	 * Salgo de la partida actual
	 */
	public void exit() {
		doExit = true;
	}
	
	/**
	 * Reseteo el juego
	 */
	public void reset() {
		initGame();
	}
	
	/**
	 * Mostramos el la ayuda de cada comando.
	 * 
	 * @return String
	 */
	public String helpText() {
		return CommandGenerator.commandHelp() ;
	}
	
	public String list() {
		
		return "\n[R]egular ship: Points: 5 - Harm: 0 - Shield: 2\n" +
				"[D]estroyer ship: Points: 10 - Harm:1 - Shield: 1\n" +
				"[O]vni: Points: 25 - Harm: 0 - Shield: 1\n" +
				"^__^: Harm: 1 - Shield: 3\n";
	}
	
	/**
	 * Tipos de visualización del tablero
	 * 
	 * @return
	 */
	public String listPrinterCommand() {
		return PrinterTypes.printerHelp(this);
	}

	
	
	/**
	 * Mensaje de finalización
	 * @return
	 */
	public String getWinnerMessage () {
		
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else return "This should not happen";
	}
	
	
	
	//--------------METHODS IMPLEMENTS IPlayerController-----------

				//Player actions
	
	@Override
	public boolean move (int numCells) {
		return player.move(numCells);
	}
	
	@Override
	public boolean shootMissile() {
		return this.player.getMissile();
	}
	
	/**
	 * Si he disparado, no puedo disparar un superMissile
	 */
	
	@Override
	public boolean shootSuperMissile() {
		
		boolean shoot;
		if(this.player.getMissile() || this.player.getNumSuperMissiles() <= 0) {
			shoot = false;
		}
		else shoot = true;
		
		return shoot;
	}
	
	@Override
	public boolean shockWave() {
		boolean shock = false;
		if(this.player.getShockWave()) {
			this.player.setShockWave(false);
			shock = true;
		}
		return shock;
	}
				// Callbacks
	@Override			
	public void receivePoints(int points) {
		this.points += points;
	}
	
	@Override
	public void enableShockWave() {
		board.add(new ShockWave(this,0,10,1));
		this.player.setShockWave(true);
	}
	
	@Override
	public void enableMissile() {
		
		board.add(new UCMMissile(this,player.getPosX(),player.getPosY()));
		player.setMissile(true);
	}

	@Override
	public void enableSuperMissile() {
		board.add(new SuperMissile(this, this.player.getPosX(),player.getPosY()));
		player.setMissile(true);
		player.setNumSuperMissiles(-1);
	}
	
	public void disableMissile() {
		player.setMissile(false);
	}

	
	public String shock () {
		
		String shock = "NO";
		if(this.player.getShockWave())
		{
			shock = "SI";
		}
		return shock;
	}

	
	public void explode(int posX, int posY) {	board.explode(posX, posY);}
	
	public void changeRegularToExplode(int posX, int posY, int live) {
		this.board.add(new ExplodeShip(this, posX, posY, live));
	}
	
	public String toString(int posX, int posY) {return this.board.toString(posX, posY);}
	
	public String stringifier() { return board.stringifier();}


	
	//VER QUE VALE DE ESTO

	/*
	public void changeRegularToExplode(int posX, int posY, int vida) {
		// TODO Auto-generated method stub
		if(board.changeRegularToExplode(posX,posY)) {
			board.add(new ExplodeShip(this,posX,posY,vida));
		}
	}

	*/
	
	

	public String getSWSt() {
		if(shockWave()) return "hasShock";
		// TODO Auto-generated method stub
		return "";
	}

	public String stringSent(int sentido) {
		if(sentido == -1) return "<-";
		else return "->";
		
	}
	
}
