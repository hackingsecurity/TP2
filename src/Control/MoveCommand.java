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

	/*
	 * COMPROBAMOS SI ESTAMOS EN FUERA DEL TABLERO AL MOVER
	 * 
	 */
	public boolean execute(Game game) {
		
		boolean move = false;
		
		if(this.direccion.equals("left")) {
			if(game.move(this.numCasillas * -1)) {
				game.move(direccion, numCasillas);
				move = true;
			}
		}
		else{
			if(game.move(this.numCasillas )) {
				game.move(direccion, numCasillas);
				move = true;
			}
		}
		game.update();
		if (move == false) {
			System.out.println("You can`t move UCMShip : " + this.direccion + ", Position: " + this.numCasillas );
		}
		return move;
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
