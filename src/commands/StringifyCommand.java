package commands;

import board.GamePrinter;
import board.PrinterTypes;
import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class StringifyCommand extends Command{
	
	
	public StringifyCommand() {
		super("stringify", "st", "[st]ringify", "prints the game formatted as a board of dimension");

	}

	public boolean execute(Game game) throws CommandExecuteException {
		
		/* no has usado PrinterTypes para crear impresoras
		   + printer = PrinterTypes.STRINGIFIER.getObject(game)
		 */
		GamePrinter printer = PrinterTypes.STRINGIFIER.getObject(game);
		System.out.println(printer);
		return false;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		
		Command command = null;
		
		try {
	
			if (matchCommandName(commandWords[0])) {
				/*
				 * - Command Pattern
					  * parse de comandos sin parámetros puede devolver "this" en vez de "new XXCommand"
					  + es lo que permite subir el método parse a una superclase "NoParamsCommand"
				 */
				if(commandWords.length == 1) command = this;
				else throw new CommandParseException(incorrectNumArgsMsg);
			}
		}
		catch(CommandParseException e) {
			throw new CommandParseException(e.getMessage());
		}
		
		return command;
	}

}
