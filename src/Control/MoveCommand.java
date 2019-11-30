package Control;

import Logic.Game;

//import Logic.Game;

public class MoveCommand extends Command{
	
	
	private int numCasillas;
	private String direccion;
	
	public MoveCommand() {
		super("move", "m", "move<left|right><1|2>", "Moves UCM-Ship to the indicated direction");
		
	}
	
	public MoveCommand(String direccion, int i) {
		super("move", "m", "move<left|right><1|2>", "Moves UCM-Ship to the indicated direction");
		this.numCasillas = i;
		this.direccion = direccion;
	}

	public boolean execute(Game game) {
		/*
		boolean ex = false;
		if(!game.comprobarMoverUcmShip(this.direccion,this.numCasillas))
	 	{
			System.out.println("UCMship cannot move here");
			ex = false;
			
		}
		else {
			ex = true;
		}
		return ex;
	*/
		return true;
	}
	
	
	/*
	 * 1)COMPROBAMOS EL TAMAÑO DEL ARARY PARA MOVE (TRES DATOS)
	 * 2)COMPROBAMOS LA PRIMERA POSICON DEL ARRAY
	 * 3)COMPROBAMOS LA PRIMERA Y SEGUNDA POSICIÓN DEL ARRAY
	 */
	public Command parse(String[] commandWords)
	{
		Command command = null;
		
		if (commandWords.length == 3 && matchCommandName(commandWords[0])) {
	
			if (commandWords[2] != null && commandWords[1] != null) {
					
				if ((commandWords[1].equals("left")) || (commandWords[1].equals("right"))) {
					
					if((Integer.parseInt(commandWords[2]) == 1) ||  (Integer.parseInt(commandWords[2]) == 2)) {
						
						command = new MoveCommand(commandWords[1], Integer.parseInt(commandWords[2]));
					}
				}
			}
		}
		return command;
	}
}
