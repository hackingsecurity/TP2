package comandos;

import Exeptions.CommandParseException;
import Logic.Game;

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
		
		if (commandWords.length == 1) {
			
			if (matchCommandName(commandWords[0])) {
				command = new ExitCommand();
			}
		}else throw new CommandParseException (incorrectNumArgsMsg);
	
		return command;
	}
	
}
