package Control;

import Logic.Game;

public class ShootCommand extends Command{
	
	public ShootCommand() {
		super("shoot", "s", "shoot", "UCM-Ship releases a shock wave");
	}

	public boolean execute(Game game) {
		
		boolean ex = false;
		
		if(game.shootMissile()){
			
			System.out.println("ya hay misil en partida");
			ex = false;
		}
		else {
			game.enableMissile();
			ex = true;
			game.update();
		}
		
		return ex;
		
	}

	
	public Command parse(String[] commandWords)
	{
		Command command = null;
		
		if (!(commandWords.length > 1)) {
			if (matchCommandName(commandWords[0])) {
				command = new ShootCommand();
			}
		}
		return command;
	}
	
}
