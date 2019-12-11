package Logic;

import Objects.GameObject;
import Objects.Ovni;
import Objects.DestroyerAlien;
import Objects.RegularAlien;

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

	
	/*
	 * -PARA HARD Y INSANE  COMIENZO FILA 1 A LA 2 Y COLUMNAS 3 A LA 7
	 * -PARA EASY COMIENZO EN LA FILA 1 Y COLUMNAS 3 A LA 7
	 */
	private void initializeRegularAliens () {
		
		//RegularAliens + DestroyerShip + Ship 

		if(this.level.equals(Level.EASY)) {
			for(int fila = 1; fila < 2 ; fila++) {
				for (int columna = 3; columna < 7; columna++) {
					this.board.add(new RegularAlien(this.game, fila, columna, 2));
				}
			}
		}
		else if(this.level.equals(Level.HARD)) {
			for(int fila = 1; fila < 3 ; fila++) {
				for (int columna = 3; columna < 7; columna++) {
					this.board.add(new RegularAlien(this.game, fila, columna, 2));
				}
			}
		}
		
		else {
			for(int fila = 1; fila < 4 ; fila++) {
				for (int columna = 3; columna < 7 ; columna++) {
					this.board.add(new RegularAlien(this.game, fila, columna, 2));
				}
			}
		}
		
	
	}
		//destroyer
		
	/*
	 * -PARA HARD Y EASY FILA 3 Y COLUMNAS 5 Y 6 
	 * -PARA INSANE FILA 3 Y COLUMNAS 4 A LA 7
	 */
	private void initializeDestroyerAliens () {
		if(this.level.equals(Level.EASY)) {
			for(int fila = 2; fila < 3 ; fila++) {
				for (int columna = 4; columna < 6; columna++) {
					this.board.add(new DestroyerAlien(this.game, fila, columna,1));
				}
			}
		}
		else if(this.level.equals(Level.HARD)) {
			for(int fila = 3; fila < 4 ; fila++) {
				for (int columna = 3; columna < 7; columna++) {
					this.board.add(new DestroyerAlien(this.game, fila, columna, 1));
				}
			}
			
			//hpp�aadsfasdf�
		}
		else {
			for(int fila = 4; fila < 5 ; fila++) {
				for (int columna = 3; columna < 7; columna++) {
					this.board.add(new DestroyerAlien(this.game, fila, columna, 1));
				}
			}
		}
	}
}
