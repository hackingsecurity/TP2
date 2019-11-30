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
	this. level = level;
	this. game = game;
	board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
	
	initializeOvni () ;
	initializeRegularAliens () ;
	initializeDestroyerAliens () ;
	return board;
	}
	
	private void initializeOvni () {
		
		GameObject object = new Ovni();
		//object.
	}
	private void initializeRegularAliens () {
	// TODO implement
	}
	private void initializeDestroyerAliens () {
	// TODO implement
	}
}
