package comandos;
import Exeptions.*;
import Logic.Game;

public class ResetCommand extends Command {
	
	public ResetCommand() {
		super("reset", "r", "reset", "Starts a new game");
	}

	public boolean execute(Game game) throws CommandExecuteException {
		
		game.reset();
		return true;

	}
	
	public Command parse(String[] commandWords) throws CommandParseException {
		
		Command command = null;

		if (matchCommandName(commandWords[0])) {
			if(commandWords.length == 1) command = new ResetCommand();
			else throw new CommandParseException (incorrectNumArgsMsg);
		}
		
		return command;
	}
	
}
