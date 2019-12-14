package board;

import Logic.Game;
import Logic.GameObjectBoard;
import Logic.Level;
import object.DestroyerAlien;
import object.Ovni;
import object.RegularAlien;

public class BoardInitializer {

	private Level level ;
	private GameObjectBoard board;
	private Game game;
	
	public BoardInitializer() {
		
	}
	
	public GameObjectBoard initialize(Game game, Level level) {
	this.level = level;
	this.game = game;
	board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
	
	initializeOvni () ;
	initializeRegularAliens () ;
	initializeDestroyerAliens () ;
	return board;
	}
	
	
	/*
	 * INICIALIZAMOS EL OVNI
	 */
	private void initializeOvni () {
		board.add(new Ovni(this.game));
	}
	
	 
	

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
	
	private void initializeDestroyerAliens () {
		if(this.level.equals(Level.EASY)) {
			for(int fila = 2; fila < 3 ; fila++) {
				for (int columna = 4; columna < 6; columna++) {
					this.board.add(new DestroyerAlien(this.game, fila, columna,(fila+columna)));
				}
			}
		}
		else if(this.level.equals(Level.HARD)) {
			for(int fila = 3; fila < 4 ; fila++) {
				for (int columna = 3; columna < 7; columna++) {
					this.board.add(new DestroyerAlien(this.game, fila, columna, (fila+columna)));
				}
			}
			
		
		}
		else {
			for(int fila = 4; fila < 5 ; fila++) {
				for (int columna = 3; columna < 7; columna++) {
					this.board.add(new DestroyerAlien(this.game, fila, columna, (fila+columna)));
				}
			}
		}
	}
}
