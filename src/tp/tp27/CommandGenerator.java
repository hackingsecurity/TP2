package tp.p2;

public class CommandGenerator {
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
