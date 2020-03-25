package logic;
import board.BoardInitializer;
import board.BoardPrinter;
import interfaces.IPlayerController;
import object.AlienShip;
import object.Bomb;
import object.ExplodeShip;
import object.GameObject;
import object.Shockwave;
import object.SuperMissile;
import object.UCMMissile;
import object.UCMShip;

import java.util.Random;


public class Game implements IPlayerController{
	
	
	public final static int DIM_X = 8;
	public final static int DIM_Y = 9;
	private int currentCycle;
	private Random rand;
	private Level level ;
	private boolean shockwave;
	private int points ;
	private int superMisil;
	
	
	private boolean doExit;
	private BoardInitializer initializer ;
	
	private GameObjectBoard board;
	private UCMShip player;
	
	public Game (Level level, Random random){
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
		return player.getLanzado();
	}
	public boolean  shockWave() {
		boolean shock = false;
		if(this.shockwave) {
			
			shock = true;
		}
		return shock;
	}
	
	// Callbacks
	public void receivePoints(int points) {
		this.points += points;
	}
	public void enableShockWave() {
		board.add(new Shockwave(this,0,10,1));
	}
	public void enableMissile() {
		board.add(new UCMMissile(this,player.getPosX(),player.getPosY(),1));
		player.setLanzado(true);
	}
	/*public void enableSuperMissile() {
		board.add(new SuperMissile(this.player.getPosX(),player.getPosY(),1));
	}*/
	public void disableMissile() {
		player.setLanzado(false);
	}
	//***************************************************
	
	
	//CABECERA DEL JUEGO
	public String infoToString() {
		

		return "Life: " + this.player.getLive() +
				"\nNumber of cycles: " + this.currentCycle +
				"\nPoint: " + this.points +
				"\nRemaining aliens: " + AlienShip.getContadorAlien() + "\n" +
				"\nSuperMissiles: " + this.superMisil +
				"\nShockWave: " + shock() + "\n";
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




	public void activarBomba(int posX, int posY, int id) {
		board.add(new Bomb(this,posX,posY, id));
	}


	public void disableSW() {
		// TODO Auto-generated method stub
		this.shockwave = false;
	}


	public void disableBomba(int id) {
		board.disableBomba(id);
		
	}


	public void setShockwave(boolean sw) {
		// TODO Auto-generated method stub
		this.shockwave = sw;
		
	}


	public void changeRegularToExplode(int posX, int posY, int vida) {
		// TODO Auto-generated method stub
		if(board.changeRegularToExplode(posX,posY)) {
			board.add(new ExplodeShip(this,posX,posY,vida));
		}
	}


	public void explode(int posX, int posY, int damage) {
		// TODO Auto-generated method stub
		board.explode(posX, posY, damage);
		
	}
	public int getPoints() {
		return this.points;
	}

	public int  getSuperMisil() {
		return this.superMisil;
	}
	public void buyMisil() {
		// TODO Auto-generated method stub
		this.superMisil++;
	}


	@Override
	public void enableSuperMissile() {
		// TODO Auto-generated method stub
		board.add(new SuperMissile(this, this.player.getPosX(),player.getPosY(),1));
		player.setLanzado(true);
	}


	public void gastarSuperMissile() {
		// TODO Auto-generated method stub
		this.superMisil--;
	}

	public GameObjectBoard setBoard() {
		// TODO Auto-generated method stub
		return this.board;
	}

	public String stringifier() { return board.stringifier();}




	
	
	
}
