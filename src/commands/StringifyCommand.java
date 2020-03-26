package commands;

import board.PrinterTypes;
import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class StringifyCommand extends Command{
	
	
	public StringifyCommand() {
		super("stringify", "st", "boardprinter", "prints the game formatted as a board of dimension");

	}

	public boolean execute(Game game) throws CommandExecuteException {
		
		System.out.println(PrinterTypes.BOARDPRINTER.getObject(game));
		
		return false;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		
		Command command = null;
		
		if (matchCommandName(commandWords[0])) {
			
			if(commandWords.length == 1) command = new StringifyCommand();
			else throw new CommandParseException(incorrectNumArgsMsg);
		}
		
		return command;
	}

}
