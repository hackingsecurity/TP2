package object;

import interfaces.IExecuteRandomActions;
import logic.Game;

/**
 * Crear los DestroyerAlien 
 * 
 *
 */
public class DestroyerAlien extends AlienShip{

	
	//-----------------VARIABLES----------------
	
	private boolean bomb;
	
	//-----------------CONTRUCTOR---------------
	
	public DestroyerAlien(Game game, int posX, int posY, int id) {
		super(game, posX, posY, 1, 10);
		this.bomb = false;
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

				game.addNewObject(new Bomb(this.game, this.posX, this.posY, this));
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

	
		//--------------OBJECT FORMAT OUTPUT-----------
	
	@Override
	public String toString(){
		 return "D[" + this.getLive()+ "]" ;
	}
	
	@Override
	public String stringifed() {
		return "Destroyer: "+ "D" + ";" + this.posX+","+this.posY + ";" 
				+ this.live + ";" + game.stringSent(AlienShip.sentido) + "\n";   
	}
}
