//PAQUETE QUE LO CONTIENE
package Objects;
import Logic.Game;

public class UCMShip extends Ship{

	
	/*El 
	 * 1) instancia de Game
	 * 2) coordenadas
	 * 3) live que cuenta UCMShip
	 */
	public UCMShip(Game game, int posX, int posY) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		
		if(this.live > 0) return "^__^";
		else return "!xx?";
	}


}
