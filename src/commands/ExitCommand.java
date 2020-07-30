package commands;

import exceptions.CommandParseException;
import logic.Game;

public class ExitCommand extends Command{

	public ExitCommand() {
		super("exit", "e", "[e]xit", "Terminates the program");
	}

	public boolean execute(Game game) {
		game.exit();
		return true;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException
	{
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
