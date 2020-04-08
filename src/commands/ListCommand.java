package commands;

import exceptions.CommandParseException;
import logic.Game;

public class ListCommand extends Command {


	public ListCommand() {
		super("List", "l", "list", "Prints the list of available ships");
	}

	public boolean execute(Game game) {
		System.out.print(game.list());
		return false; //No mostramos un nueva pantalla
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
