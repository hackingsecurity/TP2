package commands;

import exceptions.CommandParseException;
import logic.Game;

public class ListCommand extends Command {


	public ListCommand() {
		super("List", "l", "list", "Prints the list of available ships");
	}

	/*
	 * MOSTRAMOS SOLO LA LISTA PERO NO EJECUTAMOS UNA NUEVA PANTALLA.
	 */
	public boolean execute(Game game) {
		game.list();
		return false;
	}
	
	
	public Command parse(String[] commandWords) throws CommandParseException{	
		Command command = null;
		
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 1) command = new ListCommand();
			else throw new CommandParseException (incorrectNumArgsMsg);
		}
		
		return command;
	}
}
