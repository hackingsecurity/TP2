//PAQUETE QUE LO CONTIENE
package object;

import interfaces.IExecuteRandomActions;
import logic.Game;

public class DestroyerAlien extends AlienShip implements IExecuteRandomActions {

	public DestroyerAlien(Game game, int posX, int posY, int id) {
		super(game, posX, posY, 1);
		this.lanzado = false;
		this.id = id;
	}



	
	public void computerAction() {
		// TODO Auto-generated method stub
		super.computerAction();	
		
	
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

	public String stringifed() {
		return "Destroyer: "+ "D" + ";" + this.posX+","+this.posY + ";" 
				+ this.live + ";" + game.stringSent(AlienShip.getSentido()) + "\n";   
	}

	
	public String toString(){
		 return "D[" + this.getLive()+ "]" ;
	}
}
