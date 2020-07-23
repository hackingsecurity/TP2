package commands;

import board.GamePrinter;
import board.Stringifier;
import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class StringifyCommand extends Command{
	
	
	public StringifyCommand() {
		super("stringify", "st", "[st]ringify", "prints the game formatted as a board of dimension");

	}

	public boolean execute(Game game) throws CommandExecuteException {
		
		GamePrinter printer = new Stringifier(game);
		System.out.println(printer);
		return false;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		
		Command command = null;
		
		try {
	
			if (matchCommandName(commandWords[0])) {
				
				if(commandWords.length == 1) command = new StringifyCommand();
				else throw new CommandParseException(incorrectNumArgsMsg);
			}
		}
		catch(CommandParseException e) {
			throw new CommandParseException(e.getMessage());
		}
		
		return command;
	}

}
