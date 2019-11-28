package Control;

import Logic.Game;

public class ExitCommand extends Command{

	public ExitCommand() {
		super("exit", "e", "exit", "Terminates the program");
	}

	public boolean execute(Game game) {
		
		game.
		return true;
	}
	
	public Command parse(String[] commandWords)
	{
		Command command = null;
		
		if (matchCommandName(commandWords[0])) {
			command = new ExitCommand();
		}
		
		return command;
	}
	
}
