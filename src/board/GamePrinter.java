package board;
import logic.Game;
import logic.GameObjectBoard;


public abstract class GamePrinter  {
	
	protected Game game;
	
	/*
	 * PUEDO LLAMAR UN METODO DEL GAME QUE ME DEVUELVA EL OBJETO
	 * 	->private GameObjectBoard board;
	 */
	
	public GamePrinter(Game game) {
		this.game = game;
	}
	
	
	public abstract String toString();

	//public abstract GamePrinter parseBoard(String typeBoard);
	
}
