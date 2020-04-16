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
			
			if(commandWords.length == 1) command = new UpdateCommand();
			else throw new CommandParseException (incorrectNumArgsMsg);
			
			}
		}
		catch(CommandParseException e) {
			throw new CommandParseException(e.getMessage());
		}
		
		return command;
	}
	
}
