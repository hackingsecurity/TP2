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
		super(game, 0 ,9, 1 );
		this.visibilidadOvni = false;
		
	}

	@Override
	public void computerAction() {
		if(!this.visibilidadOvni){
			int prob;
			double probOvni = game.getLevel().getOvniFrequency()* 10;
			int probO = (int)(probOvni);
			prob = game.getRandom().nextInt(10)+1;
			
			if(prob>0 && prob <= probO ){
				 this.visibilidadOvni= true;
				 
			}
		}
	}


	@Override
	public void onDelete() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void move() {
		if(this.visibilidadOvni){
			if(this.posY != 0){
				this.posY -= 1;
			}
			else{
				this.visibilidadOvni = false;
				this.posX = 0;
				this.posY = 9;
			}
		}
		
	}
	
	@Override
	public String toString() {
		
		if(visibilidadOvni) {
			return "O[" + this.live + "]" ;
		}
		
		return null;
	}
}
