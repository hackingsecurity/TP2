package Control;


import Logic.Game;

public class ListCommand extends Command {


	public ListCommand() {
		super("List", "l", "list", "Prints the list of available ships");
	}

	public boolean execute(Game game) {
		game.list();
		return true;
	}
	
	public Command parse(String[] commandWords)
	{
		Command command = null;
		
		//cadenas de caracteres
		if (matchCommandName(commandWords[0])) {
			command = new ListCommand();
		}
		
		return command;
	}
	
	
}
