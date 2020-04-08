package board;

import logic.Game;

public class Stringifier extends GamePrinter {
	
	public Stringifier(Game game) {
		super(game);
		
	}

	/*
	 * [Generamos el juego serializado]
	 * ->Debemos implementar un metodo que devuelva el tamaño del array
	 * ->
	 */
	@Override
	public String toString() {
		
		String string = "--- Space Invaders v2.0 ---\n";
		string += "\n";
		string += "G;" + game.getCurrentCycle() + "\n";
		string += "L;" + game.getLevel().name() + "\n";
		string += game.stringifier() + "\n";
		
		return string;
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
