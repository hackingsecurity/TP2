package Control;

//import Logic.Game;

public class ShockwaveCommand extends Command{
	public ShockwaveCommand() {
		super("shockwave", "w", "shockWave", "UCM-Ship releases a shock wave");
	}

	/*public boolean execute(Game game) {
		
		return true;
	}*/
	
	public Command parse(String[] commandWords)
	{
		Command command = null;
		
		//cadenas de caracteres
		if (matchCommandName(commandWords[0])) {
			command = new ShockwaveCommand();
		}
		
		return command;
	}
	
}
