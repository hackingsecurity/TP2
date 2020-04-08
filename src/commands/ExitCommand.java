package commands;

import exceptions.CommandParseException;
import logic.Game;

public class ExitCommand extends Command{

	public ExitCommand() {
		super("exit", "e", "exit", "Terminates the program");
	}

	public boolean execute(Game game) {
		game.exit();
		return true;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException
	{
		Command command = null;
		
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 1) command = new ExitCommand();
			else throw new CommandParseException (incorrectNumArgsMsg);
		}
	
		return command;
	}
	
}
