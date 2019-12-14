package comandos;

import Exeptions.CommandParseException;
import Logic.Game;

public class ListCommand extends Command {


	public ListCommand() {
		super("List", "l", "list", "Prints the list of available ships");
	}

	public boolean execute(Game game) {
		game.list();
		return true;
	}
	
	
	public Command parse(String[] commandWords) throws CommandParseException
	{
		
		
		Command command = null;
		
		if (commandWords.length == 1) {
			if (matchCommandName(commandWords[0])) {
				command = new ListCommand();
			}
		}else throw new CommandParseException (incorrectNumArgsMsg);
		
		return command;
	}
}
