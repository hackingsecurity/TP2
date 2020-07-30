package commands;

import exceptions.CommandParseException;
import logic.Game;

public class ListCommand extends Command {


	public ListCommand() {
		super("List", "l", "[l]ist", "Prints the list of available ships");
	}

	public boolean execute(Game game) {
		System.out.print(game.list());
		return false; //No mostramos un nueva pantalla
	}
	
	
	public Command parse(String[] commandWords) throws CommandParseException{	
		Command command = null;
		
		if (matchCommandName(commandWords[0])) {
			/*
			 * - Command Pattern
				  * parse de comandos sin parámetros puede devolver "this" en vez de "new XXCommand"
				  + es lo que permite subir el método parse a una superclase "NoParamsCommand"
			 */
			if (commandWords.length == 1) command = this;
			else throw new CommandParseException (incorrectNumArgsMsg);
		}
		
		return command;
	}
}
