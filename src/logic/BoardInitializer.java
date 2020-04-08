package logic;

import object.AlienShip;
import object.DestroyerAlien;
import object.Ovni;
import object.RegularAlien;
import utils.Level;


/**
 * Inicializa todos los objetos del juego 
 *  
 */
public class BoardInitializer {

	
	//-----------------VARIABLES----------------
	
	private Level level ;
	private GameObjectBoard board;
	private Game game;
	
	//-----------------CONTRUCTOR---------------
	
	public BoardInitializer() {
		
	}
	
	//--------------GETTER AND SETTER-----------
	
	public GameObjectBoard initialize(Game game, Level level) {
	this.level = level;
	this.game = game;
	board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);

	initializeOvni () ;
	initializeRegularAliens () ;
	initializeDestroyerAliens () ;
	return board;
	}
	
	
	//---------------OWNER METHODS--------------
	
	/**
	 * Inicialiamos el el tablero con visibilidad nula
	 */
	private void initializeOvni () {
		board.add(new Ovni(this.game));
	}
	
	/**
	 * Inicializamos los regularAliens en el tablero
	 */
	private void initializeRegularAliens () {
		
		//regularAliens 

		if(this.level.equals(Level.EASY)) {
			for(int fila = 1; fila < 2 ; fila++) {
				for (int columna = 3; columna < 7; columna++) {
					this.board.add(new RegularAlien(this.game, fila, columna));
				}
			}
		}
		else if(this.level.equals(Level.HARD)) {
			for(int fila = 1; fila < 3 ; fila++) {
				for (int columna = 3; columna < 7; columna++) {
					this.board.add(new RegularAlien(this.game, fila, columna));
				}
			}
		}
		else {
			for(int fila = 1; fila < 4 ; fila++) {
				for (int columna = 3; columna < 7 ; columna++) {
					this.board.add(new RegularAlien(this.game, fila, columna));
				}
			}
		}
	}
	
	
	/**
	 * Inicializamos los Destroyers en el tablero
	 */
	private void initializeDestroyerAliens () {
		if(this.level.equals(Level.EASY)) {
			for(int fila = 2; fila < 3 ; fila++) {
				for (int columna = 4; columna < 6; columna++) {
					this.board.add(new DestroyerAlien(this.game, fila, columna));
				}
			}
		}
		else if(this.level.equals(Level.HARD)) {
			for(int fila = 3; fila < 4 ; fila++) {
				for (int columna = 3; columna < 7; columna++) {
					this.board.add(new DestroyerAlien(this.game, fila, columna));
				}
			}
			
		
		}
		else {
			for(int fila = 4; fila < 5 ; fila++) {
				for (int columna = 3; columna < 7; columna++) {
					this.board.add(new DestroyerAlien(this.game, fila, columna));
				}
			}
		}
	}
}
