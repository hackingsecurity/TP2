package comandos;

import Exeptions.CommandParseException;

public class CommandGenerator {
	
	
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
			new ListPrintersCommand()
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
		
		for(Command availableCommands : availableCommands) {
			
			command = availableCommands.parse(commandWords);
			//Si hemos encontrado un objeto
			if((command != null)) 
				return command;
		}
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
