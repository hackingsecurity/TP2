package Control;

import Logic.Game;

public class ShockwaveCommand extends Command{
	
	public ShockwaveCommand() {
		super("shockwave", "w", "shockWave", "UCM-Ship releases a shock wave");
	}

	public boolean execute(Game game) {
		/*
		boolean ex = false;
		if(game.getShockWave()) {
			
			game.shockWaveShips();
			game.setShockWave(false);
			ex = true;
			
		}else {
			System.out.println("NO HAY SHOCKWAVE DISPONIBLE");
			ex = false;
		}
		return ex;
	}*/
		return true;
	}
	
	public Command parse(String[] commandWords)
	{
		Command command = null;
		
		if (!(commandWords.length > 1)) {
			if (matchCommandName(commandWords[0])) {
				command = new ShockwaveCommand();
			}
		}
		return command;
	}
	
}
