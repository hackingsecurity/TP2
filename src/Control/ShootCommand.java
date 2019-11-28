package Control;

//import Logic.Game;

public class ShootCommand extends Command{
	public ShootCommand() {
		super("shoot", "s", "shoot", "UCM-Ship releases a shock wave");
	}

	/*public boolean execute(Game game) {
		
		return true;
	}*/
	
	public Command parse(String[] commandWords)
	{
		Command command = null;
		
		//cadenas de caracteres
		if (matchCommandName(commandWords[0])) {
			command = new ShootCommand();
		}
		
		return command;
	}
	
}
