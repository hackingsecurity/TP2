package Logic;
import Objects.AlienShip;
import Objects.GameObject;
import Objects.UCMShip;
import java.util.Random;


public class Game implements IPlayerController{
	
	
	public final static int DIM_X = 8;
	public final static int DIM_Y = 9;
	private int currentCycle;
	private Random rand;
	private Level level ;
	
	private boolean doExit;
	private BoardInitializer initializer ;
	
	GameObjectBoard board;
	private UCMShip player;
	
	public Game (Level level, Random random){
		this. rand = random;
		this. level = level;
		initializer = new BoardInitializer();
		initGame();
	}
	
	
	// _/
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize(this, level );
		player = new UCMShip(this,DIM_X - 1, DIM_Y/2);
		board.add(player);
	}
	
	// _/
	public Random getRandom() {
		return rand;
	}
		
	// _/
	public Level getLevel() {
		return level;
	}
	// _/	
	public void addObject(GameObject object) {
		board.add(object);
	}
			
	// _/
	public String positionToString(int posX, int posY) {
		return this.board.stringObjectInPos(posX, posY);
	}
			
	// _/
	public boolean isFinished() {
				
		return playerWin() || aliensWin() || doExit;
	}
		
	/*
	 * GANA CUANDO LA VIDA DEL JUGADOR ES CERO O 
	 * 	LOS ALIENS HAN LLEGADO ATERRIZAR
	 */
	public boolean aliensWin() {
		return !player.isAlive ();  //|| AlienShip.haveLanded();		
		
	}

	// _/
	private boolean playerWin () {
		return false; // AlienShip.allDead();
	}
	
	
	
	public boolean isOnBoard(int posX, int posY) {
		
		return this.board.existOnBoard(posX, posY);
	}
	

	
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else return "This should not happen";
	}
	
	
	//FUNCIONES INVOCADAS DESDE LOS COMANDOS
	
	
	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}
	
	public void reset() {
		initGame();
	}
	
	public void exit() {
		doExit = false;
	}
	
	public void help() {
		// TODO Auto-generated method stub
		
	}
	public void list() {
		// TODO Auto-generated method stub
		
	}
	
	public void shoot() {
		// TODO Auto-generated method stub
		
	}
	
	public void shock(int posX, int posY) {
		//this.board.activeShock(0,8);
	}
	
	//************************************************
	
	
	
	//UCM SHIP
	
	public void move(String direccion, int numCasillas) {
		player.move(direccion, numCasillas);
	}
	
	//************************************************
	
	
	
	//METODOS ABSTARACTO DE LA INTERFEZ IPLAYERCONTROLLER
	public boolean move (int numCells) {
		return player.move(numCells);
	}
	public boolean shootMissile() {
		return true;
	}
	public boolean shockWave() {
		boolean active = false;
		if(this.board.existShowaveOnBoard()) {
			active = true;
			this.board.activeShockwave();
			//activar shockwe
		}
		return active;
	}
	
	// Callbacks
	public void receivePoints(int points) {
		
	}
	public void enableShockWave() {
		
	}
	public void enableMissile() {
		
	}
	
	//***************************************************
	
	public String infoToString(GamePrinter board) {
		

		return "Life: " + this.player.getLive() +
				"\nNumber of cycles: " + this.currentCycle +
				"\nPoint: " + 0 +
				"\nRamaining aliens: " + 10 +
				"\nShockWave: NO\n" +
				board.toString();

		
	}


	
	
	
}
