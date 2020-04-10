package commands;



import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import board.GamePrinter;
import board.Stringifier;
import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import logic.Game;

public class SaveCommand extends Command {

	public SaveCommand() {
		super("save", "s", "save", "save the actual game in a file");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		// TODO Auto-generated method stub
		GamePrinter printer = new Stringifier(game);
		String board = printer.toString();
		Scanner in = new Scanner(System.in);
		System.out.println("File name : \n");
		String file = in.nextLine();
		file = file+".dat";
		try {
			FileWriter save = new FileWriter(file);
			for(int i=0; i < board.length(); i++) {
				save.write(board.charAt(i));
			}
			save.close();
		} catch (IOException e) {
			e.getMessage();
		}
		
		System.out.println("Game successfully save in file <" + file + ">"
				+ "Use the load command to reload it");
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command command = null;
		
		
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 1) command = new SaveCommand();
			else throw new CommandParseException (incorrectNumArgsMsg);
			
		}
		
		return command;
	}
}