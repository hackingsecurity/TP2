//PAQUETE QUE LO CONTIENE
package Objects;

import Logic.Game;

public class DestroyerAlien extends AlienShip {

	private boolean lanzado;
	private int id;


	public DestroyerAlien(Game game, int posX, int posY, int live, int id) {
		super(game, posX, posY, live);
		this.lanzado = false;
		this.id = id;
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
	public String toString(){
		 return "D[" + this.getLive()+ "]" ;
	}
}
