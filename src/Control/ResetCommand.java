package Control;

import Logic.Game;

public class ResetCommand extends Command {
	
	public ResetCommand() {
		super("reset", "r", "reset", "Starts a new game");
	}

public boolean execute(Game game) {
		
		game.reset();
		return true;
	}
	
	public Command parse(String[] commandWords)
	{
		Command command = null;
		
		//cadenas de caracteres
		if (matchCommandName(commandWords[0])) {
			command = new ResetCommand();
		}
		
		return command;
	}
	
}
