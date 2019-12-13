package Control;

public class CommandGenerator {
	
	/*
			 * Este atributo se usa en los dos siguientes mÃ©todos de CommandGenerator:
		public static Command parseCommand(String[ ] commandWords), que, a su vez, in-
		voca el mÃ©todo parse de cada subclase de Command, tal y como se ha explicado
		anteriormente,
		
		public static String commandHelp(), que tiene una estructura similar al mÃ©todo an-
		terior, pero invocando el mÃ©todo helpText() de cada subclase de Command. Este
		mÃ©todo es invocado por el mÃ©todo execute de la clase HelpCommand.
	 */
	
	
	/*
	 *	1 -Creamos un array de  tipo Command y lo inicializamos
	 *		a cada uno los objetos que va a manipular.
	 * 	2-Uso de polimorfismo
	 * 	3-Podemos crear distintos objetos hijos a Command (abstract)
	 * 	4-Solo hay una copia del mismo y su valor es compartido por 
	 * 	todos los objetos de la clase.
	 */
	
	private static Command[] availableCommands = {
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new UpdateCommand(),
			new MoveCommand(),
			new ShockwaveCommand(),
			new ShootCommand(),
			new BuyCommand()
			};
	
	
	//
	
	
	/*
	 *	1 -Recibe la entrada desde consola
	 *	2 -Creamos un tipo Command (polimofismo) guarda los objeto
	 *	3 -Recorremos el array con un for-each
	 *	4 -LLamamos el parse de cada uno de nuestros objetos en el array
	 *	5 -Retornamos... 
	 */
	
	public static Command parseCommand(String[ ] commandWords) {
		
		
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
