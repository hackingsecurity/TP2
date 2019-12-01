//PAQUETE QUE LO CONTIENE
package Objects;
import Logic.Game;

public class UCMShip extends Ship{

	
	public UCMShip(Game game, int posX, int posY) {
							//LIVE
		super(game,posX, posY, 3);
	}

	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		
	}

	@Override
	public String toString() {
		
		if(this.live > 0) return "^__^";
		else return "!xx?";
	}


}
