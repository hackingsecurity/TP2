package board;


public class Stringifier extends GamePrinter {
	
	
	
	public Stringifier() {
		super();
	}

	/*
	 * - Stringify:
	 * 	toString de Stringifier debe contener solo una llamada a un metodo de Game
	 */
	
	/*
	 * [Generamos el juego serializado]
	 * ->Debemos implementar un metodo que devuelva el tamaño del array
	 * ->
	 */
	@Override
	public String toString() {
		return game.stringifier();
	}
	
	
	/*public GamePrinter parseBoard(String typeBoard){
		
		GamePrinter printer = null;
		
		if (typeBoard.equalsIgnoreCase("stringifier")) {
			printer = new Stringifier();
		}
	
		return printer;
	}
*/
}
