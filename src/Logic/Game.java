package Logic;
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
	
	
	public final static int DIM_X = 9;
	public final static int DIM_Y = 8;
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
	public void initGame () {
		currentCycle = 0;
		board = initializer . initialize (this, level );
		player = new UCMShip(this, DIM_X / 2, DIM_Y − 1);
		board.add(player);
	}
	
	public Random getRandom() {
		return rand;
	}
		
	public Level getLevel() {
		return level;
	}
		
	public void reset() {
		initGame();
		}
		
	public void addObject(GameObject object) {
		board.add(object);
	}
			
	public String positionToString( /∗ coordinadas ∗/ ) {
		return board.toString( /∗ coordinadas ∗/ );
	}
			
	public boolean isFinished() {
				
		return playerWin() || aliensWin() || doExit;
	}
			
	public boolean aliensWin() {
		return !player.isAlive () || AlienShip.haveLanded();		
		
	}

	private boolean playerWin () {
		return AlienShip.allDead();
	}
	
	public void update() {
		board.computerAction();
		board.update();
		currentCycle += 1;
	}
	
	public boolean isOnBoard( /∗ coordinadas ∗/ ) {
		return /∗ condición de rango sobre las coordinadas ∗/ ;
	}
	
	public void exit() {
		doExit = true;
	}
	
	public String infoToString() {
		return /∗ cadena estado−juego para imprimir junto con el tablero ∗/ ;
	}
	
	public String getWinnerMessage () {
		if (playerWin()) return "Player win!";
		else if (aliensWin()) return "Aliens win!";
		else if (doExit) return "Player exits the game";
		else "This should not happen"
	}	
	
	
	
	//TODO implementar los metodos de la interfaz IPlayerController
}


/*

public class Game {
	
	//atributos
	private int cicloActual;
	private int points;
	private int navesEnemigas;
	private UCMShip ucm;
	private Ovni ovni;
	private UCMmisil misil;
	private boolean shockWave;
	private int sentido;
	private Random ran;
	private Level level;
	private boolean ovniExist;
	private boolean navesWins;
	private boolean misilExists;
	//listas
	private DestroyerShipList desList;
	private RegularShipList reguList;
	private BombList bomblist;
	
	
	// constructor 
	public Game(Level level, Random ran) {
		this.level = level;
		this.cicloActual=0;
		this.points = 0;
		//han ganado naves
		this.navesWins = false;
		//misil no existe al crear game
		this.misilExists = false;
		//ovni no existe al crear game
		this.ovniExist = false;
		this.navesEnemigas = level.getnDesShip() + level.getnRegShip();
		//iniciar las listas
		this.desList = new DestroyerShipList(level);
		this.reguList = new RegularShipList(level);
		this.bomblist = new BombList(level);
		//crear random
		this.ran = ran;
		// iniciar el ucmShip
		this.ucm = new UCMShip();
		this.shockWave = false;
		
		//iniciar el sentido (al principio hacia la izquierda)
		this.sentido = -1;
	}
	
	//geters attribute
	public int getCiclo_actual() {return cicloActual;}
	public boolean getShockWave() {return this.shockWave;}
	public int getNavesEnemigas() {return navesEnemigas;}
	public int getPoints() {return points;}
	
	//getters Listas
	public DestroyerShipList getDesList() {return desList;}
	public RegularShipList getReguList() {return reguList;}
	public BombList getBomblist() {return bomblist;}
	
	//setters attribute
	public void setCiclo_actual(int ciclo_actual) {this.cicloActual = ciclo_actual;}
	public void setPoints(int points) {this.points = points;}
	public void setShockWave(boolean shockWave) {this.shockWave = shockWave;}
	

	//setters list
	public void setNavesEnemigas(int navesEnemigas) {this.navesEnemigas = navesEnemigas;}

	
	//setter object
	public UCMShip getUcm() {return this.ucm;}	
	
	
	//metodos privados
	private String existShockWave()
	{
		String exist;
		if(getShockWave()) {
			exist = new String("SI");
		}
		else
			exist = new String("NO");
		
		return exist;
	}
	
	
	public void update(Level level) {
		// TODO Auto-generated method stub
		int velocidad = level.getSpeed();
		cicloActual += 1;
			if(cicloActual % velocidad == 0 && cicloActual != 0) {
			{
					if(!cambiarSentido()){
						moverNaves(getSentido());
					}
					else{
						this.navesWins = moverNavesAbajo(); // dar�a true en el caso de ser true porque ha llegado a la ultima fila
					}
				}
			}
			
			if(this.misilExists == true){
				this.misil.update();
			}
			bomblist.update(this);
			if(this.ovniExist==false){
					
					ovniExist = crearOvni();
				}
			else{
				if(ovni.getY()!=0){
					ovni.update();
				}else {
					this.ovni = null;
					ovniExist = false;
				}
			}
			
			
	}
	public boolean crearOvni(){
		boolean crear = false;
		int prob;
		double probOvni = level.getProbaOvni()* 10;
		int probO = (int)(probOvni);
		prob = this.ran.nextInt(10)+1;
		
		if(prob>0 && prob <= probO ){
			 this.ovni = new Ovni();
			 crear = true;
		}
		return crear;
	}
			
			
	public boolean  cambiarSentido() {
		 boolean change = false;
			for(int i = 0;i < this.reguList.getCont(); i++) {
				
				if((this.reguList.getRegularList(i).getY() == 0) && this.sentido==-1
						||(this.reguList.getRegularList(i).getY()==8)&&this.sentido==1) {
					this.sentido *= -1;
					change = true;
					
				}
			}
			if(change == false){
				for(int i = 0;i < this.desList.getCont(); i++) {
					
					if((this.desList.getDestroyerList(i).getY() == 0) && this.sentido==-1
							||(this.desList.getDestroyerList(i).getY()==8)&&this.sentido==1) {
						this.sentido *= -1;
						change = true;
						
					}
				}
			}
		return change;
	}
	
	public int compObj(int px, int py) {

		
		int p=6;
		
		for(int i = 0;i < desList.getCont();i++) {
			if((py == desList.getDestroyerList(i).getY()) && (px == desList.getDestroyerList(i).getX())) {
				 p = 0;
			}
		}
		for(int i = 0;i < reguList.getCont();i++) {
				if((py == reguList.getRegularList(i).getY())&&(px == reguList.getRegularList(i).getX())) {
					 p = 1;
				}
		}
		
		if(bomblist.getCont() != 0 )
		{
			for(int i = 0;i < bomblist.getCont();i++) {
				if((py == bomblist.getBombList(i).getY())&&(px == bomblist.getBombList(i)
						.getX())) {
					p =  2;
				}
		}
	
		}
		if((py == ucm.getY()) && px == ucm.getX()) {
				p =  3;
			}
		if(this.ovni != null){
			if((py == ovni.getY()) && px == ovni.getX()) {
				p =  4;
			}
		}
		if(this.misil != null){
			if((py == misil.getY()) && px == misil.getX()) {
					p =  5;
				}
		}
		
	
		return p;
	}

	
	public void moverNaves(int sentido) {
		for(int i = 0; i < reguList.getCont(); i++) {
			int x = reguList.getRegularList(i).getY();
			reguList.getRegularList(i).setY(x+sentido);
			}
		for(int i = 0; i < desList.getCont();i++) {
			int x = desList.getDestroyerList(i).getY();
			desList.getDestroyerList(i).setY(x+sentido);
		}
	}
	//la clase devuelve true cuando ya no puede bajar porque ha llegado a la fila de ucmship y false cuando puede mover abajo
	public boolean moverNavesAbajo() {
		boolean perdido = false;
		
			for(int i = 0; i < reguList.getCont(); i++) {
				int y = reguList.getRegularList(i).getX();
				if(y == 6){
					perdido = true;
					break;
				}
				reguList.getRegularList(i).setX(y+1);
					if(reguList.getRegularList(i).getX()== 7){perdido = true;}
				}
			for(int i = 0; i < desList.getCont();i++) {
				int y = desList.getDestroyerList(i).getX();
				if (y == 6){
					perdido = true;
					break;
				}
				desList.getDestroyerList(i).setX(y+1);
			}
		
		return perdido;
	
		
	}
	public int getSentido() {
		return this.sentido;
	}

	
	public Ovni getOvni (){
		return  this.ovni;
	}
	
	
	public Level getLevel ()
	{
		return this.level;
	}
	public Random getRand(){
		return this.ran;
	}
	public void setOvni(Ovni ovni){
		this.ovni = ovni;
	}
	public boolean getNavesWins(){
		return this.navesWins;
	}
	public void setGameOver(){
		this.navesWins=true;
	}
	public void lanzarMisil(boolean exist){
		if(!exist){
		this.misil = new UCMmisil(ucm);
		this.misilExists=true;}
		
	}
	public UCMmisil getMisil(){
		return this.misil;
	}
	public boolean getMisilExist(){
		return this.misilExists;
	}
	@Override
	public String toString(){
		
		return "Life:" + " " + this.getUcm().getRes() + 
				"\n" + "Number of Cycles:"+ " " + this.cicloActual + 
				"\n" + "Points:" + " " + this.points + 
				"\n" + "Remaining aliens:"+ " " + this.navesEnemigas + 
				"\n" + "ShockWave: " + existShockWave();		
		}
}


*/