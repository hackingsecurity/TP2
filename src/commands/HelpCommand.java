//PAQUETE QUE LO CONTIENE
package commands;
import exceptions.CommandParseException;
import logic.Game;
import utils.CommandGenerator;


public class HelpCommand extends Command{

	
	public HelpCommand() {
		super("help", "h", "help", "Prints help message");
	}

	public boolean execute(Game game) {
		System.out.println(game.helpText());
		return false; //No ejecutamos otra pantalla
	}
	
	public Command parse(String[] commandWords) throws CommandParseException
	{
		Command command = null;
		
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 1) command = new HelpCommand();
			else throw new CommandParseException (incorrectNumArgsMsg);	
		}
		
		return command;
	}
	
}
