package Backup;

import Control.Command;
import Logic.Game;

import java.io.IOException;

import Exceptions.CommandExecuteException;
import Exceptions.CommandParseException;

public class SaveCommand extends Command{
	
	//CONSTRUCTOR
	public SaveCommand() {
		super("save", "v", "Save", "Saves the game.");
	}
	
	//METHODS
	public boolean execute(Game game) {
		try {
			game.saveGame();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public Command parse(String[] commandWords){
		if(super.matchCommandName(commandWords[0])) {
			SaveCommand command = new SaveCommand();
			return command;
		}
		else {
			return null;
		}
	}
}
