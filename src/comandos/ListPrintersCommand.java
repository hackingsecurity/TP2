package comandos;

import Exeptions.CommandExecuteException;
import Exeptions.CommandParseException;
import Logic.Game;

public class ListPrintersCommand extends Command {
	

	public ListPrintersCommand() {
		super("Printers", "p", "Printers List", "Show Shows a list of printers");
		
	}

	public boolean execute(Game game) throws CommandExecuteException {
	
		return true;
	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		
		Command command = null;
		
		if (commandWords.length == 1) {
			if (matchCommandName(commandWords[0])) {
				command = new ResetCommand();
			}
		}else throw new CommandParseException (incorrectNumArgsMsg);
		
		return command;
	}


}
