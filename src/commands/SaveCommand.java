package commands;


import java.io.IOException;


import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class SaveCommand extends Command {

	
	private String nameFile;
	
	public SaveCommand() {
		super("save", "v", "sa[v]e", "save the actual game in a file");
		// TODO Auto-generated constructor stub
	}

	public SaveCommand(String nameFile) {
		super("save", "v", "sa[v]e", "save the actual game in a file");
		this.nameFile = nameFile;
	}
	
	public boolean execute(Game game) throws CommandExecuteException {
		
		boolean exe = false;
		
		
		try {
			
			
			if (game.save(this.nameFile)) {
				exe = false;
			}
			System.out.println("Game successfully save in file < " +  nameFile + " >"
					+ "Use the load command to reload it");
		}
		catch (IOException e) {
				throw new CommandExecuteException("save error");
				
		}
		
		return exe;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		
		
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 2) {
				String aux = commandWords[1];
				if(aux.split("\\.")[1].equalsIgnoreCase("dat")) {
					command = new SaveCommand(aux);
				}
			}
			else throw new CommandParseException (incorrectNumArgsMsg);
			
		}
		
		return command;
	}
}
