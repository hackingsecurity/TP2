//PAQUETE QUE LO CONTIENE
package Objects;
import Logic.Game;

public class UCMShip extends Ship{

	
	
	
	public UCMShip(Game game, int posX, int posY) {
							//LIVE
		super(game,posX, posY, 3);
		this.lanzado = false;
	}
	
	
	@Override
	public void computerAction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete() {}

	@Override
	public void move() {}

	public boolean move(int numCells) {

		boolean move = false;
		/*
		 * -SI VAMOS POR LA DERECHA
		 * -Si nuestro parametro es positivo
		 */
		if(numCells > 0) {
			if(this.posY + numCells < Game.DIM_Y) {
				move = true;
			}
		}
		/*
		 * -SI VAMOS POR LA IZQUIERDA
		 * -Si nuestro parametros es negativo
		 */
		else if (numCells < 0) {
			if((this.posY + numCells) >= 0) {
				move = true;
			}
		}
		
		return move;
	}


	public void move(String direccion, int numCasillas) {
		
		if(direccion.equals("left")){
			this.posY -= numCasillas;
		}else {
			this.posY += numCasillas;
		}
		
	}
	public boolean receiveBombAttack(int damage) {
		
		
		boolean hit = false;
		if(this.isAlive()) {
			
			getDamage(damage);
			//hit = true;
		}
		
		return hit;
		
	}


	@Override
	public String toString() {
		
		if(this.live > 0) return "^__^";
		else return "!xx?";
	}


}
