package commands;
import exceptions.*;
import logic.Game;

public class ResetCommand extends Command {
	
	public ResetCommand() {
		super("reset", "r", "[r]eset", "Starts a new game");
	}

	public boolean execute(Game game) throws CommandExecuteException {
		
		game.reset();
		return true;

	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		
		Command command = null;

		if (matchCommandName(commandWords[0])) {
			/*
			 * - Command Pattern
				  * parse de comandos sin parámetros puede devolver "this" en vez de "new XXCommand"
				  + es lo que permite subir el método parse a una superclase "NoParamsCommand"
			 */
			if(commandWords.length == 1) command = this;
			else throw new CommandParseException (incorrectNumArgsMsg);
		}
		
		return command;
	}
	
}
