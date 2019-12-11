package Logic;
import Objects.AlienShip;
import Objects.Bomb;
import Objects.GameObject;
import Objects.Shockwave;
import Objects.UCMMissile;
import Objects.UCMShip;
import java.util.Random;


public class Game implements IPlayerController{
	
	
	public final static int DIM_X = 8;
	public final static int DIM_Y = 9;
	private int currentCycle;
	private Random rand;
	private Level level ;
	private boolean shockwave;
	private int points ;
	
	private boolean doExit;
	private BoardInitializer initializer ;
	
	private GameObjectBoard board;
	private UCMShip player;
	
	public Game (Level level, Random random){
		this. rand = random;
		this. level = level;
		this.rand = random;
		this.level = level;
		initializer = new BoardInitializer();
		this.shockwave = true;
		this.points = 0;
		initGame();
	}
	
	
	// _/
	public void initGame () {
		currentCycle = 0;
		board = initializer.initialize(this, level );
		player = new UCMShip(this,DIM_X - 1, DIM_Y/2);
		this.doExit = false;
		board.add(player);
	}
	
	// _/
	public int getCurrentCycle(){
		return this.currentCycle;
	}
	public Random getRandom() {
		return rand;
	}
		
	// _/
	public Level getLevel() {
		return level;
	}
	// _/	

			
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
		return !player.isAlive () || AlienShip.HaveLanded();		
		
	}

	// _/
	private boolean playerWin () {
		return  AlienShip.AllDeads();
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
		doExit = true;
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
		return player.getMisilLanzado();
	}
	public boolean  shockWave() {
		boolean shock = false;
		if(this.shockwave) {
			board.add(new Shockwave(this,0,10,1));
			shock = true;
		}
		return shock;
	}
	
	// Callbacks
	public void receivePoints(int points) {
		this.points += points;
	}
	public void enableShockWave() {
		this.shockwave = true;
	}
	public void enableMissile() {
		board.add(new UCMMissile(this,player.getPosX()-1,player.getPosY(),1));
		player.setMissil(true);
	}
	public void disableMissile() {
		player.setMissil(false);
	}
	//***************************************************
	
	public String infoToString(GamePrinter board) {
		

		return "Life: " + this.player.getLive() +
				"\nNumber of cycles: " + this.currentCycle +
				"\nPoint: " + this.points +
				"\nRamaining aliens: " + AlienShip.getContadorAlien() + "\n" +
				"\nShockWave: " + shock() + "\n" +
				board.toString();

		
	}
	
	public String shock () {
		
		String shock = "NO";
		if(shockwave)
		{
			shock = "SI";
		}
		
		return shock;
	}
	public int getCurrentObjects(){
		return this.getCurrentObjects();
	}




	public void activarBomba(int posX, int posY) {
		board.add(new Bomb(this,posX,posY,1));
	}


	public void disableSW() {
		// TODO Auto-generated method stub
		this.shockwave = false;
	}


	public void saveGame() {
		// TODO Auto-generated method stub
		
	}



	
	
	
}
