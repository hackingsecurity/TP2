package commands;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class UpdateCommand extends Command{
	public UpdateCommand() {
		super("none", "", "[none]", "Skips one cycle");
	}

	public boolean execute(Game game) throws CommandExecuteException {
		
		
		game.update();
		return true;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException
	{
		Command command = null;
		
		try {

			if (matchCommandName(commandWords[0])) {
			
			/*
			 * - Command Pattern
				  * parse de comandos sin parámetros puede devolver "this" en vez de "new XXCommand"
				  + es lo que permite subir el método parse a una superclase "NoParamsCommand"
			 */
			if(commandWords.length == 1) command = this;
			else throw new CommandParseException (incorrectNumArgsMsg);
			
			}
		}
		catch(CommandParseException e) {
			throw new CommandParseException(e.getMessage());
		}
		
		return command;
	}
	
}
