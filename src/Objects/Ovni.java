package Objects;

import Logic.Game;

public class Ovni extends AlienShip {
	
	/*
	 * EL Ovni lo creamos al inicializar el tablero
	 * Pero controlamos la visibilidad del objeto.
	*/
	boolean visibilidadOvni;

	public Ovni(Game game) {
		//Game, posX, posY, live
		super(game, 0 ,8, 1 );
		this.visibilidadOvni = false;
		
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
		return "O[" + this.live + "]" ;
	}
}
