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

	private String nameFile;
	
	public LoadCommand() {
		super("load", "d", "loa[d]", "load a previous game");
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Contructora para llamar por promnt
	 */
	public LoadCommand(String nameFile) {
		super("load", "d", "loa[d]", "load a previous game");
		this.nameFile = nameFile;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		
	
		/*
		* load command no debería añadir ".dat" (el usuario lo tiene que teclear explícitamente)
		
		*/
		
		String header = null;
		File fichero = new File(nameFile);
		
		/*
		 * loadOLd
		 */
					
		try {
			//guardamos nuestra partida actual.
			game.save(Game.FILETMP);
			
			if (fichero.exists()) {

				/*
				 * 1) Creamos nuestro fichero
				 * 2) Buffer para la tranferencia de datos
				 * 3) carga de datos en una variable String
				 */
				FileReader fr = new FileReader(nameFile);
				BufferedReader br = new BufferedReader(fr);
				header = br.readLine();
				// esto se utilizaría para quitar todas los object que existan.
				if(header.equals("--- Space Invaders v2.0 ---")) {
					header = br.readLine();
					game.load(br);
				}
			//carga
				System.out.println("Game loaded succesfully from file <"+nameFile+">");
			}
			else {
				loadOld(game);
				System.err.println( " " + nameFile + "doesn't exist");
			}
			//debemos saber si existe el arhivo.
			
			
		}catch (IOException e) {
			e.getMessage();
		} catch (FileContentsException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(!game.getLoading()) {
				loadOld(game);
			}
		}
		
		
		
		
		
		
		return true;
		
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		
		Command command = null;
		
		/*
		 * Este va tener dos parametros
		 * 
		 * [0] va ser nuestro comando load or d
		 * [1] va ser el archivo
		 * 
		 * * * método load de Game: game no debería terminar si el formato del fichero es incorrecto
    		+ ¿qué pasa si un error de formato del fichero provoca otro tipo de excepción? 
		 */
			
		if (matchCommandName(commandWords[0])) {
			if (commandWords.length == 2) {
				String aux = commandWords[1];
				
				if(aux.split("\\.")[1].equalsIgnoreCase("dat")) {
					command = new LoadCommand(aux);
				}else throw new CommandParseException("Format file error, you don't use .dat!"); 
				
			}else throw new CommandParseException (incorrectNumArgsMsg);
				
		}
		
		return command;
	}
	
	private void loadOld(Game game) {
		
		try {
			
			String file = Game.FILETMP;
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