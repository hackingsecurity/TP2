package Control;

import Logic.Game;

public class ShootCommand extends Command{
	String tipo;
	public ShootCommand() {
		super("shoot", "s", "shoot", "UCM-Ship releases a shock wave");
	}
	public ShootCommand(String tipo) {
		super("shoot", "s", "shoot", "UCM-Ship releases a shock wave");
		this.tipo = tipo;
	}

	public boolean execute(Game game) {
		
		boolean ex = false;
		if(game.shootMissile()){
			
			System.out.println("ya hay misil en partida");
			ex = false;
		}else {
			if(this.tipo.equals("m")) 
			{
					game.enableMissile();
					game.update();
					
					//game.update();
			
			}
			else if (this.tipo.equals("s")){
				if(game.getSuperMisil() > 0) {
					game.enableSuperMissile();
					game.update();
					
				}
				else {
					System.out.println("no tienes superMisiles");
					
				}
				ex = true;
			}
		}
		return ex;
		
	}

	
	public Command parse(String[] commandWords)
	{
	Command command = null;
		
		if (commandWords.length == 2 && matchCommandName(commandWords[0])) {
	
			if (commandWords[1] != null ) {
					if ((commandWords[1].equals("m")) || (commandWords[1].equals("s"))) {
					{
						command = new ShootCommand(commandWords[1]);
					}
				}
			}
		}
		return command;
	}
}
