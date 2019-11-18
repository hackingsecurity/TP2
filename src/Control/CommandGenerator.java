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
	
	public static Command parseCommand(String[ ] commandWords)
	public static String commandHelp()
}
