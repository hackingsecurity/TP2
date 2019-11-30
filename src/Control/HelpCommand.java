//PAQUETE QUE LO CONTIENE
package Control;
//PAQUETE QUE NECESITA PARA OPERAR
import Logic.Game;


public class HelpCommand extends Command{

	
	public HelpCommand() {
		super("help", "h", "help", "Prints help message");
	}

	public boolean execute(Game game) {
		
		String helpText = CommandGenerator.commandHelp(); 
		System.out.println(helpText);
		return true;
	}
	
	public Command parse(String[] commandWords)
	{
		Command command = null;
		
		if (!(commandWords.length > 1)) {
			if (matchCommandName(commandWords[0])) {
				command = new HelpCommand();
			}
		}
		return command;
	}
	
}
