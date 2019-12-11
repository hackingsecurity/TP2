package Logic;

import Control.Command;
import Control.ShockwaveCommand;

public class SupermisilCommand extends Command{
	//CONSTRUCTOR
	
	/*
		public SupermisilCommand() {
			
			super("supermisil", "c", "Comprar Supermisil", "Añade un nuevo misil que hace mas daño", true);
		
		}
		
		*/
		
		//METHODS
		public boolean execute(Game game) {
			return false;
			/*
			boolean b = game.BuySuperMissile();
			
			if(!b) {
				
			}
			return b;
			*/
		}
		
			
		public Command parse(String[] commandWords)
		{
			Command command = null;
			
			if (!(commandWords.length > 1)) {
				if (matchCommandName(commandWords[0])) {
					command = new SupermisilCommand();
				}
			}
			return command;
		}
		
		

}
