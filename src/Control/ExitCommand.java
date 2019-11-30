package Control;

import Logic.Game;

public class ExitCommand extends Command{

	public ExitCommand() {
		super("exit", "e", "exit", "Terminates the program");
	}

	public boolean execute(Game game) {
		
		game.exit();
		return true;
	}
	
	public Command parse(String[] commandWords)
	{
		Command command = null;
		
		if (!(commandWords.length > 1)) {
			
			if (matchCommandName(commandWords[0])) {
				command = new ExitCommand();
			}
		
		}
	
		return command;
	}
	
}
