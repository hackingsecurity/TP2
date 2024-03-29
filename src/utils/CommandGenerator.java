package utils;

import commands.*;
import exceptions.CommandParseException;

public class CommandGenerator {
	
	//INICIALIZAMOS TODOS NUESTROS COMANDOS
	private static Command[] availableCommands = {
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(),
			new MoveCommand(),
			new ShockwaveCommand(),
			new ShootCommand(),
			new BuyCommand(),
			new StringifyCommand(),
			new ListPrintersCommand(),
			new SaveCommand(),
			new LoadCommand()
			};
	
	
	//
	
	
	/*
	 *	1 -Recibe la entrada desde consola
	 *	2 -Creamos un tipo Command (polimofismo) guarda los objeto
	 *	3 -Recorremos el array con un for-each
	 *	4 -LLamamos el parse de cada uno de nuestros objetos en el array
	 *	5 -Retornamos... 
	 */
	
	public static Command parseCommand(String[ ] commandWords) throws CommandParseException {
		
		
		//Polimofismo Commmand --> cualquier clase hija.
		Command command = null;
		
		for(Command c : availableCommands) {
			
			command = c.parse(commandWords);
			//Si hemos encontrado un objeto
			if((command != null)) 
				return command;
		}
		//if(command == null) throw new CommandParseException("Incorrect Command");
		
		return command;
	}
	
	/*
	 *	 -Incova el metodo helpText() de cada una de las clases
	 *	 -Este metodo es invocado por el metodo execute de helpCommand
	 */
	
	public static String commandHelp() {
		
		String helpText = "";
		
		for(Command availableCommands : availableCommands) {
			helpText  += availableCommands.helpText();
		
		}	
		return helpText;			
	}
}
