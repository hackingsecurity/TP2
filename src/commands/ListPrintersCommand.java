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
			
			if (commandWords.length == 1) command = new ListPrintersCommand();
			else throw new CommandParseException (incorrectNumArgsMsg);
		}
		
		return command;
	}


}
