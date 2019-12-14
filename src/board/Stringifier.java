package board;

import Logic.Game;

public class Stringifier extends GamePrinter {
	
	public Stringifier() {

	}

	/*
	 * [Generamos el juego serializado]
	 * ->Debemos implementar un metodo que devuelva el tamaño del array
	 * ->
	 */
	@Override
	public String toString() {
		
		String string = "Space Invaders v2.0 \n";
		string += "\n";
		string += "G;" + game.getCurrentCycle() + "\n";
		string += "L;" + game.getLevel().name() + "\n";
		
		/*
		for(int i = 0; i < board; i++) {
			string += board[i].stringifier() + "\n";
		}
		*/
		return string;
	}
}
