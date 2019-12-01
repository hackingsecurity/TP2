package Logic;
import Objects.AlienShip;
import Objects.GameObject;
import Objects.UCMShip;
import java.util.Random;


//FALTA IMPORTAR CLASES QUE USA GAME

/*
 * La clase Game solo tendrá un
	atributo de tipo GameObjectBoard y otro de tipo UCMShip. Con estos dos atributos se
	gestionarán todos los elementos del juego, incluidos el Ovni, los disparos del jugador y las
	bombas lanzadas por las naves enemigas.
	
	El nuevo game mantiene una referencia al player y al board donde se almacenan los
	objetos de juego. Cuando tiene que hacer alguna acción, la delega a la clase correspon-
	diente. Podríamos decir que el Game no hace absolutamente nada salvo delegar.
	
		En el Game usamos una clase auxiliar para inicializar el juego. El boardInitializer se
	encarga de añadir los objetos de juego en el juego dependiendo del nivel.
	Si nos fijaos en la declaración del Game vemos que implementa un interfaz IPlayerCon-
	troller. Esta interfaz no es 100 % necesaria, pero nos ayuda a abstraer qué métodos son
	los necesarios para tratar la comunicación con el jugador. En realidad es lo que se conoce
	como mixin es una forma de incluir métodos de una clase en otra, sin que exista relación
	de herencia entre ellas.
 */


public class Game implements IPlayerController{
	
	
	public final static int DIM_X = 8;
	public final static int DIM_Y = 9;
	private int currentCycle;
	private Random rand;
	private Level level ;
	
	private boolean doExit;
	private BoardInitializer initializer ;
	private GamePrinter boardWithObjects;
	
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
	
	
	
	public boolean isOnBoard( /*coordinadas */ ) {
		return true /* condición de rango sobre las coordinadas */ ;
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
	public void move() {
		// TODO Auto-generated method stub
		
	}
	public void shoot() {
		// TODO Auto-generated method stub
		
	}
	public void shockwave() {
		// TODO Auto-generated method stub
		
	}
	
	//**************************************************
	
	
	//METODOS ABSTARACTO DE LA INTERFEZ IPLAYERCONTROLLER
	public boolean move (int numCells) {
		
		return true;
	}
	public boolean shootMissile() {
		return true;
	}
	public boolean shockWave() {
		return true;
	}
	// Callbacks
	public void receivePoints(int points) {
		
	}
	public void enableShockWave() {
		
	}
	public void enableMissile() {
		
	}
	
	
	public String infoToString(GamePrinter board) {
		
		String stringObject  = "El estado del juego es\n\n";
				
		stringObject += board.toString();	

		return stringObject;
	}
	
	//***************************************************
}
