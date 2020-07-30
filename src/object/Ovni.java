package object;

import interfaces.IExecuteRandomActions;
import logic.FileContentsVerifier;
import logic.Game;


/**
 * Creamos un Ovni
 * 	-Solo debe existir uno en la game
 * 	-y debemos tener un atributo para la visibilidad del ovni en el tablero
 *
 */
public class Ovni  extends EnemyShip  {
	
	
	//-----------------VARIABLES----------------

	private boolean visibilidadOvni;

	//-----------------CONTRUCTOR---------------
	
	public Ovni(Game game) {
		//Game, posX, posY, live, puntos
		super(game, 0 ,9, 1, 25,"O" );
		this.visibilidadOvni = false;
		
	}
	public Ovni(Game game, int x, int y) {
		super(game,x,y,1,25,"O");
		this.visibilidadOvni = true;
	}
	//---------------OWNER METHODS--------------
	
	
	//--------------METHODS IMPLEMENTS IAttack-----------
	
	public Ovni() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public boolean receiveMissileAttack(int damage) {
		boolean hit = false;
		if(this.isAlive()) {
			this.receiveDamageFromOtherObject(damage);
			game.enableShockWave();
			this.visibilidadOvni = false;
			hit = true;
		}
			return hit;
	};
	
	public boolean receiveSuperMissileAttack(int damage) {
			boolean hit = false;
			if(this.isAlive()) {
				this.receiveDamageFromOtherObject(damage);
				game.enableShockWave();
				this.visibilidadOvni = true;
				hit = true;
			}
				return hit;
	};
	
	
	/**
	 * OJO AL DARLE UN OVNI LUEGO PUEDO HACERLE DAÑO AL OVNI
	 */
	public boolean receiveShockWaveAttack(int damage) {
			boolean hit = false;
			if(this.isAlive()) {
				this.visibilidadOvni = false;
				hit = true;
				}
			return hit;
		};
		
	
	//--------------ABSTRACT METHODS------------
	
	@Override
	public void computerAction() {
		if(!this.visibilidadOvni){
			
			if(IExecuteRandomActions.canGenerateRandomOvni(this.game)) {
				this.visibilidadOvni = true;			
			}
		}
	}
	@Override
	public void onDelete() {	
		game.receivePoints(25);	
	}
		
		
	@Override
	public void move() {
		if(this.visibilidadOvni){
			this.posY--;
			if(isOut())
				resetear();
		}
	}
	
	private void resetear() {
		this.posX = 0;
		this.posY = 9;
		
	}
	
		//--------------OBJECT FORMAT OUTPUT-----------
	public String stringifed() {
		if(this.visibilidadOvni) return super.stringifed();
		else return "";
	}
	@Override
	public String toString() {
		
		if(visibilidadOvni) {
			return "O[" + this.live + "]" ;
		}
		
		return null;
	}


	@Override
	protected GameObject parse(String stringFromFile, Game game2, FileContentsVerifier verifier) {
		
		if(stringFromFile.split(";")[0].equalsIgnoreCase("o")) {
			if(!verifier.verifyOvniString(stringFromFile, game2, 1)) return null;

			String coordenadas = stringFromFile.split(";")[1]; // recoge las coordenadas
			
			return new Ovni(game2,Integer.parseInt(coordenadas.split(",")[0]),Integer.parseInt(coordenadas.split(",")[1]));
		}
		
		return null;
	}
	
}
