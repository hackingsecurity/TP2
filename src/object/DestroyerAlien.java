package object;

import interfaces.IExecuteRandomActions;
import logic.FileContentsVerifier;
import logic.Game;

/**
 * Crear los DestroyerAlien 
 * 
 *
 */
public class DestroyerAlien extends AlienShip{

	
	//-----------------VARIABLES----------------
	private static int currentSerialNumber;
	
	private boolean bomb;
	
	//-----------------CONTRUCTOR---------------
	
	public DestroyerAlien(Game game, int posX, int posY) {
		super(game, posX, posY, 1, 10,"D");
		this.bomb = false;
	}
	public DestroyerAlien(Game game, int posX, int posY,int life,String sentido) {
		super(game, posX, posY, life, 10,"D");
		this.bomb = false;
		if(sentido.equals("<-")) AlienShip.sentido = -1;
		else if(sentido.equals("->")) AlienShip.sentido = 1;
	}


	public DestroyerAlien() {
		// TODO Auto-generated constructor stub
	}

	//--------------GETTER AND SETTER-----------
	public boolean getBomb() { return this.bomb; }
	public void setBomb(boolean bomb) {this.bomb = bomb;}
	


	//--------------ABSTRACT METHODS------------
	
	
	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		super.computerAction();	
		
	
		if(IExecuteRandomActions.canGenerateRandomBomb(game)) {
			if(this.bomb == false) {

				game.addNewObject(new Bomb(this.game, this.posX, this.posY, this, this.label));
				this.bomb = true;
			}
		}
	}

	
	@Override
	public void onDelete() {
		
		if(!this.isAlive()) {
			game.receivePoints(10);
			AlienShip.contadorAlien--;
		}
	}
	public boolean isOwner(int ref) {
		boolean itsMe = super.isOwner(ref);
		if(itsMe) this.bomb = false;
		return itsMe;
	}

	
		//--------------OBJECT FORMAT OUTPUT-----------
	
	@Override
	public String toString(){
		 return "D[" + this.getLive()+ "]" ;
	}
	
	
	protected GameObject parse(String stringFromFile, Game game, FileContentsVerifier verifier) {
		if(stringFromFile.split(";")[0].equalsIgnoreCase("D")) {
			int armour  =Integer.parseInt(stringFromFile.split(";")[2]);
			if(!verifier.verifyAlienShipString(stringFromFile, game,armour)) return null;

			String coordenadas = stringFromFile.split(";")[1]; // recoge las coordenadas
			
			return new DestroyerAlien(game,Integer.parseInt(coordenadas.split(",")[0]),
					Integer.parseInt(coordenadas.split(",")[1]),armour,stringFromFile.split(";")[3]);
		}
		
		return null;
	}
	private void initialiseLabelling() {
		currentSerialNumber = 1;
	}
	private String generateStringifyLabel() {
		label = currentSerialNumber;
		currentSerialNumber++;
		return labelRefSeparator + label;
	}
	public String stringifed() {
		if(!game.isStringifying()) {
			game.setStringifying();
			initialiseLabelling();
		}
		
		return super.stringifed() +  generateStringifyLabel();
	}
	
}
