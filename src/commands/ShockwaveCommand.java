package commands;

import exceptions.*;
import logic.Game;

public class ShockwaveCommand extends Command{
	
	public ShockwaveCommand() {
		super("shockwave", "w", "shock[W]ave", "UCM-Ship releases a shock wave");
	}

	public boolean execute(Game game) throws CommandExecuteException {
	
		boolean  ex = false;
		
		try {
			if(game.shockWave()){
				game.update();
				//
				game.setShowkWave(false);
				ex = true;
	
			}else throw new NoShockwaveException();
		}
		catch(NoShockwaveException e) {
			throw new CommandExecuteException(e.getMessage());
		}
		
		return ex;
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
				if (commandWords.length == 1) command = this;
				else throw new CommandParseException (incorrectNumArgsMsg);
			}
		}
		catch(CommandParseException e) {
			throw new CommandParseException(e.getMessage());
		}
	
		return command;
	}
	
}
