package board;
import logic.Game;
import logic.GameObjectBoard;


public abstract class GamePrinter  {
	
	protected Game game;
	protected String typeBoard;
	/*
	 * PUEDO LLAMAR UN METODO DEL GAME QUE ME DEVUELVA EL OBJETO
	 * 	->private GameObjectBoard board;
	 */
	
	public GamePrinter(String typeBoard) {
		this.typeBoard = typeBoard;
	}
	
	public GamePrinter() {
		
	}
	
	public void setGamePrinter (Game game) {
		this.game = game;
	}
	
	public abstract String toString();

	public abstract GamePrinter parseBoard(String typeBoard);
	
}
