package commands;

import board.PrinterTypes;
import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class ListPrintersCommand extends Command {
	

	public ListPrintersCommand() {
		super("Printers", "p", "[p]rinters", "Show Shows a list of printers");
		
	}

	public boolean execute(Game game) throws CommandExecuteException {
		System.out.println(game.listPrinterCommand());
		return false;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		
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
