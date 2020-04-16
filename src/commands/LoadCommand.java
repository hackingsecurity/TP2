package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import exceptions.CommandExecuteException;
import exceptions.CommandParseException;
import exceptions.FileContentsException;
import logic.Game;

public class LoadCommand extends Command {

	public LoadCommand() {
		super("load", "l", "load", "load a previous game");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		
		
		Scanner ent = new Scanner(System.in);
		System.out.println("Type file name you want to load ");
		String file = ent.nextLine();
		String header = null;
		
		//añadimos el .dat al archivo que queremos cargar
		file = file+".dat";
		File fichero = new File(file);
		
		
		
		try {
			//guardamos nuestra partida actual.
			game.save(Game.FILETMP);
			
			if (fichero.exists()) {

				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				header = br.readLine();
				// esto se utilizaría para quitar todas los object que existan.
				if(header.equals("--- Space Invaders v2.0 ---")) {
					header = br.readLine();
					game.load(br);
				}
			//carga
				System.out.println("Game loaded succesfully from file <"+file+">");
			}
			else {
				loadOld(game);
				System.err.println( " " + file + "doesn't exist");
			}
			//debemos saber si existe el arhivo.
			
			
		}catch (IOException e) {
			
			e.getMessage();
		} catch (FileContentsException e) {
		// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
		
		return true;
		
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
			Command command = null;
		
		
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 1) command = new LoadCommand();
			else throw new CommandParseException (incorrectNumArgsMsg);
			
		}
		
		return command;
	}
	
	private void loadOld(Game game) {
		
		try {
			
			String file = Game.FILETMP + ".dat";
			FileReader r = new FileReader(file);
			BufferedReader br = new BufferedReader(r);
			String header = br.readLine();
			// esto se utilizaría para quitar todas los object que existan.
			if(header.equals("--- Space Invaders v2.0 ---")) {
				header = br.readLine();
				game.load(br);
			}
		} catch (IOException | FileContentsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}