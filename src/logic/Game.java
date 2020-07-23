package logic;
import interfaces.IPlayerController;
import object.AlienShip;
import object.Bomb;
import object.DestroyerAlien;
import object.ExplodeShip;
import object.GameObject;
import object.GameObjectGenerator;
import object.ShockWave;
import object.SuperMissile;
import object.UCMMissile;
import object.UCMShip;
import utils.CommandGenerator;
import utils.Level;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import board.GamePrinter;
import board.PrinterTypes;
import board.Stringifier;
import exceptions.FileContentsException;

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
	public final static String FILETMP = "tmp";
	
	private  int currentCycle;
	private boolean doExit;

	//-----------------VARIABLES----------------
	private boolean stringifying = false;
	private boolean loading;
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
		loading = true;
	}
	
	//--------------GETTER AND SETTER-----------
	
		public int getCurrentCycle(){return this.currentCycle;}
		public Random getRandom() {return rand;}
		public Level getLevel() {return level;}
		public int getPoints() {return this.points;}
		public UCMShip getUCMShip() {return this.player;}
		public void setPlayer(UCMShip ship) {this.player = ship;}

	
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
	
	public String stringifier() { 
		stringifying = false;
		return board.stringifier();
		
	}


	
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
	
	
	
	public void load(BufferedReader br) throws IOException, FileContentsException {
		
		FileContentsVerifier  verifier = new FileContentsVerifier();
		String linea = br.readLine();
		String[] words;
		// hay que guardar el tablero que llevemos antes de guardar por si la nueva partida que queremos cargar
		// no coge los datos correctamente
		GameObjectBoard board2 = new GameObjectBoard(DIM_X,DIM_Y);
		
		
		board.cleanBoard();
		if (verifier.verifyCycleString(linea)) {
			words = linea.split(";");
			this.currentCycle = Integer.parseInt(words[1]);
		}
		else {
			
			throw new FileContentsException("invalid file, unknown line prefix");
			
		}
		
		linea = br.readLine();
		if(verifier.verifyLevelString(linea)) {
			words = linea.split(";");
			if(linea.equalsIgnoreCase("easy")) this.level = Level.EASY;
			else if(linea.equalsIgnoreCase("hard")) this.level = Level.HARD;
			else if(linea.equalsIgnoreCase("insane")) this.level = Level.INSANE;
		}else {
			
			throw new FileContentsException("invalid file, unknown line prefix");
		}

		this.loading = false;
		
		linea = br.readLine().trim();
		
		while( linea != null && !linea.isEmpty() ) {
			GameObject gameObject = GameObjectGenerator.parse(linea, this, verifier);
				if (gameObject == null) {
					
					throw new FileContentsException("invalid file, unknown line prefix");}
			board.add(gameObject);
			linea = br.readLine().trim();
		}
	}

	/*
	
	public  void load(BufferedReader br) throws IOException {
		
		String linea = br.readLine().trim();
		linea = linea.split(",")[1]; // número de ciclos
		this.currentCycle = Integer.parseInt(linea);
		linea = br.readLine().trim();
		linea = linea.split(",")[1]; // level 
		if(linea.equalsIgnoreCase("easy")) this.level = Level.EASY;
		else if(linea.equalsIgnoreCase("hard")) this.level = Level.HARD;
		else if(linea.equalsIgnoreCase("insane")) this.level = Level.INSANE;
		//por acabar rellenar los bjetos y habria que añadir un reset que ponga
	 // el estado de juego vacio
		this.loading = false;
		linea = br.readLine().trim();
		while( linea != null && !linea.isEmpty() ) {
			GameObject gameObject = GameObjectGenerator.parse(linea, this, verifier);
				if (gameObject == null)
						throw new FileContentsException("invalid file, unknown line prefix");
			board.add(gameObject);
			linea = br.readLine().trim();
		}
	}
	*/

	/*Cateamos  DestroyerAlien*/
	public DestroyerAlien getBombOwner(int ownerRef) {
		
		return (DestroyerAlien) this.board.getLabelOwnwer(ownerRef);
	}

	public boolean isStringifying() {
		
		return this.stringifying;
	}

	public void setStringifying() {
		stringifying = true;
		
	}

	public boolean save(String file) throws IOException {
		
		GamePrinter printer = new Stringifier(this);
		String board = printer.toString();
		String fileSaveTmp = file + ".dat";
		boolean canSave = false;
		
		try {
			FileWriter save = new FileWriter(fileSaveTmp);
			for(int i=0; i < board.length(); i++) {
				save.write(board.charAt(i));
			}
			save.close();
			canSave = true;
		} catch (IOException e) {
			e.getMessage();
		}
		return canSave;
	}

	
	/*
	 * GamePrinter printer = new Stringifier(this);
		String board = printer.toString();
		
		String file = in.nextLine();
		file = file+".dat";
		try {
			FileWriter save = new FileWriter(file);
			for(int i=0; i < board.length(); i++) {
				save.write(board.charAt(i));
			}
			save.close();
		} catch (IOException e) {
			e.getMessage();
		}
		
	 */
	
	
}
