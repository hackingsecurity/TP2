package comandos;

import Exeptions.CommandExecuteException;
import Exeptions.CommandParseException;
import Logic.Game;
import board.PrinterTypes;

public class ListPrintersCommand extends Command {
	

	public ListPrintersCommand() {
		super("Printers", "p", "Printers List", "Show Shows a list of printers");
		
	}

	public boolean execute(Game game) throws CommandExecuteException {
		System.out.println(PrinterTypes.printerHelp(game));
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
