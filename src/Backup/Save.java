package Backup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Save {
	
	//ATRIBUTES
	
	private PrinterTypes printers;
	private String filename;
	private Game game;
	
	//CONSTRUCTOR
	
	public Save(Game game) {
		printers = printers.STRINGIFIER;
		this.game = game;
	}
	
	//ATRIBUTES
	
public boolean saveGame() throws IOException {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		filename = (input.nextLine() + ".dat");
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.filename)));
		
		
		
		
		GamePrinter saving = printers.getObject(game);
		out.println(saving.toString());
		
		System.out.println("Game successfully saved in file " + filename);
	    out.close();
	    
	    return true;
	}

}
