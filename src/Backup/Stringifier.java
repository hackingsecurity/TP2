
//EXPERIMENTOS VARIOS
package Backup;

import Logic.Game;
import Logic.GamePrinter;

public class Stringifier extends GamePrinter{
	
	//CONSTRUCTOR
	
	public Stringifier() {
	}
	
	//METODOS
	
	
	public String toString() {
		String string = "Space Invaders\n";
		string += "\n";
		string += "G;" + game.getCycle() + "\n";
		string += "L;" + game.getLevel().Name() + "\n";
		for(int i = 0; i < board.getCurrentObjects(); i++) {
			string += board.getBoard()[i].stringifier() + "\n";
		}
		return string;
	}
}
