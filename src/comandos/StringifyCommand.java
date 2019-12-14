package comandos;

import Exeptions.CommandExecuteException;
import Exeptions.CommandParseException;
import Logic.Game;

public class StringifyCommand extends Command{
	
	
	public StringifyCommand() {
		super("stringify", "st", "boardprinter", "prints the game formatted as a board of dimension");

	}

	public boolean execute(Game game) throws CommandExecuteException {
	
		return true;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		
		Command command = null;
		
		if (commandWords.length == 1){
			if (matchCommandName(commandWords[0])) {
				command = new ResetCommand();
			}
		}else throw new CommandParseException (incorrectNumArgsMsg);
		
		return command;
	}

}
