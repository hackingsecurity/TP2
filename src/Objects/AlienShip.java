//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;

public  abstract class AlienShip extends EnemyShip {
	public AlienShip(Game game, int posX, int posY, int live) {
		super(game, posX, posY, live);

	}

	public void move(){
	if((game.getCurrentCycle()%game.getLevel().getNumCyclesToMoveOneCell()) == 0 && game.getCurrentCycle()!=0){
		if(game.getCambiar()){
			this.posX += 1;
		}
		else {
			this.posY += game.getSentido();
		}
	}
		//cuando me voy a mover :
		// cuando ciclo %  Level
			
		
		
	}
	

}
