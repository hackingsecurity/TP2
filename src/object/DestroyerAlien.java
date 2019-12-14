//PAQUETE QUE LO CONTIENE
package object;

import Logic.Game;
import interfaces.IExecuteRandomActions;

public class DestroyerAlien extends AlienShip implements IExecuteRandomActions {

	public DestroyerAlien(Game game, int posX, int posY, int id) {
		super(game, posX, posY, 1);
		this.lanzado = false;
		this.id = id;
	}



	
	public void computerAction() {
		// TODO Auto-generated method stub
		super.computerAction();	
		
		//la logica que nec
		if(IExecuteRandomActions.canGenerateRandomBomb(game)) {
			if(this.lanzado == false) {
				game.activarBomba(this.posX, this.posY, this.id);
				this.lanzado = true;
			}
		}
	}

	
	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		game.receivePoints(10);
		AlienShip.setContador();
	}

	public String stringifie() {
		return "D" + ";" + super.stringifed() + ";" 
				+ this.live + ";" + AlienShip.getSentido() ;   
	}

	
	public String toString(){
		 return "D[" + this.getLive()+ "]" ;
	}
}
