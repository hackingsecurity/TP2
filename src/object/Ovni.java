package object;

import Logic.Game;
import interfaces.IExecuteRandomActions;

public class Ovni  extends EnemyShip implements IExecuteRandomActions {
	
	/*
	 * EL Ovni lo creamos al inicializar el tablero
	 * Pero controlamos la visibilidad del objeto.
	*/
	private boolean visibilidadOvni;

	public Ovni(Game game) {
		//Game, posX, posY, live
		super(game, 0 ,9, 1 );
		this.visibilidadOvni = false;
		
	}
	
	@Override
	public void computerAction() {
		
	
		if(!this.visibilidadOvni){
			
			if(IExecuteRandomActions.canGenerateRandomOvni(this.game)) {
					this.visibilidadOvni = true;
					
					
			}
		}
	}

	

	@Override
	public void onDelete() {
		
		game.receivePoints(25);
		
	}
	public boolean receiveMissileAttack(int damage) {
		boolean hit = false;
		if(this.isAlive()) {
			this.live -= damage;
			game.setShockwave(true);
			hit = true;
		}
			return hit;
		};
	public boolean receiveSuperMissileAttack(int damage) {
			boolean hit = false;
			if(this.isAlive()) {
				this.live -= damage;
				game.setShockwave(true);
				hit = true;
			}
				return hit;
	};
	public boolean receiveShockWaveAttack(int damage) {
			boolean hit = false;
			if(this.isAlive()) {
				this.visibilidadOvni = false;
				hit = true;
				}
			return hit;
		};
		
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
	
	public String stringifie() {
		return "O" + super.stringifed() + ";" + this.live;
	}
	
	@Override
	public String toString() {
		
		if(visibilidadOvni) {
			return "O[" + this.live + "]" ;
		}
		
		return null;
	}
}
