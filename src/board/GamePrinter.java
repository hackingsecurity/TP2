package board;
import Logic.Game;
import Logic.GameObjectBoard;


public abstract class GamePrinter  {
	
	protected Game game;
	protected GameObjectBoard board;
	/*
	 * PUEDO LLAMAR UN METODO DEL GAME QUE ME DEVUELVA EL OBJETO
	 * 	->private GameObjectBoard board;
	 */
	
	public void setGamePrinter (Game game) {
		this.game = game;
		this.board = game.getBoard();
	}
	
	public abstract String toString();
	
}
