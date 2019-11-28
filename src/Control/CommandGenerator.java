package Control;

public class CommandGenerator {
	
	/*
			 * Este atributo se usa en los dos siguientes métodos de CommandGenerator:
		public static Command parseCommand(String[ ] commandWords), que, a su vez, in-
		voca el método parse de cada subclase de Command, tal y como se ha explicado
		anteriormente,
		public static String commandHelp(), que tiene una estructura similar al método an-
		terior, pero invocando el método helpText() de cada subclase de Command. Este
		método es invocado por el método execute de la clase HelpCommand.
	 */
	
	//NUESTRO ATRIBUTO QUE ALMACENARÁ UNA INSTANCIA DE CADA COMANDO
	
	private static Command[] availableCommands = {
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new ListCommand(),
			new UpdateCommand(),
			new MoveCommand(),
			new ShockwaveCommand()
			};
	
	
	//ESTA FUNCIÓN RECIBE LOS PARAMETRO DEL CONTROLER
		//-PASAR ESTOS PARAMETROS A cada una de las clase.
	
	public static Command parseCommand(String[ ] commandWords) {
		
		//CREAMOS UN REFERENCIA DEL OBJETO COMMAND Y LO INICIALIAZAMOS A NULL
		
		Command command = null;
		for(Command availableCommands : availableCommands) {
			
			//es recorrer el array de objetos ( availableCommands y preguntar
			// a cada metodo parse si el comandWords es suyo o no.
			//nos retorna un null o el objeto que responde a la llamada
				
			command = availableCommands.parse(commandWords);
			
			if((command != null)) 
				return command;
		}
		return command;
	}
	
	
	public static String commandHelp() {
		
		String helpText = null;
		for(Command availableCommands : availableCommands) {
			helpText  = availableCommands.helpText();
			if((helpText != null)) {
				break;
			}
		}				
		return helpText;
					
	}
}
